package com.tinnova;

public class BubbleSort {

    public static void bubbleSort(int[] vector) {
        int n = vector.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (vector[j] > vector[j + 1]) {
                    int temp = vector[j];
                    vector[j] = vector[j + 1];
                    vector[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void printVector(int[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] v = {5, 3, 2, 4, 7, 1, 0, 6};
        System.out.println("Vetor antes da ordenação:");
        printVector(v);

        bubbleSort(v);

        System.out.println("Vetor após a ordenação:");
        printVector(v);
    }
}


