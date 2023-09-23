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
        //System.out.println(Arrays.toString(texts));
        Thread thread = new PalindromeThread(texts);
        thread.start();
        Thread thread2 = new TripleLetterThread(texts);
        thread2.start();
        Thread thread3 = new AscendingLettersThread(texts);
        thread3.start();
        Thread.sleep(2000);
        System.out.println(fourDigitCounter);
        System.out.println(threeDigitCounter);
        System.out.println(fiveDigitCounter);
    }
    public static String generateText(String letters, int length) {
        Random random = new Random();
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < length; i++) {
            text.append(letters.charAt(random.nextInt(letters.length())));
        }
        return text.toString();
    }
}