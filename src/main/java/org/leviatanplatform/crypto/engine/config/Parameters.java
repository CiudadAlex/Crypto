package org.leviatanplatform.crypto.engine.config;

public class Parameters {

    private static final Parameters instance = new Parameters();

    public static Parameters getInstance() {
        return instance;
    }

    private final int lengthBlockBytes = 100 * 1024;

    public int getLengthBlockBytes() {
        return lengthBlockBytes;
    }
}
