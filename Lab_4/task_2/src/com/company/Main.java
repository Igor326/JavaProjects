package com.company;
import java.util.Arrays;
import java.util.Collections;
public class Main {




    public static void main(String[] args) {
	// write your code here
        int []arr = {5, 3, 2, 8, 1, 4};

        int count = arr.length;
        int temp;

        for (int i = 0; i < count; i++)
        {
            for (int j = i + 1; j < count; j++)
            {
                if (arr[i] > arr[j] && arr[i] % 2 != 0 && arr[j] % 2 != 0)
                {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < count; i++)
        {
            System.out.print(arr[i] + ", ");
        }
    }
}
