import java.util.Scanner;

public class Linear {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        linearSort sort = new linearSort();
        //Scanner tamanho = new Scanner(System.in);
        Scanner val = new Scanner(System.in);

        int o = Integer.parseInt(args[0]);

        int tam;

        tam = val.nextInt(); //VAI ESPERAR O TAMANHO DO VETOR

        int v[] = new int[tam];

        for (int i = 0; i < tam; i++) {
            v[i] = val.nextInt();
        }

        switch (o) {
            case 1:
                sort.countingSort(v);
                break;
            case 2:
                sort.bucketSort(v, tam);
                break;
            case 3:
                sort.radixSort(v, tam);
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
