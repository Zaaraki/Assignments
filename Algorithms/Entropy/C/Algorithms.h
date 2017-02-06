/*<<<<<<<<<<<<<<<<<<<<MERGE SORT>>>>>>>>>>>>>>>>>>>>*/

void mergeSort(int* vetor, int posicaoInicio, int posicaoFim){
	int i, j, k, metadeTam, *vetorTemp;
	
	if(posicaoInicio == posicaoFim){
		return;
	}

	metadeTam = (posicaoInicio + posicaoFim)/2;
	
	mergeSort(vetor, posicaoInicio, metadeTam);
	mergeSort(vetor, metadeTam +1, posicaoFim);
	
	i = posicaoInicio;
	j = metadeTam +1;
	k = 0;
	vetorTemp = (int *) malloc(sizeof(int) * (posicaoFim - posicaoInicio + 1));


	while(i < metadeTam + 1 || j  < posicaoFim + 1) {
        if (i == metadeTam + 1 ) { 
            vetorTemp[k] = vetor[j];
            j++;
            k++;
        } 
        else {
            if (j == posicaoFim + 1) { 
                vetorTemp[k] = vetor[i];
                i++;
                k++;
            } 
            else {
                if (vetor[i] < vetor[j]) { 
                    vetorTemp[k] = vetor[i];
                    i++;
                    k++;
                } 
                else { 
                    vetorTemp[k] = vetor[j];
                    j++;
                    k++;
                }
            }
        }
	}
	for(i = posicaoInicio; i <= posicaoFim; i++) {
    	vetor[i] = vetorTemp[i - posicaoInicio];
	}
	free(vetorTemp);
}

/*<<<<<<<<<<<<<<<<<<<<QUICK SORT>>>>>>>>>>>>>>>>>>>>*/

int partition(int* ar, int ini, int fim){
    int pivo = 0;
    int topo = 0;
    int i = 0;
 
    pivo = ar[ini];
    topo = ini;
 
    for(i = ini + 1; i <= fim; i++){
        if(pivo > ar[i]){
            ar[topo] = ar[i];
            ar[i] = ar[topo + 1];
            topo++;
        }
    }
    ar[topo] = pivo;
    return topo;
}

void quickSort(int* ar, int ini, int fim){
    int mid = 0;
 
    if(ini < fim){
        mid = partition(ar, ini, fim);
        quickSort(ar, ini, mid);
        quickSort(ar, mid+1, fim);
    }
}

/*<<<<<<<<<<<<<<<<<<<<HEAP SORT>>>>>>>>>>>>>>>>>>>>*/

void createHeap(int *vet, int i, int f){
	int aux = vet[i];
	int j = i * 2 + 1;

	while(j<=f){
		if(j<f){
			if(vet[j] < vet[j+1]){
				j = j + 1;
			}
		}
		if(aux < vet[j]){
			vet[i] = vet[j];
			i = j;
			j = 2*i+1;
		}
		else{
			j = f+1;
		}
	}
	vet[i] = aux;
}

void heapSort(int *vet, int tam){
	int i, aux;

	for(i=(tam - 1)/2; i>=0; i--){
		createHeap(vet, i, tam-1);
	}
	for(i = tam-1; i>=1; i--){
		aux = vet[0];
		vet[0] = vet[i];
		vet[i] = aux;
		createHeap(vet, 0, i-1);
	}
}

/*<<<<<<<<<<<<<<<<<<<<SELECTION SORT>>>>>>>>>>>>>>>>>>>>*/

void selectionSort(int *vet, int tam){
			 	
	int menor, aux;
	int i, j;
	
	for(i = 0; i < tam - 1; i++){
	menor = i;
		for (j = (i+1); j < tam; j++) {
			if(vet[j] < vet[menor]){
				menor = j;
			} 
		}
		if (i != menor) {
			aux = vet[i];
			vet[i] = vet[menor];
			vet[menor] = aux;
		}
	}
}

/*<<<<<<<<<<<<<<<<<<<<INSERTION SORT>>>>>>>>>>>>>>>>>>>>*/

void insertionSort(int *vet, int tam){
	
	int i, j;
	int aux;
	
	for(i = 1; i < tam; i++){
		aux = vet[i];
		for(j = i - 1; j >= 0 && vet[j] > aux; j--){
		    vet[j+1] = vet[j];
		}
		vet[j+1] = aux;
	}
}