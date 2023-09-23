package org.example;

public class TripleLetterThread extends Thread {
    private final String[] texts;

    public TripleLetterThread(String[] texts) {
        this.texts = texts;
    }

    @Override
    public void run() {
        for (String text : texts) {
            if (text.equals("aaa") || (text.equals("bbb") || (text.equals("ccc")))) {
                Main.threeDigitCounter.getAndIncrement();
            }
        }
    }
}
