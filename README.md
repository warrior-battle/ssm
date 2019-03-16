# message
spring+springmvc+mybatis 框架整合测试 <br/>
1.可以直接拿来用<br/>    
2.文件存放规范   <br/>



流程：
1.添加jar包
2.设置数据库和日记文件还有mybatis全局配置
3.配置spring和与mybatis整合的文件配置
4.编写业务逻辑开始就可以开始测试spring和mybatis是否成功成功了。



整合springMVC：
5.配置web.xml文件也就是DispatcherServlet
6.编写DispatcherServlet的配置文件
7.springmvc拦截器+自定义注解解决请求重复提交问题。  

tomcat访问：http://localhost:8080/ssm/hello
jetty访问：http://localhost:8080/hello

使用mvn命令最好在项目文件夹输入
当本地目录没有lib时：mvn dependency:copy-dependencies -DoutputDirectory=src/main/webapp/WEB-INF/lib  -DincludeScope=runtime

出现DispatcherServlet分配不均衡可能是本地没有lib或者servlet包冲突可在pom里面的serlet加入<scope>provided</scope>
