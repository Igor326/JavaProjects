package com.company;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Array;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.*;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here //////////////////////////////////////Task 1
        List<String> myList = Arrays.asList("a1", "a2", "b1", "c2", "c1");

        Stream stream = myList.stream();
        stream
                .filter(x-> x.toString().charAt(0) == 'c')
                .map(x-> x.toString().toUpperCase())
                .forEach(System.out::println);
        /////////////////////////////////////////////////////////////Task 2
        System.out.println("Set the n value for array capacity: ");
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(n);
        int[] Array  = new int[n];


        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> pair = new ArrayList<Integer>();

        Arrays.stream(Array)
                .map(x-> x = (int)Math.floor( Math.random() * 9+1))
                .forEach((x) -> { arr.add(x); System.out.print("["+ x + "] "); });
        System.out.println(' ');

        arr.stream()
                .filter(x -> x % 2 ==0)
                .forEach((x) -> { pair.add(x); System.out.print("["+ x + "] "); });

        int sum = pair.stream().mapToInt(x -> x).sum();

        System.out.println(sum);
        System.out.println("Average of pair numbers :" + (float)sum/ pair.size());
        ///////////////////////////////////////////////////////////Task 3

        String string = "sjdhgfsjkavchjwagehf";
        Stream<String> stringStream = Stream.of(string);
        String regex = "[h - t]";
        Pattern pattern = Pattern.compile(regex,Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(string);
       stringStream.forEach((x) -> {
          if( matcher.find()){
           System.out.println(x.toUpperCase());}
       });
        //System.out.println(string);

    }
}
