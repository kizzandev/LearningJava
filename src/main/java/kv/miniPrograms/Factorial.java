package kv.miniPrograms;

import java.math.BigInteger;

public class Factorial {

    public static int factorial(int number) {
        if (number <= 1) {
            return number;
        }

        return number * factorial(number - 1);
    }

    public static BigInteger factorial(BigInteger number) {
        if (number.compareTo(BigInteger.ONE) <= 0) {
            return number;
        }

        return number.multiply(factorial(number.subtract(BigInteger.ONE)));
    }
}
