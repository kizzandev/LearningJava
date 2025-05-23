package kv.miniPrograms;

import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class PrimeNumbersTest {

    @org.junit.jupiter.api.Test
    @DisplayName("isPrime -> 123")
    void isPrime_iAmNotAPrimeNumberButILookCool() {
        assertFalse(PrimeNumbers.isPrime(123));
    }

    @org.junit.jupiter.api.Test
    @DisplayName("isPrime -> 0 | 1 | -5")
    void isPrime_shouldReturnFalseForNumbersLessThanOrEqualToOne() {
        assertFalse(PrimeNumbers.isPrime(0));
        assertFalse(PrimeNumbers.isPrime(1));
        assertFalse(PrimeNumbers.isPrime(-5));
    }
}