package org.leviatanplatform.crypto.engine.key;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringKeyManagerTest {

    @Test
    void generateKey() {
        StringKeyManager.generateKey("string-key");
    }
}