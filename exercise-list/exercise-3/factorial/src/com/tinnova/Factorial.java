package com.tinnova;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int number = getUserNumberInput(sc, "Enter a non-negative integer: ");

        sc.close();

        int factorial = calculateFactorial(number);
        System.out.printf("Factorial of %d is: %d%n", number, factorial);
    }

    public static int calculateFactorial(int number) {
        if (number <= 1) {
            return 1;
        } else {
            return number * calculateFactorial(number - 1);
        }
    }

    private static int getUserNumberInput(Scanner sc, String prompt) {
        int value;
        while (true) {
            System.out.println(prompt);
            value = sc.nextInt();
            if (value >= 0) {
                break;
            } else {
                System.out.println("Invalid input! The value cannot be negative. Please enter again.");
            }
        }
        return value;
    }
}
