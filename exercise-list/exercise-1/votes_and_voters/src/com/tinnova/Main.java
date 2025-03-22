package com.tinnova;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        double validVotes = getUserVoteInput(sc,"Enter the number of valid votes: ");
        double blankVotes = getUserVoteInput(sc,"Enter the number of blank votes: ");
        double nullVotes = getUserVoteInput(sc,"Enter the number of null votes: ");

        
        sc.close();

        Election election = new Election(validVotes, blankVotes, nullVotes);

        System.out.println("==== Election Result ======\n");

        System.out.println("Percentage of valid votes: " + String.format("%.2f", election.getPercentageValidVotes()) + "%");
        System.out.println("Percentage of blank votes: " + String.format("%.2f", election.getPercentageBlankVotes()) + "%");
        System.out.println("Percentage of null votes: " + String.format("%.2f", election.getPercentageNullVotes()) + "%");
        
    }

     private static double getUserVoteInput(Scanner sc,String prompt) {
        double value;
        while (true) {
            System.out.println(prompt);
            value = sc.nextDouble();
            if (value >= 0) {
                break;
            } else {
                System.out.println("Invalid input! The value cannot be negative. Please enter again.");
            }
        }
        return value;
    }
}