package com.company;

public class Main {
    private static int[] fillArray(int begin, int end, int step){
        int n = (int)Math.floor((end-begin)/step + 1);
        int[] arr = new int[n];
        arr[0]=begin;
        for (int i = 1 ; i<n ; i++){
            arr[i]=step + arr[i-1];
        }
        for (int i = 0 ; i<n ; i++){
            System.out.print("[" + arr[i] + "]" + "\t");
        }
        return arr;
    }

    public static void main(String[] args) {
	// write your code here
       fillArray(1,11,3);
    }
}
