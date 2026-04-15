package org.leviatanplatform.crypto;

import org.leviatanplatform.crypto.engine.CryptoEngine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        String pathFilePlain = "./.playground/";
        String pathFileEncrypted = "./.playground/Oasis_Morning_Glory.mp3";
        String key = "password-key-to-encrypt";
        CryptoEngine.encryptFile(pathFilePlain, pathFileEncrypted, key);
    }
}
