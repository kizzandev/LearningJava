package kv.miniPrograms;

public class Palindromes {

    /**
     * @param word phrase to be checked if palindrome
     * @param shouldSkipSymbols true if symbols are ignored
     * @return boolean
     */
    public static boolean isPalindrome(String word, boolean shouldSkipSymbols) {
        if (word == null || word.length() <= 1) {
            return false;
        }

        // pointers
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            char cLeft = word.charAt(left);
            char cRight = word.charAt(right);

            if (shouldSkipSymbols && !Character.isLetterOrDigit(cLeft)) {
                left++;
                continue;
            }

            if (shouldSkipSymbols && !Character.isLetterOrDigit(cRight)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    /**
     * @param word phrase to be checked if palindrome
     * @return boolean
     */
    public static boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return false;
        }

        // pointers
        int left = 0;
        int right = word.length() - 1;

        while (left < right) {
            char cLeft = word.charAt(left);
            char cRight = word.charAt(right);

            if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
