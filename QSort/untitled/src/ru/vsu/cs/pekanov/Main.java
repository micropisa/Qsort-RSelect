package ru.vsu.cs.pekanov;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };

        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSortPivotEnd(x,low, high);
        quickSortPivotBegin(x,low, high);



        System.out.println("Стало");
        System.out.println(Arrays.toString(x));

    }

//Опорный элемент конец массива
    public static void quickSortPivotEnd(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionPivotEnd(arr, begin, end);

            quickSortPivotEnd(arr, begin, partitionIndex-1);
            quickSortPivotEnd(arr, partitionIndex+1, end);
        }
    }
    public static int partitionPivotEnd(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

//Опорный элемент начало массива
    public static void quickSortPivotBegin(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partitionPivotBegin(arr, begin, end);

            quickSortPivotBegin(arr, begin, partitionIndex-1);
            quickSortPivotBegin(arr, partitionIndex+1, end);
        }
    }
    public static int partitionPivotBegin(int arr[], int begin, int end) {
        int pivot = arr[begin];
        int i = (end+1);

        for (int j = end; j > begin; j--) {
            if (arr[j] >= pivot) {
                i--;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i-1];
        arr[i-1] = arr[begin];
        arr[begin] = swapTemp;

        return i-1;
    }



    



}
