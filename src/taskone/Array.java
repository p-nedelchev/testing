package taskone;

/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Array {

    /**
     * Returns the minimal element in an array
     * @param array int array of integers
     * @return minimal element in array
     */
    public int getMinElement (int [] array) {
        int min = array[0];
        for(int i = 0; i < array.length; i++) {
            if( array[i] < min ){
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Calculates the sum of elements of an array
     * @param array int array of integers
     * @return int the sum of the elements of array
     */
    public int getSum(int [] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Prints the elements of an array
     * @param array int array of integers
     */
    public void printArray(int [] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sorts an array using Quick sort algorithm
     * @param array int array of integers
     * @param left int index of the first elements in the array
     * @param right int index of the last element of the array
     */
    public void quickSort (int [] array,int left, int right) {
        int i = left, j = right;
        int mid = (left + right)/ 2;
        int pivot = array[mid];
        int temp;
        /*
         Divides the array in two parts in such way that all elements in left part
         are lesser than pivot and right elements are greater than pivot
         */
        while (i <= j) {
            while(array[i] < pivot){
                i++;
            }
            while(array[j] > pivot){
                j--;
            }
            if(i <= j) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        /*
        Recursively calls quickSort on the left and right part
         */
        if(left < j) quickSort(array, left, j);
        if(right > i ) quickSort(array, i, right);
    }


    /**
     * Reverses the elements of an array
     *
     */
    public void reverse(int [] array) {
        int i = 0;
        int j = array.length - 1;
        int temp;
        while(i != array.length/2){
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            i++;
            j--;
        }
    }
}
