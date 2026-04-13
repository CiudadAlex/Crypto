package org.leviatanplatform.crypto.engine.layers;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RevolutionLayerTest {

    @Test
    void encryptAndDecrypt() throws IOException {
        encryptAndDecrypt("Text to encrypt", "qwtrhdshhsjhshfwrgwefwrgwgw");
        encryptAndDecrypt("Another important message", "9805743985723964768457457457");
        encryptAndDecrypt("File content of high relevance", "4kith4ihrt42o2h74g764745g74g47g4");
    }


    private void encryptAndDecrypt(String data, String key) throws IOException {

        RevolutionLayer layer = new RevolutionLayer();
        byte[] encrypted = layer.encrypt(data.getBytes(), key.getBytes());
        byte[] decrypted = layer.decrypt(encrypted, key.getBytes());
        String dataRecovered = new String(decrypted);
        assert data.equals(dataRecovered);
    }
}