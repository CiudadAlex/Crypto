package org.leviatanplatform.crypto.engine;

import org.leviatanplatform.crypto.engine.files.FileContentIterator;

import java.io.IOException;

public class CryptoEngine {

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, String key) throws IOException {
        encryptFile(pathFilePlain, pathFileEncrypted, key.getBytes());
    }

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, byte[] key) throws IOException {

        FileContentIterator fileContentIterator = new FileContentIterator(pathFilePlain);
    }
}
