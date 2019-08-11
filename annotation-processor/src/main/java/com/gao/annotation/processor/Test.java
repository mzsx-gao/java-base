package com.gao.annotation.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: TODO
 *
 * @Auther: gaoshudian
 * @Date: 2018/12/16 21:48
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.SOURCE)
public @interface Test {

    String value() default "";

}
