package app.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * zxj
 * description: AOP 单元测试
 * date: 2023
 */

@SpringBootTest
public class AopTest {

    @Autowired
    UserController userController;

    @Test
    public void testGetAOPAdvice() {
        userController.getAopAdvice();
    }

    @Test
    public void testGetAOPAdviceWithAnnotation() {
        userController.getAnnotationAdvice();
    }
}
