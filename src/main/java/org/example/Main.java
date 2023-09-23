package org.example;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;


public class Main {

    public static AtomicInteger threeDigitCounter = new AtomicInteger(0);
    public static AtomicInteger fourDigitCounter = new AtomicInteger(0);
    public static AtomicInteger fiveDigitCounter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();
        String[] texts = new String[100_000];
        for (int i = 0; i < texts.length; i++) {
            texts[i] = generateText("abc", 3 + random.nextInt(3));
        }
        Thread thread = new PalindromeThread(texts);
        thread.start();
        thread.join();
        Thread thread2 = new TripleLetterThread(texts);
        thread2.start();
        thread2.join();
        Thread thread3 = new AscendingLettersThread(texts);
        thread3.start();
        thread3.join();
        System.out.println("Krasivie slova s dlinoi 3: " + threeDigitCounter);
        System.out.println("Krasivie slova s dlinoi 4: " + fourDigitCounter);
        System.out.println("Krasivie slova s dlinoi 5: " + fiveDigitCounter);
    }
    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
    public static void checkLength(String text) {
            if (text.length() == 3) {
                Main.threeDigitCounter.getAndIncrement();
            } else if (text.length() == 4) {
                Main.fourDigitCounter.getAndIncrement();
            } else if (text.length() == 5) {
                Main.fiveDigitCounter.getAndIncrement();
            }
    }
}