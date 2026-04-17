package org.leviatanplatform.crypto;

import org.leviatanplatform.crypto.engine.CryptoEngine;
import org.leviatanplatform.crypto.engine.files.FileContentExtractor;

import java.io.IOException;

public class Main {

    private static final String PATH_PLAYGROUND = "./.playground";

    public static void main(String[] args) throws IOException {

        String fileName = "Oasis_Morning_Glory";
        String extension = "mp3";

        String pathFilePlain = PATH_PLAYGROUND + "/" + fileName + "." + extension;
        String pathFileEncrypted = pathFilePlain + ".encrypted";
        String pathFileDecrypted = pathFileEncrypted + ".decrypted" + "." + extension;

        //String key = "password-key-to-encrypt";
        byte[] key = FileContentExtractor.extract(PATH_PLAYGROUND + "/RandomFile.key");

        CryptoEngine.encryptFile(pathFilePlain, pathFileEncrypted, key);
        CryptoEngine.decryptFile(pathFileEncrypted, pathFileDecrypted, key);
    }
}
