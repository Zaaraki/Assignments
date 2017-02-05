public class sortingAlg {

    /*
	Shifts elements to the left while its value 
	is larger than the left element.
     */
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int valueToSort = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] > valueToSort) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = valueToSort;
        }
    }

    /* 
	Searches for the minimum value and put it in sorted
	order, keeping the loop invariant.
     */
    public static void selection_sort(int v[], int length) {
        int i, j, min;
        int key;

        for (i = 0; i < length - 1; i++) {
            min = i;
            for (j = i + 1; j < length; j++) {
                if (v[j] < v[min]) {
                    min = j;
                }
            }
            if (i != min) { // swap
                key = v[i];
                v[i] = v[min];
                v[min] = key;
            }
        }
    }

    /**
     * ******* Start of MERGE functions ********
     */
    public static void mergeSort(int[] array) {
        if (array.length > 1) {

            int[] left = leftHalf(array);
            int[] right = rightHalf(array);

            mergeSort(left);
            mergeSort(right);

            merge(array, left, right);
        }
    }

    public static int[] leftHalf(int[] array) {
        int size1 = array.length / 2;
        int[] left = new int[size1];
        for (int i = 0; i < size1; i++) {
            left[i] = array[i];
        }
        return left;
    }

    public static int[] rightHalf(int[] array) {
        int size1 = array.length / 2;
        int size2 = array.length - size1;
        int[] right = new int[size2];
        for (int i = 0; i < size2; i++) {
            right[i] = array[i + size1];
        }
        return right;
    }

    public static void merge(int[] result,
            int[] left, int[] right) {
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
    public static void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }

        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        int pivot = arr[middle];

        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }

            while (arr[j] > pivot) {
                j--;
            }

            if (i <= j) {
                int temp = arr[i];
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
   private static void max_heapify(int v[], int length, int i) {
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
    private static void build_max_heap(int v[], int length) {
        for (int i = length / 2; i >= 0; i--) {
            max_heapify(v, length, i);
        }
    }

    /* Builds the heap, exchanges the root element with v[n] element of the heap
	and keeps the heap property */
    public static void heapsort(int v[], int length) {
        build_max_heap(v, length);
        for (int i = length; i >= 1; i--) {
            swap(v, 0, i); // Exchanges the root element with v[i]
            length--; // Root nodes already exchanged stays out of the new heap range
            max_heapify(v, length, 0); // Avoids the new first element to violate the heap property
        }
    }

    private static void swap(int v[], int i, int j) {
        int hold = v[i];
        v[i] = v[j];
        v[j] = hold;
    }
    /**
     * ******* End of HEAP functions ********
     */
}
