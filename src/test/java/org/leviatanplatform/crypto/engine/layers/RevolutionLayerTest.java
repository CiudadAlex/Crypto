package org.leviatanplatform.crypto.engine.layers;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class RevolutionLayerTest {

    @Test
    void encryptAndDecrypt() throws IOException {
        encryptAndDecrypt("Text to encrypt", "qwtrhdshhsjhsh");
        encryptAndDecrypt("Another important message", "98057439857239");
        encryptAndDecrypt("File content of high relevance", "4kith4ihrt42o2");
    }


    private void encryptAndDecrypt(String data, String key) throws IOException {

        RevolutionLayer layer = new RevolutionLayer();
        byte[] encrypted = layer.encrypt(data.getBytes(), key.getBytes());
        byte[] decrypted = layer.encrypt(encrypted, key.getBytes());
        String dataRecovered = new String(decrypted);
        assert data.equals(dataRecovered);
    }
}