package kv.miniPrograms;


import java.security.SecureRandom; // I wrote .Ran and this guy came up

public class PasswordGenerator {

    static String generatePassword() {
        StringBuilder allChars = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            allChars.append((char) ('a' + i));
            allChars.append((char) ('A' + i));
        }
        for (int i = 0; i < 10; i++) {
            allChars.append((char) ('0' + i));
        }

        SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 16; i++) {
            int opt = random.nextInt(allChars.length()); // Works!
            result.append(allChars.charAt(opt));
        }

        return result.toString();
    }
}
