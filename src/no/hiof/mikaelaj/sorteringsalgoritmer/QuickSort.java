package no.hiof.mikaelaj.sorteringsalgoritmer;

public class QuickSort {

    public static void quickSort(int array[], int start, int end) {
        if (start < end) {
            int index = partition(array, start, end);

            quickSort(array,start, index-1);
            quickSort(array, index+1, end);
        }
    }

    private static int partition(int a[], int start, int end) {
        int pivot = a[end];
        int i = (start-1);

        for (int j = start; j < end; j++) {
            if (a[j] <= pivot) {
                i++;

                int swapTemp = a[i];
                a[i] = a[j];
                a[j] = swapTemp;
            }
        }

        int swapTemp = a[i+1];
        a[i+1] = a[end];
        a[end] = swapTemp;

        return i+1;
    }

}
