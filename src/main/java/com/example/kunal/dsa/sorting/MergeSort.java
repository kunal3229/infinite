package com.example.kunal.dsa.sorting;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,6,9,1,2,5,3};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(low >= high) return;
        int mid = (low + high) >>> 1;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        mergeArray(arr, low, mid, high);
    }

    private static void mergeArray(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int left = low;
        int right = mid + 1;
        while(left <= mid && right <= high){
            if(arr[left] <= arr[right]){
                temp.add(arr[left++]);
            }
            else{
                temp.add(arr[right++]);
            }
        }
        while(left <= mid){
            temp.add(arr[left++]);
        }
        while (right <= high){
            temp.add(arr[right++]);
        }

        for (int i = low; i <= high; i++){
            arr[i] = temp.get(i - low);
        }
    }
}
