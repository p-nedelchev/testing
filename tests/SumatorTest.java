import static org.junit.Assert.assertEquals;


import org.junit.Test;
import taskone.Sumator;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class SumatorTest {

    private Sumator sumator = new Sumator();

    @Test
    public void sum () {
        int result = sumator.sum(5, 15);
        assertEquals(20, result, 0);
    }

    @Test(expected = NumberFormatException.class)
    public void incorrectInput () {
        int result = sumator.sum("5", "c");
    }

    @Test(expected = IllegalArgumentException.class)
    public void illegalInput () {
        int result = sumator.sum(null, "15");
    }

}
