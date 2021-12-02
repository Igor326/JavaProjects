package com.company;

public class Task_2 {
    public static void fillArr(int[] arr) {
        int mid = arr.length / 2;
        mid = (arr.length % 2 == 0) ? mid : mid + 1;

        int k = mid;
        for(int beg = 0; beg < mid; ++beg) {
            arr[beg] = --k;
        }

        k = mid;
        for(int end = arr.length - 1; end >= mid; --end) {
            arr[end] = --k;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[7];

        fillArr(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
