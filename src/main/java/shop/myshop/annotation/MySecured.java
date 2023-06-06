package shop.myshop.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import shop.myshop.dto.Role;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MySecured {
	
	Role role() default Role.USER;
	

}
