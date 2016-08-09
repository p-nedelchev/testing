package taskone;


/**
 * @author Petar Nedelchev <peter.krasimirov@gmail.com>
 */
public class Array {
    private final int [] array;

    public Array (int [] array) {
        this.array = array;
    }

    /**
     * Returns the minimal element in an array
     * @return minimal element in array
     */
    public Integer getMinElement () {
        Integer min = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++) {
            if( array[i] < min ){
                min = array[i];
            }
        }
        return min;
    }

    /**
     * Calculates the sum of elements of an array
     * @return int the sum of the elements of array
     */
    public int getSum() {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }

    /**
     * Prints the elements of an array
     */
    public void printArray() {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    /**
     * Sorts an array using QuickSort algorithm
     * @return int [] sorted copy of the original array
     */
    public int [] quickSort () {
        int [] sorted = this.array;
        int left = 0;
        int right = sorted.length - 1;
        partitioning(sorted, left, right);
        return sorted;
    }

    private void partitioning (int [] array, int left , int right) {
        int i = left, j = right;
        int mid = (left + right)/ 2;
        int pivot = array[mid];
        int temp;
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
        if(left < j) partitioning(array, left, j);
        if(right > i ) partitioning(array, i, right);
    }


    /**
     * Reversed an array
     * @return int [] reversed copy of the original array
     */
    public int [] reverse() {
        int [] reversed = this.array;
        int i = 0;
        int j = reversed.length - 1;
        int temp;
        while(i != reversed.length/2){
            temp = reversed[i];
            reversed[i] = reversed[j];
            reversed[j] = temp;
            i++;
            j--;
        }
        return reversed;
    }
}
