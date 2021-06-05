package ru.vsu.cs.pekanov;
import java.util.Arrays;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        int[] x = { 8, 0, 4, 7, 3, 7, 10, 12, -3 };

        System.out.println("Было");
        System.out.println(Arrays.toString(x));

        int low = 0;
        int high = x.length - 1;

        quickSortPivotEnd(x,low, high);

        System.out.println("Стало");
        System.out.println(Arrays.toString(x));

    }


    static void random(int arr[],int low,int high)
    {

        Random rand= new Random();
        int pivot = rand.nextInt(high-low)+low;

        int temp1=arr[pivot];
        arr[pivot]=arr[high];
        arr[high]=temp1;
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
        random(arr, begin, end);
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








}