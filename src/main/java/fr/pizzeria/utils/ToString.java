package fr.pizzeria.utils;

import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.Retention;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToString {
	boolean toUpperCase() default false;
	String toSeparate() default "";
	boolean isPrice() default false;
	String beforePrice() default "";
	String afterPrice() default "";
}
