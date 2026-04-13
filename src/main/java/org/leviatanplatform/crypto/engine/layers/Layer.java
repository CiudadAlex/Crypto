package org.leviatanplatform.crypto.engine.layers;

public interface Layer {

    byte[] encrypt(byte[] chunk, byte[] effectiveKey);

    byte[] decrypt(byte[] chunk, byte[] effectiveKey);
}
