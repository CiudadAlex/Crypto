package org.leviatanplatform.crypto.engine;

import org.leviatanplatform.crypto.engine.config.Parameters;
import org.leviatanplatform.crypto.engine.files.FileContentIterator;
import org.leviatanplatform.crypto.engine.files.FileContentWriter;
import org.leviatanplatform.crypto.engine.key.EffectiveKeyGenerator;
import org.leviatanplatform.crypto.engine.key.StringKeyManager;
import org.leviatanplatform.crypto.engine.layers.ByteMaskLayer;
import org.leviatanplatform.crypto.engine.layers.CyclicSumLayer;
import org.leviatanplatform.crypto.engine.layers.Layer;
import org.leviatanplatform.crypto.engine.layers.RevolutionLayer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CryptoEngine {

    public static void encryptFile(String pathFilePlain, String pathFileEncrypted, String key) throws IOException {
        encryptFile(pathFilePlain, pathFileEncrypted, StringKeyManager.generateKey(key));
    }

    public static void encryptFile(String pathFilePlain, String pathFileEncrypted, byte[] key) throws IOException {
        processFile(pathFilePlain, pathFileEncrypted, key, true);
    }

    public static void decryptFile(String pathFilePlain, String pathFileEncrypted, String key) throws IOException {
        decryptFile(pathFilePlain, pathFileEncrypted, StringKeyManager.generateKey(key));
    }

    public static void decryptFile(String pathFilePlain, String pathFileEncrypted, byte[] key) throws IOException {
        processFile(pathFilePlain, pathFileEncrypted, key, false);
    }

    private static void processFile(String pathFilePlain, String pathFileEncrypted, byte[] key, boolean encryptOrDecrypt) throws IOException {

        int lengthBlockBytes = Parameters.getInstance().getLengthBlockBytes();
        FileContentIterator fileContentIterator = new FileContentIterator(pathFilePlain);
        FileContentWriter fileContentWriter = new FileContentWriter(pathFileEncrypted);

        byte[] chunk = fileContentIterator.getChunk(lengthBlockBytes);
        int chunkIndex = 0;

        while (chunk != null) {

            processChunk(chunk, chunkIndex, key, fileContentWriter, encryptOrDecrypt);

            chunk = fileContentIterator.getChunk(lengthBlockBytes);
            chunkIndex++;

            System.out.println("Chunk done: " + chunkIndex);
        }

        fileContentIterator.close();
        fileContentWriter.close();
    }

    private static void processChunk(byte[] chunk, int chunkIndex, byte[] key, FileContentWriter fileContentWriter, boolean encryptOrDecrypt) throws IOException {

        List<Layer> listOfLayers = getListOfLayers(encryptOrDecrypt);
        byte[] effectiveKey = EffectiveKeyGenerator.generateEffectiveKey(key, chunkIndex);
        byte[] processedChunk = chunk;

        for (Layer layer : listOfLayers) {

            if (encryptOrDecrypt) {
                processedChunk = layer.encrypt(processedChunk, effectiveKey);
            } else {
                processedChunk = layer.decrypt(processedChunk, effectiveKey);
            }
        }

        fileContentWriter.writeChunk(processedChunk);
    }

    private static List<Layer> getListOfLayers(boolean encryptOrDecrypt) {

        List<Layer> listLayersFixed = List.of(new ByteMaskLayer(), new RevolutionLayer(), new CyclicSumLayer());

        List<Layer> listLayers = new ArrayList<>(listLayersFixed);

        if (!encryptOrDecrypt) {
            Collections.reverse(listLayers);
        }

        return listLayers;
    }
}
