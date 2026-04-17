package org.leviatanplatform.crypto.engine.layers;

import org.junit.jupiter.api.Test;
import java.io.IOException;

class RevolutionLayerTest {

    @Test
    void encryptAndDecrypt() throws IOException {
        encryptAndDecrypt("Text to encrypt", "qwtrhdshhsjhshfwrgwefwrgwgw");
        encryptAndDecrypt("Another important message", "9805743985723964768457457457");
        encryptAndDecrypt("File content of high relevance", "4kith4ihrt42o2h74g764745g74g47g4");
    }


    private void encryptAndDecrypt(String data, String key) throws IOException {

        RevolutionLayer layer = new RevolutionLayer();
        TestLayerUtils.encryptAndDecrypt(layer, data, key);
    }
}