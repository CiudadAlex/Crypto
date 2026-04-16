package org.leviatanplatform.crypto.engine.key;

import org.leviatanplatform.crypto.engine.config.Parameters;

public class EffectiveKeyGenerator {

    public static byte[] generateEffectiveKey(byte[] key, int chunkIndex) {

        byte[] algorithmKey = getAlgorithmKey();

        byte[] effectiveKey = new byte[key.length + algorithmKey.length];


        // FIXME Entrelazar algorithmKey con key
        // FIXME consider chunkIndex

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
