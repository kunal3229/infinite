package com.example.kunal.dsa.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3,6,5,8,9,1,2,7};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(low < high){
            int idx = partition(arr, low, high);
            quickSort(arr, low, idx-1);
            quickSort(arr, idx+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int left = low;
        int right = high;
        int pivot = arr[low];
        for(int i = high; i > low; i--){
            if (arr[i] > pivot){
                swapEle(arr, i, right--);
            }
        }
        swapEle(arr, left, right);
        return right;
    }

    private static void swapEle(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
