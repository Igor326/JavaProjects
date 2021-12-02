package com.company;
import java.util.Scanner;

public class Task_1 {
    public static double parse(String e) {
        String[] number    = e.split("[+\\-*/]");
        String[] operation = e.split("\\d");

        System.arraycopy(operation, 1, operation, 0, operation.length - 1);

        double result = Double.parseDouble(number[0]);

        for (int i = 1; i < operation.length; ++i) {
            switch (operation[i - 1]) {
                case "+":
                    result += Double.parseDouble(number[i]);
                    break;
                case "-":
                    result -= Double.parseDouble(number[i]);
                    break;
                case "*":
                    result *= Double.parseDouble(number[i]);
                    break;
                case "/":
                    result /= Double.parseDouble(number[i]);
                    break;
            }
        }
        return result;
    }

    public static void main(String[] args) {

        String e = (new Scanner(System.in)).nextLine();
        System.out.println(parse(e));
    }
}
