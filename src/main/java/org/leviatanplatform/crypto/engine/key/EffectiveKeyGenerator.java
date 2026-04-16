package org.leviatanplatform.crypto.engine.key;

import org.leviatanplatform.crypto.engine.config.Parameters;

public class EffectiveKeyGenerator {

    public static byte[] generateEffectiveKey(byte[] key, int chunkIndex) {

        Parameters parameters = Parameters.getInstance();


        // FIXME apply algorithmKey (load Parameters) Entrelazar con key
        // FIXME consider chunkIndex

        return key;
    }


}
