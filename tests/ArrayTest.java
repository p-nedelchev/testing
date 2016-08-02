import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import taskone.Array;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class ArrayTest {

    private int [] input = new int[]{7, 10, 6, 3, 8, 28, 2};
    private int [] sorted = new int[]{2, 3, 6, 7, 8, 10, 28};
    private int [] reversed = new int[]{2, 28, 8, 3, 6, 10, 7};
    private Array array = new Array();


    @Test
    public void testMinElement () {
        int result = array.getMinElement(input);
        assertEquals(result, 2);
    }

    @Test
    public void testSum () {
        int result = array.getSum(input);
        assertEquals(result, 64);
    }

    @Test
    public void testSort () {
        array.quickSort(input, 0, input.length - 1);
        assertArrayEquals(input, sorted);
    }

    @Test
    public void testReverse () {
        array.reverse(input);
        assertArrayEquals(input, reversed);
    }

    @Test(expected = NullPointerException.class)
    public void testNull () {
        int result = array.getMinElement(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullSum () {
        int result = array.getSum(null);
    }

    @Test(expected = NullPointerException.class)
    public void testNullReverse () {
        array.reverse(null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIndexOutOfBounds () {
        array.quickSort(input, -1, input.length -1);
    }
}
