import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import taskone.Array;

import java.util.Arrays;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class ArrayTest {


    @Test
    public void testMinElement () {
        assertThat(new Array(new int[]{7, 10, 6, 3, 8, 28, 2}).getMinElement(), is(equalTo(2)));
    }

    @Test
    public void testSum () {
       assertThat(new Array(new int[]{7, 10, 6, 3, 8, 28, 2}).getSum(), is(equalTo(64)));
    }

    @Test
    public void testSort () {
        assertThat(new Array(new int[]{7, 10, 6, 3, 8, 28, 2}).quickSort(), is(equalTo(new int[]{2, 3, 6, 7, 8, 10, 28})));
    }

    @Test
    public void testReverse () {
       assertThat(new Array(new int[]{7, 10, 6, 3, 8, 28, 2}).reverse(), is(equalTo(new int[]{2, 28, 8, 3, 6, 10, 7})));
    }

    @Test(expected = NullPointerException.class)
    public void testNull () {
        int result = new Array(null).getMinElement();
    }

    @Test(expected = NullPointerException.class)
    public void testNullSum () {
        int result = new Array(null).getSum();
    }

    @Test(expected = NullPointerException.class)
    public void testNullReverse () {
        new Array(null).reverse();
    }

}
