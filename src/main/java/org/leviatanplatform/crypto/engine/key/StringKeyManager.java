package org.leviatanplatform.crypto.engine.key;

import java.util.Map;

public class StringKeyManager {

    private static final Map<Character, Byte> MAP_CHARACTER_BYTE = buildCharacterMap();

    private static Map<Character, Byte> buildCharacterMap() {
        // FIXME complete
        return Map.of();
    }

    public static byte[] generateKey(String stringKey) {

        // FIXME hash to randomize the bits (distribuidos equitativamente)
        // byte[] digest = Digestor.digest(key);

        return stringKey.getBytes();
    }
}
