package org.leviatanplatform.crypto.engine.key;

import org.leviatanplatform.crypto.engine.config.Parameters;

import java.io.ByteArrayInputStream;

public class EffectiveKeyGenerator {

    public static byte[] generateEffectiveKey(byte[] key, int chunkIndex) {

        byte[] algorithmKey = getAlgorithmKey();

        byte[] effectiveKey = new byte[key.length + algorithmKey.length];

        ByteArrayInputStream baisKey = new ByteArrayInputStream(key);
        ByteArrayInputStream baisAlgorithmKey = new ByteArrayInputStream(algorithmKey);

        int i = 0;

        while (baisKey.available() > 0 || baisAlgorithmKey.available() > 0) {

            if (baisAlgorithmKey.available() > 0) {
                effectiveKey[i] = (byte) baisAlgorithmKey.read();
                i++;
            }

        }

        for (int k = 0; k < effectiveKey.length; k++) {
            effectiveKey[k] = (byte) (effectiveKey[k] + chunkIndex);
        }

        // FIXME Entrelazar algorithmKey con key

        return effectiveKey;
    }

    private static byte[] getAlgorithmKey() {

        Parameters parameters = Parameters.getInstance();

        String name = parameters.getName();
        String surname = parameters.getSurname();
        String birthdate = parameters.getBirthdate();

        StringBuilder sb = new StringBuilder();
        sb.append(surname);
        sb.append(birthdate);
        sb.append(name);

        return sb.toString().getBytes();
    }


}
