package kv.miniPrograms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnagramTest {

    @Nested
    @DisplayName("Valid")
    class ValidAnagrams {

        @Test
        @DisplayName("Really?")
        void anagram_really() {
            assertTrue(Anagram.isAnagram("anagram", "nagaram"));
        }

        @Test
        @DisplayName("Is this you?")
        void anagram_isThisYou() {
            assertTrue(Anagram.isAnagram("Debit card", "Bad credit"));
        }

        @Test
        @DisplayName("I have no words.")
        void anagram_empty() {
            assertTrue(Anagram.isAnagram("", ""));
        }
    }

    @Nested
    @DisplayName("Not Valid Anagrams")
    class NotValidAnagrams {

        @Test
        @DisplayName("Size matters.")
        void anagram_sizeMatters() {
            assertFalse(Anagram.isAnagram("apple", "ape"));
        }

        @Test
        @DisplayName("We are not the same.")
        void anagram_notTheSame() {
            assertFalse(Anagram.isAnagram("elegant", "jacuzzi"));
        }

        @Test
        @DisplayName("Its been a long time.")
        void anagram_seeYouAgain() {
            assertFalse(Anagram.isAnagram("aab", "abb"));
        }

        @Test
        @DisplayName("Mistakes.")
        void anagram_null() {
            assertFalse(Anagram.isAnagram("Is this", null));
            assertFalse(Anagram.isAnagram(null, "ish"));
        }
    }
}