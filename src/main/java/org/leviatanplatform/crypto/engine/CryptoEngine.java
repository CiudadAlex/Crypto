package org.leviatanplatform.crypto.engine;

import org.leviatanplatform.crypto.engine.config.Parameters;
import org.leviatanplatform.crypto.engine.files.FileContentIterator;
import org.leviatanplatform.crypto.engine.files.FileContentWriter;
import org.leviatanplatform.crypto.engine.key.EffectiveKeyGenerator;
import org.leviatanplatform.crypto.engine.layers.ByteMaskLayer;
import org.leviatanplatform.crypto.engine.layers.Layer;
import org.leviatanplatform.crypto.engine.layers.RevolutionLayer;

import java.io.IOException;
import java.util.List;

public class CryptoEngine {

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, String key) throws IOException {
        encryptFile(pathFilePlain, pathFileEncrypted, key.getBytes());
    }

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, byte[] key) throws IOException {

        int lengthBlockBytes = Parameters.getInstance().getLengthBlockBytes();
        FileContentIterator fileContentIterator = new FileContentIterator(pathFilePlain);
        FileContentWriter fileContentWriter = new FileContentWriter(pathFileEncrypted);

        byte[] chunk = fileContentIterator.getChunk(lengthBlockBytes);
        int chunkIndex = 0;

        while (chunk != null) {

            List<Layer> listOfLayers = getListOfLayers();
            byte[] effectiveKey = EffectiveKeyGenerator.generateEffectiveKey(key, chunkIndex);
            byte[] encryptedChunk = chunk;

            for (Layer layer : listOfLayers) {
                encryptedChunk = layer.encrypt(encryptedChunk, effectiveKey);
            }

            fileContentWriter.writeChunk(encryptedChunk);

            chunk = fileContentIterator.getChunk(lengthBlockBytes);
            chunkIndex++;
        }

        // FIXME consider last non complete chunk

        fileContentIterator.close();
        fileContentWriter.close();
    }

    private List<Layer> getListOfLayers() {
        // FIXME add more layers
        return List.of(new ByteMaskLayer(), new RevolutionLayer());
    }
}
