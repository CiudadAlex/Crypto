package org.leviatanplatform.crypto.engine.layers;

import org.junit.jupiter.api.Test;
import java.io.IOException;

class CyclicSumLayerTest {

    @Test
    void encryptAndDecrypt() throws IOException {
        encryptAndDecrypt("Text to encrypt", "qwtrhdshhsjhsh");
        encryptAndDecrypt("Another important message", "98057439857239");
        encryptAndDecrypt("File content of high relevance", "4kith4ihrt42o2");
    }


    private void encryptAndDecrypt(String data, String key) throws IOException {

        CyclicSumLayer layer = new CyclicSumLayer();
        TestLayerUtils.encryptAndDecrypt(layer, data, key);
    }

}