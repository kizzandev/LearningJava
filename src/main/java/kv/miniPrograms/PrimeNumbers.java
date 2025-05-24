package kv.miniPrograms;

public class PrimeNumbers {

    /**
     * Check if a number is a prime
     * @param number number to be evaluated
     * @return boolean
     */
    static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number > 2 && number % 2 == 0) {
            return false;
        }

        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}


