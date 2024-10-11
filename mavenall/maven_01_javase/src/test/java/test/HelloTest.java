package test;

import com.zw.service.Hello;
import org.junit.Test;

/**
 * 所有测试功能的实现都是测试方法来完成的
 * 测试方法的规范
 *  1. 访问权限是public
 *  2. 方法没有返回值void
 *  3. 方法名称自定义，推荐以test结尾
 *  4. 方法没有参数
 *  5. 以@Test注解生命是一个测试方法
 */
public class HelloTest {
    @Test
    public void testSum(){
        Hello hello = new Hello();
        System.out.println(hello.sum(2, 6));
    }

    @Test
    public void testMul(){
        Hello hello = new Hello();
        System.out.println(hello.mul(2, 6));
    }
}
