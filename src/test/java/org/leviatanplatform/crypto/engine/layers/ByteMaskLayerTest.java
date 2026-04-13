package org.leviatanplatform.crypto.engine.layers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ByteMaskLayerTest {

    @Test
    void encryptAndDecrypt() {
        encryptAndDecrypt("Text to encrypt", "qwtrhdshhsjhsh");
        encryptAndDecrypt("Another important message", "98057439857239");
        encryptAndDecrypt("File content of high relevance", "4kith4ihrt42o2");
    }


    private void encryptAndDecrypt(String data, String key) {

        ByteMaskLayer layer = new ByteMaskLayer();
        byte[] encrypted = layer.encrypt(data.getBytes(), key.getBytes());
        byte[] decrypted = layer.encrypt(encrypted, key.getBytes());
        String dataRecovered = new String(decrypted);
        assert data.equals(dataRecovered);
    }

}