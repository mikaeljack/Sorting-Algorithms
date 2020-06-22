package no.hiof.mikaelaj.sorteringsalgoritmer;

public class InsertionSort {

    public static void insertionSort(int[] input, int i) {
        if (i <= 1) {
            return;
        }
        insertionSort(input, i - 1);
        int key = input[i - 1];
        int index = i - 2;
        while (index >= 0 && input[index] > key) {
            input[index + 1] = input[index];
            index = index - 1;
        }
        input[index + 1] = key;
    }

}
