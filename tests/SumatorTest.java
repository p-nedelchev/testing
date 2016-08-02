import static org.junit.Assert.assertEquals;


import org.junit.Test;
import taskone.Sumator;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class SumatorTest {

    private Sumator sumator = new Sumator();

    @Test
    public void testSum () {
        int result = sumator.sum(5, 15);
        assertEquals(20, result, 0);
    }

    @Test(expected = NumberFormatException.class)
    public void incorectInputTest () {
        int result = sumator.sum("5", "c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void nullExceptionTest () {
        int result = sumator.sum(null, "15");
    }

}
