package org.leviatanplatform.crypto.engine;

import org.leviatanplatform.crypto.engine.config.Parameters;
import org.leviatanplatform.crypto.engine.files.FileContentIterator;

import java.io.IOException;

public class CryptoEngine {

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, String key) throws IOException {
        encryptFile(pathFilePlain, pathFileEncrypted, key.getBytes());
    }

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, byte[] key) throws IOException {

        int lengthBlockBytes = Parameters.getInstance().getLengthBlockBytes();
        FileContentIterator fileContentIterator = new FileContentIterator(pathFilePlain);

        byte[] chunk = fileContentIterator.getChunk(lengthBlockBytes);
        while (chunk != null) {

            // FIXME apply layers

            chunk = fileContentIterator.getChunk(lengthBlockBytes);
        }
    }
}
