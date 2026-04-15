package org.leviatanplatform.crypto.engine.config;

import java.io.InputStream;
import java.util.Properties;

public class Parameters {

    private static final Parameters instance = new Parameters();

    public static Parameters getInstance() {
        return instance;
    }

    private final int lengthBlockBytes = 100 * 1024;

    public int getLengthBlockBytes() {
        return lengthBlockBytes;
    }

    private static void load() throws Exception {

        // FIXME finish

        Properties props = new Properties();

        try (InputStream input = Parameters.class
                .getClassLoader()
                .getResourceAsStream("config.properties")) {

            if (input == null) {
                throw new RuntimeException("File not found");
            }

            props.load(input);
        }

        String valor = props.getProperty("birthdate");
        System.out.println(valor);
    }
}
