package org.leviatanplatform.crypto.engine.files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileContentWriter {

    private FileOutputStream fos;

    public FileContentWriter(String pathFile) throws IOException {
        this(new File(pathFile));
    }

    public FileContentWriter(File file) throws IOException {
        fos = new FileOutputStream(file);
    }

    public void close() throws IOException {
        fos.close();
    }

    public void writeChunk(byte[] chunk) throws IOException {
        fos.write(chunk);
        fos.flush();
    }
}
