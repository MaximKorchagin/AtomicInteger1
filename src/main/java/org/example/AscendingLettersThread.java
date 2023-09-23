package org.example;

public class AscendingLettersThread extends Thread {
    private final String[] texts;

    public AscendingLettersThread(String[] texts) {
        this.texts = texts;
    }

    @Override
    public void run() {

        for (String text : texts) {
            boolean sorted = true;
            for (int i = 0; i < text.length() - 1; i++) {
                if (text.charAt(i) >= text.charAt(i + 1)) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) Main.checkLength(text);
        }

    }
}
