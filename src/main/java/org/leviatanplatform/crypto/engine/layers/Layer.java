package org.leviatanplatform.crypto.engine.layers;

public interface Layer {

    void encrypt(byte[] chunk, byte[] key);

    void decrypt(byte[] chunk, byte[] key);
}
