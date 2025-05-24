package kv.miniPrograms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static kv.miniPrograms.Factorial.factorial;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    @DisplayName("Some factorials")
    void factorial_test() {
        assertEquals(6, factorial(3));
        assertEquals(120, factorial(5));
        assertEquals(720, factorial(6));
        assertEquals(479001600, factorial(12));
    }

    @Test
    @DisplayName("Some big factorials")
    void factorial_big_test() {
        assertEquals(BigInteger.valueOf(6), factorial(BigInteger.valueOf(3)));
        assertEquals(BigInteger.valueOf(120), factorial(BigInteger.valueOf(5)));
        assertEquals(BigInteger.valueOf(720), factorial(BigInteger.valueOf(6)));
        assertEquals(BigInteger.valueOf(479001600), factorial(BigInteger.valueOf(12)));
    }
}