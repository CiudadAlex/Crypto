package org.leviatanplatform.crypto.engine.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileContentIterator {

    private FileInputStream fis;

    public FileContentIterator(String pathFile) throws IOException {
        this(new File(pathFile));
    }

    public FileContentIterator(File file) throws IOException {
        fis = new FileInputStream(file);
    }

    public void close() throws IOException {
        fis.close();
    }

    public byte[] getChunk(int lengthChunk) throws IOException {

        byte[] buffer = new byte[lengthChunk];

        int readBytes = fis.read(buffer);
        if (readBytes == lengthChunk) {
            return buffer;
        }

        if (readBytes == -1) {
            return null;
        }

        byte[] lastBuffer = new byte[readBytes];
        System.arraycopy(buffer, 0, lastBuffer, 0, readBytes);

        int shouldHaveNone = fis.read(buffer);

        if (shouldHaveNone == -1) {
            return lastBuffer;
        }

        throw new RuntimeException("Erratic behaviour of FileInputStream");
    }
}
