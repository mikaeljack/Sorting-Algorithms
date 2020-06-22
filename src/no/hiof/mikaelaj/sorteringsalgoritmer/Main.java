package no.hiof.mikaelaj.sorteringsalgoritmer;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int chooseSort;
        double constant;

        System.out.println("-------------------------------------------------------");
        System.out.println(" 1: Insertion sort \n 2: Quick sort \n 3: Merge sort \n 4: Radix sort \n 5: Exit program ");
        System.out.println("-------------------------------------------------------");
        System.out.println("Please select a number: ");
        chooseSort = Integer.parseInt(scanner.nextLine());

        if(chooseSort == 5) {
            System.exit(0);
        }

        System.out.println("How many numbers do you want to sort?: ");
        int number = Integer.parseInt(scanner.nextLine());
        int[] sortArray = new int[number];

        for (int i = 0; i <sortArray.length; i++) {
            sortArray[i] = (int) (Math.random() * 1000);
        }

        long time = System.currentTimeMillis();

        System.out.println("Unsorted: " + (Arrays.toString(sortArray)) +"\n");

        switch (chooseSort) {
            case 1:
                System.out.println("Insertion Sort: ");
                InsertionSort.insertionSort(sortArray, sortArray.length -1/2);
                System.out.println(Arrays.toString(sortArray));
                time = System.currentTimeMillis() - time;
                System.out.println("Runtime Insertion sort: " + time/1000.0 + " ms");
                constant = (float) time/(number*number);
                System.out.println("The constant is: " + constant);
                break;
            case 2:
                System.out.println("Quick Sort: ");
                QuickSort.quickSort(sortArray, 0, sortArray.length-1);
                System.out.println(Arrays.toString(sortArray));
                time = System.currentTimeMillis() - time;
                System.out.println("Runtime Quick sort: " + time/1000.0 + " ms");
                constant = (float) (time / (number*Math.log(number)));
                System.out.println("The constant is: " + constant);
                break;
            case 3:
                System.out.println("Merge Sort: ");
                MergeSort.mergeSort(sortArray, sortArray.length-1/2);
                System.out.println(Arrays.toString(sortArray));
                time = System.currentTimeMillis() - time;
                System.out.println("Runtime Merge sort: " + time/1000.0 + " ms");
                constant = (float) (time / (number*Math.log(number)));
                System.out.println("The constant is: " + constant);
                break;
            case 4:
                int biggestNumber = 999;
                int lengthDigits = String.valueOf(biggestNumber).length();
                System.out.println("Radix Sort: ");
                RadixSort.radixSort(sortArray, sortArray.length-1/2);
                System.out.println(Arrays.toString(sortArray));
                time = System.currentTimeMillis() - time;
                System.out.println("Runtime Radix sort: " + time/1000.0 + " ms");
                constant = (float) time / (number*lengthDigits);
                System.out.println("The constant is: " + constant);
                break;
        }
    }
}
