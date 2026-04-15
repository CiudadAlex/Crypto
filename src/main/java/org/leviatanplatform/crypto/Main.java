package org.leviatanplatform.crypto;

import org.leviatanplatform.crypto.engine.CryptoEngine;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        encryptAndDecrypt("Oasis_Morning_Glory","mp3");
    }

    private static void encryptAndDecrypt(String fileName, String extension) throws IOException {

        String pathFilePlain = "./.playground/" + fileName + "." + extension;
        String pathFileEncrypted = pathFilePlain + ".encrypted";

        String key = "password-key-to-encrypt";

        CryptoEngine.encryptFile(pathFilePlain, pathFileEncrypted, key);

        String pathFileDecrypted = pathFileEncrypted + ".decrypted" + "." + extension;
        CryptoEngine.decryptFile(pathFileEncrypted, pathFileDecrypted, key);
    }
}
