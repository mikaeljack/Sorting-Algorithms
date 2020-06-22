package no.hiof.mikaelaj.sorteringsalgoritmer;

public class MergeSort {

    public static void mergeSort (int[]array, int n) {
        if (n < 2) {
            return;
        }
        int mid = n/2;
        int[] l = new int[mid];
        int[] r = new int[n-mid];

        for (int i = 0; i < mid; i++) {
            l[i] = array[i];
        }

        for (int i = mid; i < n; i++) {
            r[i-mid] = array[i];
        }
        mergeSort(l,mid);
        mergeSort(r, n-mid);

        merge(array,l,r,mid,n-mid);

    }

    public static void merge (int[]array, int[]leftArray, int[]rightArray, int left, int right) {
        int leftArrayIndex = 0, rightArrayIndex = 0, mainArrayIndex = 0;
        while (leftArrayIndex < left && rightArrayIndex < right) {
            if (leftArray[leftArrayIndex] <= rightArray[rightArrayIndex]) {
                array[mainArrayIndex++] = leftArray[leftArrayIndex++];
            }
            else {
                array[mainArrayIndex++] = rightArray[rightArrayIndex++];
            }
        }
        while (leftArrayIndex < left) {
            array[mainArrayIndex++] = leftArray[leftArrayIndex++];
        }
        while (rightArrayIndex < right) {
            array[mainArrayIndex++] = rightArray[rightArrayIndex++];
        }
    }

}
