package org.leviatanplatform.crypto.engine.key;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringKeyManager {

    private static final Map<Character, Byte> MAP_CHARACTER_BYTE = buildCharacterMap();

    public static byte[] generateKey(String stringKey) {

        // FIXME hash to randomize the bits (distribuidos equitativamente)
        // byte[] digest = Digestor.digest(key);

        return stringKey.getBytes();
    }

    private static Map<Character, Byte> buildCharacterMap() {

        List<Character> listNormalCharacters = getListNormalCharacters();

        Map<Character, Byte> map = new HashMap<>();
        map.put('A', (byte) 0);


        // FIXME complete
        return map;
    }

    private static List<Character> getListNormalCharacters() {

        List<Character> listNormalCharacters = new ArrayList<>();

        for (char c = 'a'; c <= 'z'; c++) {
            listNormalCharacters.add(c);
        }

        for (char c = 'A'; c <= 'Z'; c++) {
            listNormalCharacters.add(c);
        }

        for (char c = '0'; c <= '9'; c++) {
            listNormalCharacters.add(c);
        }

        listNormalCharacters.addAll(List.of('á', 'é', 'í', 'ó', 'ú'));
        listNormalCharacters.addAll(List.of('Á', 'É', 'Í', 'Ó', 'Ú'));
        listNormalCharacters.addAll(List.of('@', '#', '$', '%', '!', '(', ')'));

        return listNormalCharacters;
    }


}
