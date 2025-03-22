package com.tinnova;

import java.util.Scanner;

public class SumMultiples {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = getUserNumberInput(sc, "Enter a natural number: ");

        sc.close();

        int sum = sumMultiplesOf3Or5(number);
        System.out.printf("The sum of the natural numbers that are multiples of 3 or 5 and below %d is: %d%n", number, sum);

    }

    public static int sumMultiplesOf3Or5(int number) {
        int sum = 0;

        for (int i = 3; i < number; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        return sum;
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
