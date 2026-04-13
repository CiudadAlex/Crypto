package org.leviatanplatform.crypto.engine.key;

public class EffectiveKeyGenerator {

    public static byte[] generateEffectiveKey(byte[] key, int chunkIndex) {

        // FIXME apply algorithmKey
        // FIXME hash to randomize the bits (distribuidos equitativamente)
        // byte[] digest = Digestor.digest(key);

        return key;
    }


}
