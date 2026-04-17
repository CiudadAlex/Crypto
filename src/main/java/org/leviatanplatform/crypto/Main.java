package org.leviatanplatform.crypto;

import org.leviatanplatform.crypto.engine.CryptoEngine;
import org.leviatanplatform.crypto.engine.files.FileContentExtractor;

import java.io.IOException;

public class Main {

    private static final String PATH_PLAYGROUND = "./.playground";

    public static void main(String[] args) throws IOException {

        String key = "password-key-to-encrypt";
        encryptAndDecrypt("Oasis_Morning_Glory","mp3", key);

        FileContentExtractor.extract(PATH_PLAYGROUND + "/RandomFile.key");

        // FIXME key importada de fichero
    }

    private static void encryptAndDecrypt(String fileName, String extension, String key) throws IOException {

        String pathFilePlain = PATH_PLAYGROUND + "/" + fileName + "." + extension;
        String pathFileEncrypted = pathFilePlain + ".encrypted";

        CryptoEngine.encryptFile(pathFilePlain, pathFileEncrypted, key);

        String pathFileDecrypted = pathFileEncrypted + ".decrypted" + "." + extension;
        CryptoEngine.decryptFile(pathFileEncrypted, pathFileDecrypted, key);
    }
}
