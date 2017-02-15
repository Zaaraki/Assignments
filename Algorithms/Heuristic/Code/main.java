/**
 * Created by amaro on 15/02/2017.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

public class main {
    private static final int SAME_SIZE_VECTORS = 4;
    private static final String INSTANCE_PATH = "D://Zaaraki//CC//5 PERIODO//APA//Sort//instancias//"; // FULL PATH here to access parent folder.
    private static final String STATISTICAL_FILE_PATH = "results//r";
    private static Formatter statisticalFormatter = null;

    public static void main(String[] args) {
        //final int type = Integer.valueOf(args[0]);
        int type=1;
        File f = new File(STATISTICAL_FILE_PATH);
        try {
            statisticalFormatter = new Formatter(f);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }

        // All files have n-1 elements.
        final int size1 = 1000; // Ex.: 99.999.
        final int size2 = 10000;
        final int size3 = 100000;
        final int size4 = 500000;
        final int size5 = 1000000;
        final int sort1 = 1;
        final int sort2 = 10;
        final int sort3 = 50;
        final int sort4 = 90;


        sortVectorFromFile(INSTANCE_PATH, sort1, size1 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort1, size2 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort1, size3 - 1, type);
//        sortVectorFromFile(INSTANCE_PATH, sort1, size4 - 1, type);
//        sortVectorFromFile(INSTANCE_PATH, sort1, size5 - 1, type);
        statisticalFormatter.format("%s", "\n-----------------------------------------\n");

//        sortVectorFromFile(INSTANCE_PATH, sort2, size1 - 1, type);
//        sortVectorFromFile(INSTANCE_PATH, sort2, size2 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort2, size3 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort2, size4 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort2, size5 - 1, type);
        statisticalFormatter.format("%s", "\n-----------------------------------------\n");

//        sortVectorFromFile(INSTANCE_PATH, sort3, size1 - 1, type);
//        sortVectorFromFile(INSTANCE_PATH, sort3, size2 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort3, size3 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort3, size4 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort3, size5 - 1, type);
        statisticalFormatter.format("%s", "\n-----------------------------------------\n");

//        sortVectorFromFile(INSTANCE_PATH, sort4, size1 - 1, type);
//        sortVectorFromFile(INSTANCE_PATH, sort4, size2 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort4, size3 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort4, size4 - 1, type);
        sortVectorFromFile(INSTANCE_PATH, sort4, size5 - 1, type);
        statisticalFormatter.format("%s", "\n-----------------------------------------\n");

        statisticalFormatter.close();
    }
    /*
  Runs one algorithm at a time accoding to parameter 'type'.
  @param path from file of the vector to be sorted.
  @param sortedLevel is the percentage of the vector already sorted.
  @param size of the vector.
  @param type is the choice of the algorithm.
   */
    public static void sortVectorFromFile(String path, int sortedLevel, int size, int type) {
        long v[] = new long[size];
        long begin, end;
        long elapsedSeconds; // Elapsed time to sort one vector.
        long averageSeconds = 0; // Average time to sort SAME_SIZE_VECTORS.

        for (int i = 1; i <= SAME_SIZE_VECTORS; i++) {
            // Open input vector file.
            File inFile = new File(path + sortedLevel + "." + (size + 1) + "." + i + ".in");

            Scanner fileScanner = null;
            try {
                fileScanner = new Scanner(inFile);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            // fileScanner.hasNextInt()
            for (int j = 0; j < size - 1; j++) { // Reads vector from current file.
                v[j] = fileScanner.nextLong();
            }

            /** VERIFICACAO DOS VETORES E DECISAO DE ALGORITMO **/




            begin = System.currentTimeMillis();
//            switch (type) {
//
//                case 1:
//                    sort.mergeSort(v);
//                    break;
//                case 2:
//                    sort.quickSort(v, 0, size - 1);
//                    break;
//                case 3:
//                    sort.heapsort(v, size - 1);
//                    break;
//                case 4:
//                    sort.countingSort(v);
//                    break;
//                case 5:
//                    sort.bucketSort(v, size);
//                    break;
//                case 6:
//                    sort.radixSort(v, size);
//                    break;
//            }

            end = System.currentTimeMillis();
            elapsedSeconds = (end - begin); // Elapsed time to sort current vector.
            //System.out.println("elapsed time: "+ elapsedSeconds);

            // ------- Writes current sorted vector. --------
            try {
                File sortedFile = new File( STATISTICAL_FILE_PATH + sortedLevel + "."+ (size+1)+"."+i+"."+type+".out");
                Formatter sortedFormatter = new Formatter(sortedFile);
                for(int k=0; k<size; k++){
                    sortedFormatter.format("%s\n", String.valueOf(v[k]))  ;
                }
                sortedFormatter.close();
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }


//            // Writes statistical data of the current vector.
//            statisticalFormatter.format("%s\n", "Algorithm " + type + "; Vector " + i + "; Sorted " + sortedLevel + "%; Size " + (size + 1)
//                    + "; Elapsed time " + elapsedSeconds + " ms" + "\n");
//            averageSeconds += elapsedSeconds;

            fileScanner.close();
        }

        // Writes average elapsed time to run SAME_SIZE_VECTORS.
//        averageSeconds /= SAME_SIZE_VECTORS;
//        statisticalFormatter.format("%s\n\n", "Average time: " + averageSeconds + " ms" + "\n");
    }
}

