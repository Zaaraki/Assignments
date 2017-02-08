import java.util.Arrays;

public class linearSort {

    private static final int MAX_RANGE = 1000000;
    /** Counting Sort function **/
    public static void countingSort( int[] arr )
    {
        int N = arr.length;
        if (N == 0)
            return;
        /** find max and min values **/
        int max = arr[0], min = arr[0];
        for (int i = 1; i < N; i++)
        {
            if (arr[i] > max)
                max = arr[i];
            if (arr[i] < min)
                min = arr[i];
        }
        int range = max - min + 1;
 
        /** check if range is small enough for count array **/
        /** else it might give out of memory exception while allocating memory for array **/
        if (range > MAX_RANGE)
        {
            System.out.println("\nError : Range too large for sort");
            return;
        }
 
        int[] count = new int[range];
        /** make count/frequency array for each element **/
        for (int i = 0; i < N; i++)
            count[arr[i] - min]++;
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
    void bucketSort(int array[], int N)
    {
    if( N <= 0 )
      return;                                   // Case of empty array

    int min = array[0];
    int max = min;
    for( int i = 1; i < N; i++ )                // Find the minimum and maximum
      if( array[i] > max )
        max = array[i];
      else if( array[i] < min )
        min = array[i];

    int bucket[] = new int[max-min+1];          // Create buckets
    
    for( int i = 0; i < N; i++ )                // "Fill" buckets
      bucket[array[i]-min]++;                   // by counting each datum

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
    static int getMax(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > mx) {
                mx = arr[i];
            }
        }
        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        for (i = 0; i < n; i++) {
            count[(arr[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }

    // The main function to that sorts arr[] of size n using
    // Radix Sort
    static void radixSort(int arr[], int n) {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);

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
