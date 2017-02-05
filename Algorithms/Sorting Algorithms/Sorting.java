import java.util.Scanner;

public class Sorting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        sort sort = new sort();
        //Scanner tamanho = new Scanner(System.in);
        Scanner val = new Scanner(System.in);
        
        //System.out.println("1 - Insertion");
        //System.out.println("2 - Selection");
//        System.out.println("3 - MergeSort");
//        System.out.println("4 - QuickSort");
  //      System.out.println("5 - HeapSort");
    //    System.out.println("Escolha o algoritmo");
       	int o = Integer.parseInt(args[0]);
        
        int tam;
        //o = tipo.nextInt();
        
        tam = val.nextInt(); //VAI ESPERAR O TAMANHO DO VETOR
        
        int v[] = new int [tam];
        
        for (int i = 0; i < tam; i++) {
            v[i] = val.nextInt();
        }
        
        switch(o){
            case 1: sort.insertionSort(v, tam);
                break;
            case 2: sort.selection_sort(v, tam);
                break;
            case 3: sort.mergeSort(v);
                break;
            case 4: sort.quickSort(v, 0, tam-1);
                break;
            case 5: sort.heapsort(v, tam-1);
                break;
        }
        
        // ---------- SAIDA ---------------
        //Depois de ordenar, printa o vetor
	System.out.println("");
        for (int i = 0; i < tam; i++) {
            System.out.println(v[i]);
            
        }
        
        
        
        
    }
    
}