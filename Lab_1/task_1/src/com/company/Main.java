package com.company;

public class Main {
    private static void printArray(int[][] arr){
        int n =0;
        int m =0;
        n= arr.length;
        m = arr[0].length;
        for (int i =0; i<n;i++)
        {
            for (int j = 0;j<m;j++)
            {
                System.out.print("[" + arr[i][j]+ "]" + "\t");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
	// write your code here
        int n =3;
        int m =3;
        int[][] arr = new int[n][m];

        for (int i =0; i<n;i++)
        {
            for (int j = 0;j<m;j++)
            {
               arr[i][j] = (int) Math.round((Math.random()*9));
            }
        }
        printArray(arr);
        int max = 0;
        boolean found = true;

        for (int i =0; i<n;i++)
        {
            int temp = arr[i][arr.length-i-1];
            if(temp % 2 == 0){
                System.out.println(arr[i][arr.length-i-1] );
                }
            }
        }

        
    }

