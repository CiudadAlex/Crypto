package org.leviatanplatform.crypto.engine.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileContentExtractor {

    public static byte[] extract(String pathFile) throws IOException {

        File file = new File(pathFile);

        if (!file.exists()) {
            throw new RuntimeException("File does not exist: " + file.getCanonicalPath());
        }

        if (!file.isFile()) {
            throw new RuntimeException("The path does not represent a file: " + file.getCanonicalPath());
        }

        FileInputStream fis = new FileInputStream(file);
        int fileLength = (int) file.length();
        byte[] arrayBytes = new byte[fileLength];

        for (int i = 0; i < fileLength; i++) {
            arrayBytes[i] = (byte) fis.read();
        }

        fis.close();
        return arrayBytes;
    }
}
