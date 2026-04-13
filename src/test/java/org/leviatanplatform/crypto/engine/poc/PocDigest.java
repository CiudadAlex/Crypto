package org.leviatanplatform.crypto.engine.poc;

import org.leviatanplatform.crypto.engine.digest.Digestor;

import java.nio.charset.StandardCharsets;

public class PocDigest {

    public static void main(String[] args) {

        boolean[] arrayBoolean = new boolean[256];

        for (char c = 'a'; c <= 'z'; c++) {
            process(c, arrayBoolean);
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            process(c, arrayBoolean);
        }

        for (char c = '0'; c <= '9'; c++) {
            process(c, arrayBoolean);
        }

        for (boolean bool : arrayBoolean) {

            if (bool) {
                System.out.print("X");
            } else {
                System.out.print(".");
            }

        }
    }

    private static void process(char ch, boolean[] arrayBoolean) {

        byte[] key = (""+ch).getBytes(StandardCharsets.UTF_8);
        byte[] digest = Digestor.digest(key);
        byte digestedByte = digest[0];
        System.out.println(ch + " = " + digestedByte);
        arrayBoolean[digestedByte + 128] = true;
    }
}
