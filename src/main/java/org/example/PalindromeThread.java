package org.example;

public class PalindromeThread extends Thread {

    private final String[] texts;

    public PalindromeThread(String[] texts) {
        this.texts = texts;
    }

    @Override
    public void run() {

        for (String text : texts) {
            String reverseString = "";
            for (int j = (text.length() - 1); j >= 0; --j) {
                reverseString = reverseString + text.charAt(j);
            }
            if (text.equals(reverseString)) Main.checkLength(text);
        }
    }
}
