package app.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * author: Imooc
 * description: 切面类
 * date: 2023
 */

/* **********************
 *
 * 知识点：
 *
 * 1.
 * 切面：切点和通知的~结合体
 * 连接点：程序运行中,能够植入切面的地方
 * 切点：就是一个连接点
 * 通知：其实是要执行的方法
 *
 *
 * 2.
 * @Aspect: 定义切面类
 * @Pointcut: 定义切点
 * @Before: 在切入的方法之前执行
 * @After: 在切入的方法之后执行
 * @Around: 环绕切入的方法执行
 *
 * 3.
 * @Pointcut的表达式有几种：
 *
 * a.
 * execution 表达式：
 * 格式： execution(
 *              方法的修饰符：可以省略
 *              方法的返回值：* 代表所有的类型
 *              方法的包路径：com.demo.* 代表com.demo下面的所有包和子包
 *              方法的名称和参数：
 *                  名称：do* 代表以do开头的所有方法
 *                  参数：(*) 代表一个参数, (..)代表多个参数
 *              方法的异常抛错：throws exception 代表所有的Exception抛错
 *          )
 *
 * b. annotation 表达式：
 * 格式： @annotation(注解的包路径)
 *
 *
 *
 * *********************/

@Aspect
@Component
public class AdviceAOP {

    //切点
    @Pointcut("execution(public * app.aop.UserController.*(..))")
    public void advicePointCut() {}

    @Pointcut("@annotation(app.aop.ImoocAnnotation)")
    public void annotationPointCut() {}

    //通知
    @Before("advicePointCut()")
    public void doBefore() {
        System.out.println("AOP Advice: do before function");

    }

    @After("annotationPointCut()")
    public void doAfter() {
        System.out.println("AOP Advice: do after function with annotation");

    }

}
