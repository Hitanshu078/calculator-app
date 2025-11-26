import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(5.0, Calculator.add(2, 3), 0.0);
    }

    @Test
    public void testSubtract() {
        assertEquals(2.0, Calculator.subtract(5, 3), 0.0);
    }

    @Test
    public void testMultiply() {
        assertEquals(12.0, Calculator.multiply(3, 4), 0.0);
    }

    @Test
    public void testDivide() {
        assertEquals(5.0, Calculator.divide(10, 2), 0.0);
    }
}
