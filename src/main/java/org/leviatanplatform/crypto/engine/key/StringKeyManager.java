package org.leviatanplatform.crypto.engine.key;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StringKeyManager {

    private static final Map<Character, Byte> MAP_CHARACTER_BYTE = buildCharacterMap();

    public static byte[] generateKey(String stringKey) {

        byte[] key = new byte[stringKey.length()];

        for (int i = 0; i < stringKey.length(); i++) {

            char ch = stringKey.charAt(i);
            Byte b = MAP_CHARACTER_BYTE.get(ch);
            b = b != null ? b : transformToChar(ch);
            key[i] = b;
        }

        return key;
    }

    private static byte transformToChar(char ch) {
        String oneCharString = "" + ch;
        return oneCharString.getBytes()[0];
    }

    private static Map<Character, Byte> buildCharacterMap() {

        List<Character> listNormalCharacters = getListNormalCharacters();

        Map<Character, Byte> map = new HashMap<>();
        int jump = 255 / listNormalCharacters.size();

        for (int i = 0; i < listNormalCharacters.size(); i++) {
            char ch = listNormalCharacters.get(i);
            int byteValue = i * jump - 127;
            map.put(ch, (byte) byteValue);
        }

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
