package kv.miniPrograms;

import java.util.Objects;
import java.util.Scanner;

import static kv.miniPrograms.PrimeNumbers.isPrime;
import static kv.miniPrograms.Palindromes.isPalindrome;
import static kv.miniPrograms.PasswordGenerator.generatePassword;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int i;
        Main main = new Main();

        do {
            System.out.println("Select the mini program to run:");
            System.out.println("0. Exit");
            System.out.println("1. Check if number is prime");
            System.out.println("2. Check if a phrase is a palindrome");
            System.out.println("3. Generate a password");

            i = read.nextInt();
            switch (i) {
                case 1:
                    main.runPrimeNumbers();
                    break;
                case 2:
                    main.runPalindromes();
                case 3:
                    main.runPasswordGenerator();
                default:
                    break;
            }

            System.out.println();
        } while (i != 0);

    }

    private void runPasswordGenerator() {
        System.out.println("Generated password:");
        System.out.println(generatePassword());
    }

    private void runPalindromes() {
        Scanner read = new Scanner(System.in);
        String phrase;

        do {
            System.out.print("Write a phrase (or nothing to exit): ");
            phrase = read.nextLine();
            if (Objects.equals(phrase, "")) {
                break;
            }

            if (isPalindrome(phrase)) {
                System.out.println(phrase + " is a palindrome.");
            } else {
                System.out.println(phrase + " is NOT a palindrome.");
            }
        }
        while (true);
    }

    private void runPrimeNumbers() {
        Scanner read = new Scanner(System.in);
        int n;

        do {
            System.out.print("Select a number: ");
            n = read.nextInt();
            if (n == 0) {
                break;
            }

            if (isPrime(n)) {
                System.out.printf("Number %d is prime.\n", n);
            } else {
                System.out.printf("%d is NOT a prime number.\n", n);
            }
        }
        while (true);
    }
}
