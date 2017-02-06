#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>
#include "Algorithms.h"

int cmpfunc (const void * a, const void * b){
   return ( *(int*)a - *(int*)b );
}

void print_vector(int v[], int size){
	int i;
	for(i = 0; i < size; i++){
		printf("%d \n", v[i]);
	}
}


void sortInstances(char path[], int sort, int size, int type){

	//Initializing Vector with size coming parameter
	int *vet = malloc(size*sizeof(int));
	double total_time = 0.00;
	double average_time = 0.00;
	clock_t start_t, end_t;

	//Creating new file to receive the results
	FILE *results = fopen("instancias/results.txt", "a");
	if(vet!= NULL){

		int i;
		char *mySort;

		//Comparing size of vector
		if(size == 1000000){
			mySort = (char*) malloc(10*sizeof(char));
			char *arr = (char*) malloc(7*sizeof(char));

			if((mySort != NULL) && (arr!= NULL)){
				//Transforming Interger at String and Concatening
				//itoa(sort, mySort, 10);
				sprintf(mySort, "%d", sort);
				strcat(mySort, ".");
				//Transforming Interger at String and Concatening
				//itoa(size, arr, 10);
				sprintf(arr, "%d", size);
				strcat(arr, ".");

				//Concatening Strings to form PATH
				strcat(mySort, arr);

				free(arr);
			}
		}
		else{

			mySort = (char*) malloc(9*sizeof(char));
			char *arr = (char*) malloc(6*sizeof(char));

			if((mySort != NULL) && (arr!= NULL)){
				//itoa(sort, mySort, 10);
				sprintf(mySort, "%d", sort);
				strcat(mySort, ".");

				//itoa(size, arr, 10);
				sprintf(arr, "%d", size);
				strcat(arr, ".");

				strcat(mySort, arr);

				free(arr);
			}
		}
		//Dynamic Initialization of arrays
		char *myPath = (char*) malloc(strlen(path) + strlen(mySort));
		//Coping PATH(parameter) to a new variable myPath
		strcpy(myPath, path);
		//Concatening Strings to form myPATH
		strcat(myPath, mySort);
		//Memory deallocation
		free(mySort);

		char *number;
		char *tempPath;

		for(i=1; i<=10; i++){

			if(i == 10){
				number = (char*) malloc(5*sizeof(char));
			}
			else{
				number = (char*) malloc(4*sizeof(char));
			}

			//Provisional PATH
			char tempPath[strlen(myPath)];
			strcpy(tempPath, myPath);

			if(number != NULL){
				//Transforming Interger at String
				//itoa(i, number, 10);
				sprintf(number, "%d", i);
				//Concatening Strings to form tempPATH(PROVISIONAL)
				strcat(number, ".in");
				strcat(tempPath, number);
				//Memory deallocation
				free(number);

				int position = 0;
				int  j = 0;
				int x = 0;
				//Opening data from FILE
				FILE *file;
				file = fopen(tempPath, "r");
				if(file != NULL){
					while((fscanf(file, "%d", &j)) != EOF){
						if(x==0){
							x++;
							//Faz nada
						}else{
							vet[position] = j;
							position++;
						}
					}
				}
				else{
					printf("Error to open FILE!");
				}



				start_t = clock();
				//printf("START_T = %ld\n", start_t);
				switch(type){

					case 1:
					    insertionSort(vet, size);
					    //print_vector(vet, size);
						break;

					case 2:
						selectionSort(vet, size);
						//print_vector(vet, size);
						break;

					case 3:
						mergeSort(vet, 0, size-1);
						//print_vector(vet, size);
						break;

					case 4:
						quickSort(vet, 0, size-1);
						//print_vector(vet, size);
						break;

					case 5:
						heapSort(vet, size);
						//print_vector(vet, size);
						break;

					case 6:
						qsort(vet, size, sizeof(int), cmpfunc);
						//print_vector(vet, size);
						break;
				}

				end_t = clock();
				//printf("END_T = %ld\n", end_t);

				//total_time = ((float)(end_t - start_t) / 1000000.0F) * 1000;
				total_time = (double)(end_t - start_t) / CLOCKS_PER_SEC;
				printf("TIME:  %lf \n", total_time);
				average_time = average_time + total_time;

				fprintf(results, "%s %d %s %d %s %s %d %s %d %s %f %s", "Algorithm: ", type, " | Sort: ", sort, "%" , " | Vector: ", i, " | Size: ", size, " | Time Sort: ", total_time, "seconds\n");
				//Close FILE
				fclose(file);
			}
		}
		average_time = average_time / 10.0;
		fprintf(results, "%s %lf %s", "Average :", average_time, "\n \n");
		fclose(results);
		free(myPath);
	}
	free(vet);
}



int main(int argc, char *argv[]){

	char PATH[] = "instancias/";
	int type = atoi(argv[1]);

	int size1 = 100000;
	int size2 = 500000;
	int size3 = 1000000;

	int sort1 = 10;
	int sort2 = 50;
	int sort3 = 90;

	//Quick Sort

	//Sort 10%
	sortInstances(PATH, sort1, size1, type);
	sortInstances(PATH, sort1, size2, type);
	sortInstances(PATH, sort1, size3, type);

	//Sort 50%
	sortInstances(PATH, sort2, size1, type);
	sortInstances(PATH, sort2, size2, type);
	sortInstances(PATH, sort2, size3, type);

	//Sort 90%
	sortInstances(PATH, sort3, size1, type);
	sortInstances(PATH, sort3, size1, type);
	sortInstances(PATH, sort3, size1, type);

	system("pause");

	return 0;
}