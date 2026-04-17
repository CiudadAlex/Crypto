package org.leviatanplatform.crypto.engine.layers;

import java.io.IOException;

public class TestLayerUtils {

    public static void encryptAndDecrypt(Layer layer, String data, String key) throws IOException {

        byte[] encrypted = layer.encrypt(data.getBytes(), key.getBytes());
        byte[] decrypted = layer.decrypt(encrypted, key.getBytes());
        String dataRecovered = new String(decrypted);
        assert data.equals(dataRecovered);
    }
}
