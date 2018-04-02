package edu.moravian.mathcs.passwordgenerator;

import java.util.Random;

public class Password {

    private static String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static String UPPERCASE = LOWERCASE.toUpperCase();
    private static String NUMBERS   = "0123456789";
    private static String SYMBOLS   = "@#$%";

    static String generate(int length, boolean includeSymbols, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase) {
        String password = "";
        String symbols = "";
        Random r = new Random();
        if (includeSymbols) {
            password += SYMBOLS.charAt(r.nextInt(SYMBOLS.length()));
            symbols += SYMBOLS;
        }
        if (includeNumbers) {
            password += NUMBERS.charAt(r.nextInt(NUMBERS.length()));
            symbols += NUMBERS;
        }
        if (includeLowercase) {
            password += LOWERCASE.charAt(r.nextInt(LOWERCASE.length()));
            symbols += LOWERCASE;
        }
        if (includeUppercase) {
            password += UPPERCASE.charAt(r.nextInt(UPPERCASE.length()));
            symbols += UPPERCASE;
        }
        int currentSize = password.length();
        for (int i = 0; i < length - currentSize; i++)
            password += symbols.charAt(r.nextInt(symbols.length()));
        return shuffle(password);
    }

    private static String shuffle(String password) {
        Random r = new Random();
        char characters[] = password.toCharArray();
        int size = password.length();
        for (int i = 0; i < password.length(); i++) {
            int j = r.nextInt(size);
            int k = r.nextInt(size);
            char temp = characters[i];
            characters[i] = characters[j];
            characters[j] = temp;
        }
        return new String(characters);
    }
}

