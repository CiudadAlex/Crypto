package org.leviatanplatform.crypto.engine.key;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EffectiveKeyGenerator {

    private static final MessageDigest md = buildMessageDigest();

    private static MessageDigest buildMessageDigest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algorithm not available", e);
        }
    }

    public static byte[] generateEffectiveKey(byte[] key) {

        // FIXME apply algorithmKey
        // FIXME hash to randomize the bits (distribuidos equitativamente)

        return key;
    }

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
        byte[] digest = md.digest(key);
        byte digestedByte = digest[0];
        System.out.println(ch + " = " + digestedByte);
        arrayBoolean[digestedByte + 128] = true;
    }
}
