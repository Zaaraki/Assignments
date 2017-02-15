/**
 * Created by amaro on 15/02/2017.
 */
import java.util.Arrays;
public class sort {


    /**
     * ******* Start of MERGE functions ********
     */
    public static void mergeSort(long[] array) {
        if (array.length > 1) {

            long[] left = leftHalf(array);
            long[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public static long[] leftHalf(long[] array) {
        int size1 = array.length / 2;
        long[] left = new long[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public static long[] rightHalf(long[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        long[] right = new long[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public static void merge(long[] result,
                             long[] left, long[] right) {
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < result.length; i++) {
            if (i2 >= right.length || (i1 < left.length
                    && left[i1] <= right[i2])) {
                result[i] = left[i1];
                i1++;
            } else {
                result[i] = right[i2];
                i2++;
            }
        }
    }

    /**
     * ******* End of MERGE functions ********
     */
    /**
     * ******* Start of QUICK functions ********
     */
// The pivot is the last element of the vector
    public static void quickSort(long[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        long pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                long temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j) {
            quickSort(arr, low, j);
        }

        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    /**
     * ******* End of QUICK functions ********
     */
    /**
     * ******* Start of HEAP functions ********
     */
    private static int parent(int i) {
        return i / 2;
    }

    private static int left(int i) {
        return i * 2;
    }

    private static int right(int i) {
        return 2 * i + 1;
    }

    /* Calls max_heapify recursively for nodes
   that are not in max heap property.
     */
    private static void max_heapify(long v[], int length, int i) {
        int l = left(i);
        int r = right(i);
        int largest;

        if (l <= length && v[l] > v[i]) { // Checks if left node is the largest
            largest = l;
        } else {
            largest = i;
        }

        if (r <= length && v[r] > v[largest]) { // Checks if right node is the largest
            largest = r;
        }

        if (largest != i) { // Checks if there was exchange
            swap(v, i, largest);
            max_heapify(v, length, largest);
        }
    }

    /* Calls max_heapify for every node in a bottom-up manner */
    private static void build_max_heap(long v[], int length) {
        for (int i = length / 2; i >= 0; i--) {
            max_heapify(v, length, i);
        }
    }

    /* Builds the heap, exchanges the root element with v[n] element of the heap
	and keeps the heap property */
    public static void heapsort(long v[], int length) {
        build_max_heap(v, length);
        for (int i = length; i >= 1; i--) {
            swap(v, 0, i); // Exchanges the root element with v[i]
            length--; // Root nodes already exchanged stays out of the new heap range
            max_heapify(v, length, 0); // Avoids the new first element to violate the heap property
        }
    }

    private static void swap(long v[], int i, int j) {
        long hold = v[i];
        v[i] = v[j];
        v[j] = hold;
    }
    /**
     * ******* End of HEAP functions ********
     */

    private static final int MAX_RANGE = 1000000;
    /** Counting Sort function **/
    public static void countingSort( long[] arr )
    {
        int N = arr.length;
        if (N == 0)
            return;
        /** find max and min values **/
        long max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        long range = max - min + 1;

        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }

        long[] count = new long[(int) range];
        /** make count/frequency array for each element **/
        for (int i = 0; i < N; i++)
            count[(int) (arr[i] - min)]++;
        /** modify count so that positions in final array is obtained **/
        for (int i = 1; i < range; i++)
            count[i] += count[i - 1];
        /** modify original array **/
        int j = 0;
        for (int i = 0; i < range; i++)
            while (j < count[i])
                arr[j++] = i + min;
    }

    //////////////////////////////////////////////////////////////////
    static void bucketSort(long array[], int N)
    {
        if( N <= 0 )
            return;                                   // Case of empty array

        long min = array[0];
        long max = min;
        for( int i = 1; i < N; i++ )                // Find the minimum and maximum
            if( array[i] > max )
                max = array[i];
            else if( array[i] < min )
                min = array[i];

        long bucket[] = new long[(int) (max-min+1)];          // Create buckets

        for( int i = 0; i < N; i++ )                // "Fill" buckets
            bucket[(int) (array[i]-min)]++;                   // by counting each datum

        int i = 0;
        for( int b = 0; b < bucket.length; b++ )    // "Empty" buckets
            for( int j = 0; j < bucket[b]; j++ )      // back into array
                array[i++] = b+min;                     // by creating one per count
    }


    /**
     *  test program for bucketsort; reads arbitrarily-many numbers
     *  from standard input, sorts them, then writes them to standard output.
     **/


    ///////////////////////////////////////////////////////////////////
    // A utility function to get maximum value in arr[]
    static long getMax(long arr[], int n) {
        long mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(long arr[], int n, int exp) {
        long output[] = new long[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(int) ((arr[i] / exp) % 10)]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(int) ((arr[i] / exp) % 10)] - 1] = arr[i];
            count[(int) ((arr[i] / exp) % 10)]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    /*
    ----------------------RADIX SORT
     */
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(long arr[], int n) {
        // Find the maximum number to know number of digits
        long m = getMax(arr, n);

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; m / exp > 0; exp *= 10) {
            countSort(arr, n, exp);
        }
    }

    // A utility function to print an array
    static void print(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}


