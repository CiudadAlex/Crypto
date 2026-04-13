package org.leviatanplatform.crypto.engine.layers;

import java.io.IOException;

public interface Layer {

    byte[] encrypt(byte[] chunk, byte[] effectiveKey) throws IOException;

    byte[] decrypt(byte[] chunk, byte[] effectiveKey) throws IOException;
}
