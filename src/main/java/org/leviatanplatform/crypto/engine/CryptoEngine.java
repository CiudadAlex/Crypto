package org.leviatanplatform.crypto.engine;

import org.leviatanplatform.crypto.engine.config.Parameters;
import org.leviatanplatform.crypto.engine.files.FileContentIterator;
import org.leviatanplatform.crypto.engine.layers.ByteMaskLayer;
import org.leviatanplatform.crypto.engine.layers.Layer;

import java.io.IOException;
import java.util.List;

public class CryptoEngine {

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, String key) throws IOException {
        encryptFile(pathFilePlain, pathFileEncrypted, key.getBytes());
    }

    public void encryptFile(String pathFilePlain, String pathFileEncrypted, byte[] key) throws IOException {

        int lengthBlockBytes = Parameters.getInstance().getLengthBlockBytes();
        FileContentIterator fileContentIterator = new FileContentIterator(pathFilePlain);

        byte[] chunk = fileContentIterator.getChunk(lengthBlockBytes);
        while (chunk != null) {

            List<Layer> listOfLayers = getListOfLayers();
            byte[] effectiveKey = null;

            for (Layer layer : listOfLayers) {
                layer.encrypt(chunk, effectiveKey);
            }

            // FIXME apply layers

            chunk = fileContentIterator.getChunk(lengthBlockBytes);
        }
    }

    private List<Layer> getListOfLayers() {
        return List.of(new ByteMaskLayer());
    }
}
