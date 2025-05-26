package kv.miniPrograms;

import java.math.BigInteger;
import java.util.*;

import static kv.miniPrograms.Factorial.factorial;
import static kv.miniPrograms.PrimeNumbers.isPrime;
import static kv.miniPrograms.Palindromes.isPalindrome;
import static kv.miniPrograms.PasswordGenerator.generatePassword;

public class Main {
    private static final Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        int i;
        Main main = new Main();

        do {
            System.out.println("""
                    Select the mini program to run:
                    0. Exit
                    1. Check if number is prime
                    2. Check if a phrase is a palindrome
                    3. Generate a password
                    4. Factorial
                    5. Stack
                    6. Anagram""");

            i = Integer.parseInt(read.nextLine());
            switch (i) {
                case 1:
                    main.runPrimeNumbers();
                    break;
                case 2:
                    main.runPalindromes();
                    break;
                case 3:
                    main.runPasswordGenerator();
                    break;
                case 4:
                    main.runFactorial();
                    break;
                case 5:
                    main.runStack();
                    break;
                case 6:
                    main.runAnagram();
                    break;
                default:
                    break;
            }

            System.out.println();
        } while (i != 0);

        read.close();
    }

    private void runAnagram() {
//        read.nextLine();
        System.out.println("Anagram");
        System.out.print("First string: ");
        String first = read.nextLine();
        System.out.print("Second string: ");
        String second = read.nextLine();

        if (Anagram.isAnagram(first, second)) {
            System.out.println(first + " is an anagram of " + second);
        } else {
            System.out.println(first + " is NOT an anagram of " + second);
        }
    }

    private void runStack() {
        Stack<Integer> iStack = new Stack<>();
        int opt;
        System.out.println("Stack: " + iStack.toString());
        do {
            System.out.println("""
                    Choose:
                    0. exit
                    1. add number
                    2. remove number
                    3. clear stack
                    4. size""");
            opt = Integer.parseInt(read.nextLine());
            if (opt == 1) {
                System.out.print("To add: ");
                opt = Integer.parseInt(read.nextLine());
                iStack.push(opt);
                System.out.println("Stack: " + iStack.toString() + '\n');
            } else if (opt == 2) {
                iStack.pop();
                System.out.println("Stack: " + iStack.toString() + '\n');
            } else if (opt == 3) {
                iStack.clear();
                System.out.println("Stack: " + iStack.toString() + '\n');
            } else if (opt == 4) {
                System.out.println("Size: " + iStack.size() + '\n');
            }
        } while (opt != 0);
    }

    private void runFactorial() {
        System.out.println("""
                Choose:
                1. normal int
                2. big int""");
        int n = Integer.parseInt(read.nextLine());;
        System.out.print("Calculate the factorial of: ");

        if (n == 1) {
            n = Integer.parseInt(read.nextLine());;
            System.out.println("Result: " + factorial(n));
        } else if (n == 2) {
//            BigInteger bn = read.nextBigInteger();
            BigInteger bn = BigInteger.valueOf(Integer.parseInt(read.nextLine()));
            System.out.println("Result: " + factorial(bn));
        }
    }

    private void runPasswordGenerator() {
        System.out.println("Generated password:");
        System.out.println(generatePassword());
    }

    private void runPalindromes() {
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
        int n;

        do {
            System.out.print("Select a number: ");
            n = Integer.parseInt(read.nextLine());;
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
