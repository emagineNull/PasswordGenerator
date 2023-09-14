package org.example;

import java.util.Random;

public class PasswordGenerator {
    private static Random random = new Random();
    private static int leftLimit = 33;
    private static int rightLimit = 126;

    public static String GenPassword(int n, boolean up, boolean low, boolean num, boolean sym) {
        String AlphaNumericString = "";
        StringBuilder sb = new StringBuilder(n);

        if (up && low && num && sym) {
            return StrGen(n);
        }
        else if (up && low && num) {
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            return AlphaNumStrGen(sb, n, AlphaNumericString);
        }
        else if (up && low && sym) { // 48 57
            return StrGen(n, 48, 57);
        }
        else if (low && num && sym) { // 65 90
            return StrGen(n, 65, 90);
        }
        else if (up && num && sym) { // 97 122
            return StrGen(n, 97, 122);
        }
        else if (up && low) {
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz";

            return AlphaNumStrGen(sb, n, AlphaNumericString);
        }
        else if (up && num) {
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789";

            return AlphaNumStrGen(sb, n, AlphaNumericString);
        }
        else if (up && sym) { // 97 122 48 57
            return StrGen(n, 97, 122, 48, 57);
        }
        else if (low && num) {
            AlphaNumericString = "abcdefghijklmnopqrstuvxyz"
                    + "0123456789";

            return AlphaNumStrGen(sb, n, AlphaNumericString);
        }
        else if (low && sym) { // 65 90 48 57
            return StrGen(n, 65, 90, 48, 57);
        }
        else if (num && sym) { // 97 122 65 90
            return StrGen(n, 97, 122, 65, 90);
        }
        else if (up) {
            //sb = new StringBuilder(n);
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            return AlphaNumStrGen(sb, n, AlphaNumericString);
        }
        else if (low) {
            AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

            return AlphaNumStrGen(sb, n, AlphaNumericString);
        }
        else {
            return "";
        }
    }

    public static String StrGen(int n) {
        return random.ints(leftLimit, rightLimit + 1)
                .limit(n)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
    public static String StrGen(int n, int x, int y) {
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> !(i >= x && i <= y))
                .limit(n)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String StrGen(int n, int x, int y, int x1, int y1) {
        return random.ints(leftLimit, rightLimit + 1)
                .filter(i -> !(i >= x && i <= y) && !(i >= x1 && i <= y1))
                .limit(n)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    public static String AlphaNumStrGen(StringBuilder sb, int n, String AlphaNumericString) {
        for (int i = 0; i < n; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString.charAt(index));
        }

        return sb.toString();
    }
}
