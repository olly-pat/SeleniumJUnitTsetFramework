import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConflictTest {
    @Test
    public void test1(){
        int a = 1;
        int b = 5;
        System.out.println(a+b+a+a);
    }
    @Test
    public void test2(){
        String m = "blabla";
        Assertions.assertTrue(m.equals("blab"));

    }

}
