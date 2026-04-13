package org.leviatanplatform.crypto.engine.layers;

import org.leviatanplatform.crypto.engine.utils.ByteCyclicIterator;

public class ByteMaskLayer implements Layer {

    @Override
    public byte[] encrypt(byte[] chunk, byte[] effectiveKey) {

        ByteCyclicIterator iteratorKeyBytes = new ByteCyclicIterator(effectiveKey);
        byte[] chunkEncrypted = new byte[chunk.length];

        for (int i = 0; i < chunk.length; i++) {
            byte data = chunk[i];
            byte mask = iteratorKeyBytes.get();
            byte encrypted = (byte) (data ^ mask);
            chunkEncrypted[i] = encrypted;
        }

        return chunkEncrypted;
    }

    @Override
    public byte[] decrypt(byte[] chunk, byte[] effectiveKey) {
        // The process reverts itself
        return encrypt(chunk, effectiveKey);
    }
}
