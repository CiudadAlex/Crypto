package org.leviatanplatform.crypto.engine.layers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.List;

public class RevolutionLayer implements Layer {

    @Override
    public byte[] encrypt(byte[] chunk, byte[] effectiveKey) {

        ByteArrayInputStream baisEffectiveKey = new ByteArrayInputStream(effectiveKey);
        DataInputStream disEffectiveKey = new DataInputStream(baisEffectiveKey);
        long value = disEffectiveKey.readLong();


        // FIXME implement
        return new byte[0];
    }

    private List<Integer> getShuffledIndices() {

    }

    @Override
    public byte[] decrypt(byte[] chunk, byte[] effectiveKey) {
        // FIXME implement
        return new byte[0];
    }
}
