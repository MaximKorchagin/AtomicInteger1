package org.example;

public class TripleLetterThread extends Thread {
    private final String[] texts;

    public TripleLetterThread(String[] texts) {
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            boolean same = true;
            for (int i = 0; i < text.length() - 1; i++) {
                if (text.charAt(i) != text.charAt(0)) {
                    same = false;
                    break;
                }
            }
            if (same) Main.checkLength(text);
        }
    }
}
