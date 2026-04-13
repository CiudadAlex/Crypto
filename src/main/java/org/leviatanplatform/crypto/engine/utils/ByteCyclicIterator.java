package org.leviatanplatform.crypto.engine.utils;

public class ByteCyclicIterator {

    private final byte[] arrayBytes;
    private int index = 0;

    public ByteCyclicIterator(byte[] arrayBytes) {
        this.arrayBytes = arrayBytes;
    }

    public byte get() {

        byte result = this.arrayBytes[index];

        index++;

        if (index >= arrayBytes.length) {
            index = 0;
        }

        return result;
    }
}
