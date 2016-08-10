import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;
import taskone.Array;



/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class ArrayTest {


    @Test
    public void getMinElement () {
        Array array = new Array(new int[]{7, 10, 6, 3, 8, 28, 2});
        int subject = array.getMinElement();
        assertThat( subject, is(equalTo( 2 )));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMinElementEmptyArray () {
        Array array = new Array(new int[]{});
        int minimal = array.getMinElement();
    }

    @Test
    public void getSum () {
        Array array = new Array(new int[]{9, 11, 7, 3, 9, 28, 3});
        int subject = array.getSum();
        assertThat( subject, is(equalTo( 70 )));
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSumEmptyArray () {
        Array array = new Array(new int[]{});
        int sum = array.getSum();
    }

    @Test
    public void sortArray () {
        Array array = new Array(new int[]{18, 4, 23, 1, 12, 28, 6});
        int [] subject = array.quickSort();
        int [] expected = new int[]{1, 4, 6, 12, 18, 23, 28};
        assertThat( subject, is(equalTo( expected )));
    }

    @Test
    public void reverseArray () {
        Array array = new Array(new int[]{4, 11, 2, 13, 6, 16, 5});
        int [] subject = array.reverse();
        int [] expected = new int[]{5, 16, 6, 13, 2, 11, 4};
        assertThat( subject, is(equalTo( expected )));
    }

}
