package com.company;
import java.util.Scanner;

public class Task_3 {
    public static void task3() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder wordList = new StringBuilder();

        while (true) {
            System.out.print("Виберіть функцію: 1 - ввести нове слово, 2 - показати попередні слова, 3 - вихід: ");

            String line = scanner.nextLine();

            switch (line) {
                case "1":
                    String word = scanner.nextLine();

                    if (word.contains("+")) {
                        wordList.append(word.substring(1)).append(" ");

                    } else if (word.contains("-")) {
                        if (wordList.toString().contains(word.substring(1)))
                            wordList = new StringBuilder(wordList.toString().replace(word.substring(1) + " ", ""));
                        else
                            System.out.println("Не знайдено слів для вводу");

                    }
                    break;

                case "2":
                    System.out.println(wordList.toString());
                    break;

                case "3":
                    return;
            }
        }

    }
    public static void main(String[] args) {
        task3();
    }

}


