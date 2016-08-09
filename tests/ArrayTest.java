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
    private Array array = new Array(new int[]{7, 10, 6, 3, 8, 28, 2});

    @Test
    public void getMinElement () {
        int subject = array.getMinElement();
        assertThat( subject, is(equalTo( 2 )));
    }

    @Test
    public void getSum () {
        int subject = array.getSum();
        assertThat( subject, is(equalTo( 64 )));
    }

    @Test
    public void sortArray () {
        int [] subject = array.quickSort();
        int [] expected = new int[]{2, 3, 6, 7, 8, 10, 28};
        assertThat( subject, is(equalTo( expected )));
    }

    @Test
    public void reverseArray () {
        int [] subject = array.reverse();
        int [] expected = new int[]{2, 28, 8, 3, 6, 10, 7};
        assertThat( subject, is(equalTo( expected )));
    }

}
