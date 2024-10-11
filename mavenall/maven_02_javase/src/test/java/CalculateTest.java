import com.zw.Calculate;
import org.junit.Test;

public class CalculateTest {
    @Test
    public void testSub() {
        Calculate calculate = new Calculate();
        System.out.println(calculate.sub(10, 2));
    }

    @Test
    public void testDiv(){
        Calculate calculate = new Calculate();
        try {
            System.out.println(calculate.div(10, 2));
            System.out.println(calculate.div(10, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
