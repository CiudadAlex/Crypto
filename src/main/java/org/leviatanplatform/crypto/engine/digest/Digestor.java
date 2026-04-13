package org.leviatanplatform.crypto.engine.digest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Digestor {

    private static final MessageDigest md = buildMessageDigest();

    private static MessageDigest buildMessageDigest() {
        try {
            return MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algorithm not available", e);
        }
    }

    public static byte[] digest(byte[] input) {
        return md.digest(input);
    }
}
