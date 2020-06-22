package no.hiof.mikaelaj.sorteringsalgoritmer;

import java.util.*;

public class RadixSort {

    static int getMaximum(int array[], int number) {
        int maximum = array[0];
        for (int i = 1; i < number; i++)
            if (array[i] > maximum)
                maximum = array[i];
        return maximum;
    }

    static void countSort(int array[], int number, int exp) {
        int output[] = new int[number];
        int i;
        int counter[] = new int[10];
        Arrays.fill(counter,0);

        for (i = 0; i < number; i++)
            counter[ (array[i]/exp)%10 ]++;

        for (i = 1; i < 10; i++)
            counter[i] += counter[i - 1];

        for (i = number - 1; i >= 0; i--) {

            output[counter[ (array[i]/exp)%10 ] - 1] = array[i];
            counter[ (array[i]/exp)%10 ]--;
        }

        for (i = 0; i < number; i++)
            array[i] = output[i];
    }

    static void radixSort(int arr[], int n) {

        int maximumNumber = getMaximum(arr, n);

        for (int exp = 1; maximumNumber/exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }
}
