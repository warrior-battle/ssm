/**
 * 
 */
package org.myproject.token;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Documented
@Retention(RUNTIME)
@Target(METHOD)//Method ----》》方法处理类上
/**
 * 防重复提交注解
 * @author Czw
 *
 */
public @interface Token {
	boolean save() default false;
	boolean remove() default false;
}
