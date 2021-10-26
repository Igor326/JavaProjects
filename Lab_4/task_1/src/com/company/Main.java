package com.company;
import  java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        double arrayWithDuplicates[] = {1, 1, 1, 2, 1, 1};

        Arrays.sort(arrayWithDuplicates);

        int len = arrayWithDuplicates.length;

        double [] distinctArray = new double[len];

        int index = 0;

        for (int i = 0; i < len; ++i){
            while (i < len - 1 && arrayWithDuplicates[i] == arrayWithDuplicates[i+1] ){
                i++;
            }
            distinctArray[index] = arrayWithDuplicates[i];
            index++;
        }


            System.out.println(distinctArray[1] );

    }
}
