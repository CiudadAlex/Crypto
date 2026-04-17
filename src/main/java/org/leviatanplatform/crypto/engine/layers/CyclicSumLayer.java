package org.leviatanplatform.crypto.engine.layers;

import org.leviatanplatform.crypto.engine.utils.ByteCyclicIterator;

public class CyclicSumLayer implements Layer {

    @Override
    public byte[] encrypt(byte[] chunk, byte[] effectiveKey) {
        return process(chunk, effectiveKey, true);
    }

    private byte[] process(byte[] chunk, byte[] effectiveKey, boolean sumOrSubtract) {

        ByteCyclicIterator iteratorKeyBytes = new ByteCyclicIterator(effectiveKey);
        byte[] chunkEncrypted = new byte[chunk.length];

        for (int i = 0; i < chunk.length; i++) {
            byte data = chunk[i];
            byte keyItem = iteratorKeyBytes.get();
            byte encrypted = sumOrSubtract ? (byte) (data + keyItem) : (byte) (data - keyItem);
            chunkEncrypted[i] = encrypted;
        }

        return chunkEncrypted;
    }

    @Override
    public byte[] decrypt(byte[] chunk, byte[] effectiveKey) {
        return process(chunk, effectiveKey, false);
    }
}
