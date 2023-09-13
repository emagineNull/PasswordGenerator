package org.example;

import java.util.Random;

public class PasswordGenerator {

    public static String GenPassword(int n, boolean up, boolean low, boolean num, boolean sym) {
        String generatedString = "";
        int leftLimit = 33;
        int rightLimit = 126;

        Random random = new Random();

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        StringBuilder sb = new StringBuilder(n);

        if (up && low && num && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (up && low && num) {
            //sb = new StringBuilder(n);

            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789"
                    + "abcdefghijklmnopqrstuvxyz";

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }
        }
        else if (up && low && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> !(i >= 48 && i <= 57))
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (low && num && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> !(i >= 65 && i <= 90))
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (up && num && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> !(i >= 97 && i <= 122))
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (up && low) {
            //sb = new StringBuilder(n);
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "abcdefghijklmnopqrstuvxyz";

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }
        }
        else if (up && num) {
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                    + "0123456789";

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }
        }
        else if (up && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> !(i >= 97 && i <= 122) && !(i >= 48 && i <= 57))
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (low && num) {
            AlphaNumericString = "abcdefghijklmnopqrstuvxyz"
                    + "0123456789";

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }
        }
        else if (low && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> !(i >= 65 && i <= 90) && !(i >= 48 && i <= 57))
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (num && sym) {
            return generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> !(i >= 97 && i <= 122) && !(i >= 65 && i <= 90))
                    .limit(n)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        else if (up) {
            //sb = new StringBuilder(n);
            AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }
        }
        else if (low) {
            AlphaNumericString = "abcdefghijklmnopqrstuvxyz";

            for (int i = 0; i < n; i++) {
                int index = (int)(AlphaNumericString.length() * Math.random());

                sb.append(AlphaNumericString.charAt(index));
            }
        }
        else {
            return "";
        }

        return sb.toString();
    }
}
