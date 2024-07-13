package app.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * zxj
 * description: 自定义注解 demo
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1.
 * 自定义注解格式：
 * a. 修饰符必须是public
 * b. 注解的名称必须是类的名称
 * c. @Target 表示这个自定义注解能够使用在什么地方
 * d. @Retention: 表示这个自定义注解生命周期的策略
 *
 * @ImoocAnnotation(name=xx ,age=)
 *
 * 2.
 * 自定义注解的解析
 * a. 通过拦截器解析 ( 自定义注解修饰的是web api接口 )
 * b. 通过AOP解析
 *
 * *********************/


@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ImoocAnnotation {
    String name() default "";
    int age() default 1;
}
