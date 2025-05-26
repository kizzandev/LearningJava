package kv.miniPrograms;

public class Anagram {

    static boolean isAnagram(String str, String other) {
        if (str == null || other == null) {
            return false;
        }
        if (str.length() != other.length()) {
            return false;
        }

        int[] charCount = new int[256];

        String lower_str = str.toLowerCase();
        String lower_other = other.toLowerCase();

        for (char c : lower_str.toCharArray()) {
            charCount[c]++;
        }
        for (char c : lower_other.toCharArray()) {
            charCount[c]--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
