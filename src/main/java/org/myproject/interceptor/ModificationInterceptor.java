package org.myproject.interceptor;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.myproject.token.Token;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * 防止重复提交拦截器
 * @author Czw
 *
 */
public class ModificationInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e)
			throws Exception {

	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		request.setCharacterEncoding("utf-8");
		if (handler instanceof HandlerMethod) {//判断请求目标对象是不是方法处理器的实例
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();//获得方法处理类
            if(method.isAnnotationPresent(Token.class)){//得到自定义注解
            	Token token = method.getAnnotation(Token.class);//获取自定义注解属性
            	if(token.save()){
            		request.getSession(false).setAttribute("token",UUID.randomUUID().toString());
            		return true;
            	}
            	if(token.remove()){
            		if(isRepeatSubmit(request)){//重复就通过这里
            			response.sendRedirect(request.getContextPath()+"/list");
            			return false;
            		}
            		request.getSession(false).removeAttribute("token");//提交内容重复后的操作
            	}
            }
		}
        return true;
	}
	//判断是否信息存在
	private boolean isRepeatSubmit(HttpServletRequest request){
		String serverToken = (String) request.getSession(false).getAttribute("token");
		if(serverToken == null){//重复
			return true;
		}
		String clientToken = request.getParameter("token");
		if(clientToken == null||!clientToken.equals(serverToken)){//提交的内容不同
			return true;
		}
		return false;//不重复
	}
}
