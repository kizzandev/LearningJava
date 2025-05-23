package kv.miniPrograms;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class PalindromesTest {

    @Test
    @DisplayName("Racecar")
    void isPalindrome_LetsGoBrummmmmmm() {
        assertTrue(Palindromes.isPalindrome("Racecar"));
    }

    @Test
    @DisplayName("Food based")
    void isPalindrome_WeAllTalkingAboutFoodHere() {
        assertTrue(Palindromes.isPalindrome("A nut for a jar of tuna.", true));
    }

    @Test
    @DisplayName("Italy mentioned")
    void isPalindrome_MammaMia() {
        assertTrue(Palindromes.isPalindrome("Amore, Roma.", true));
    }

    @Test
    @DisplayName("Found it online")
    void isPalindrome_IDoNotGetIT() {
        assertTrue(Palindromes.isPalindrome("""
                Are we not pure? "No, sir!" Panama’s moody Noriega brags. "It is garbage!"
                Irony dooms a man—a prisoner up to new era.""", true));
    }

    @Test
    @DisplayName("Faker")
    void isPalindrome_NotEverythingIsTrue() {
        assertFalse(Palindromes.isPalindrome("Todo se puede hacer"));
    }
}