package kv.miniPrograms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordGeneratorTest {

    @Test
    @DisplayName("What to test here..")
    void generatePassword_First() {
        assertNotSame("abcdefghijklmnop", PasswordGenerator.generatePassword());
    }
}