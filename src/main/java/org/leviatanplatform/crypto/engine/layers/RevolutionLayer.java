package org.leviatanplatform.crypto.engine.layers;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RevolutionLayer implements Layer {

    @Override
    public byte[] encrypt(byte[] chunk, byte[] effectiveKey) throws IOException {
        return shuffle(chunk,  effectiveKey, true);
    }

    private byte[] shuffle(byte[] chunk, byte[] effectiveKey, boolean encrypt) throws IOException {

        List<Long> listSeeds = getSeeds(effectiveKey, encrypt);
        byte[] shuffledChunk = chunk;

        for (long seed : listSeeds) {
            List<Integer> listShuffledIndices = getShuffledIndices(seed, chunk.length);
            shuffledChunk = buildShuffledChunk(shuffledChunk, listShuffledIndices, encrypt);
        }

        return shuffledChunk;
    }

    private byte[] buildShuffledChunk(byte[] chunk, List<Integer> listShuffledIndices, boolean encrypt) {

        byte[] shuffledChunk = new byte[chunk.length];

        for (int i = 0; i < listShuffledIndices.size(); i++) {
            int index = listShuffledIndices.get(i);

            if (encrypt) {
                shuffledChunk[i] = chunk[index];
            } else {
                shuffledChunk[index] = chunk[i];
            }
        }

        return shuffledChunk;
    }

    private List<Long> getSeeds(byte[] effectiveKey, boolean encrypt) throws IOException {

        List<Long> listSeeds = new ArrayList<>();

        ByteArrayInputStream baisEffectiveKey = new ByteArrayInputStream(effectiveKey);
        DataInputStream disEffectiveKey = new DataInputStream(baisEffectiveKey);

        while (disEffectiveKey.available() >= 8) {
            long seed = disEffectiveKey.readLong();
            listSeeds.add(seed);
        }

        if (!encrypt) {
            Collections.reverse(listSeeds);
        }

        return listSeeds;
    }

    private List<Integer> getShuffledIndices(long seed, int listSize) {

        Random random = new Random(seed);

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            indices.add(i);
        }

        Collections.shuffle(indices, random);

        return indices;
    }

    @Override
    public byte[] decrypt(byte[] chunk, byte[] effectiveKey)  throws IOException {
        return shuffle(chunk,  effectiveKey, false);
    }
}
