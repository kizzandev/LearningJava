package kv.miniPrograms;

import java.math.BigInteger;
import java.util.*;

import static kv.miniPrograms.Factorial.factorial;
import static kv.miniPrograms.PrimeNumbers.isPrime;
import static kv.miniPrograms.Palindromes.isPalindrome;
import static kv.miniPrograms.PasswordGenerator.generatePassword;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int i;
        Main main = new Main();

        do {
            System.out.println("""
                    Select the mini program to run:
                    0. Exit
                    1. Check if number is prime
                    2. Check if a phrase is a palindrome
                    3. Generate a password
                    4. Factorial""");

            i = read.nextInt();
            switch (i) {
                case 1:
                    main.runPrimeNumbers();
                    break;
                case 2:
                    main.runPalindromes();
                case 3:
                    main.runPasswordGenerator();
                case 4:
                    main.runFactorial();
                default:
                    break;
            }

            System.out.println();
        } while (i != 0);

    }

    private void runFactorial() {
        Scanner read = new Scanner(System.in);
        System.out.println("""
                Choose:
                1. normal int
                2. big int""");
        int n = read.nextInt();
        System.out.print("Calculate the factorial of: ");

        if (n == 1) {
            n = read.nextInt();
            System.out.println("Result: " + factorial(n));
        } else if (n == 2) {
            BigInteger bn = read.nextBigInteger();
            System.out.println("Result: " + factorial(bn));
        }
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
