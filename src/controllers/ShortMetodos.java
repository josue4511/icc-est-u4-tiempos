package controllers;

public class ShortMetodos {

   
    public void sortBubble(int[] numeros) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] < numeros[j]) {
                    int temp = numeros[i];
                    numeros[i] = numeros[j];
                    numeros[j] = temp;
                }
            }
        }
    }

   
    public void sortBubbleMejorado(int[] numeros) {
        for (int i = 0; i < numeros.length - 1; i++) {
            boolean ordenado = true;

            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros[j + 1]) {
                    int temp = numeros[j];
                    numeros[j] = numeros[j + 1];
                    numeros[j + 1] = temp;
                    ordenado = false;
                }
            }

            if (ordenado) break; 
        }
    }

    
    public void sortShell(int[] numeros) {
        int n = numeros.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = numeros[i];
                int j = i;

                while (j >= gap && numeros[j - gap] > temp) {
                    numeros[j] = numeros[j - gap];
                    j -= gap;
                }

                numeros[j] = temp;
            }
        }
    }

    
    public void sortMerge(int[] numeros) {
        mergeSort(numeros, 0, numeros.length - 1);
    }

    private void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        int tamaño1 = mid - left + 1;
        int tamaño2 = right - mid;

        int[] L = new int[tamaño1];
        int[] R = new int[tamaño2];

        for (int i = 0; i < tamaño1; i++)
            L[i] = arr[left + i];

        for (int j = 0; j < tamaño2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < tamaño1 && j < tamaño2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < tamaño1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < tamaño2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}
