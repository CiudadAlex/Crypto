package org.leviatanplatform.crypto.engine.layers;

import org.leviatanplatform.crypto.engine.utils.ByteCyclicIterator;

public class CyclicSumLayer implements Layer {

    @Override
    public byte[] encrypt(byte[] chunk, byte[] effectiveKey) {

        // FIXME sumar ciclico

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

        // FIXME sumar ciclico
        return null;
    }
}
