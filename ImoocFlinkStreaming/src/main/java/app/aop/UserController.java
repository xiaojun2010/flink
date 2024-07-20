package app.aop;

import org.springframework.stereotype.Controller;

/**
 * author: Imooc
 * description: AOP Demo
 * date: 2023
 */

@Controller
public class UserController {

    /**
     * author: Imooc
     * description: 获取 AOP 通知
     * @param :
     * @return void
     */
    public void getAopAdvice() {
        System.out.println("this function get AOP Advice");
    }

    /**
     * author: Imooc
     * description: 获取指定注解修饰的 AOP 通知
     * @param :
     * @return void
     */
    @ImoocAnnotation
    public void getAnnotationAdvice() {
        System.out.println("this function get AOP Advice With Annotation");
    }

}
