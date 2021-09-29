package dev.ruster.tp1.utils;

import java.util.Random;

public class Util {

    private static final Random r = new Random();

    public static int randomIntBetween(int min, int max) {
        return r.nextInt(max - min) + min;
    }

    public static void sleep(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}