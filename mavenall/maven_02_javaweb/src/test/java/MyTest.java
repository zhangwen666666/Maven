import com.zw.service.Hello;
import org.junit.Test;

public class MyTest {
    @Test
    public void testSum(){
        Hello hello = new Hello();
        System.out.println(hello.sum(10, 20));
    }
}
