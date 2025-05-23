package kv.miniPrograms;

import java.util.Scanner;

import static kv.miniPrograms.PrimeNumbers.isPrime;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int i;
        Main main = new Main();

        do {
            System.out.println("Select the mini program to run.");
            System.out.println("0. Exit");
            System.out.println("1. isPrime");

            i = read.nextInt();
            switch (i) {
                case 1:
                    main.runPrimeNumbers();
                    break;
                default:
                    break;
            }

        } while (i != 0);

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
