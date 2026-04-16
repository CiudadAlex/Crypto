package org.leviatanplatform.crypto.engine.poc;

public class PocByte {

    public static void main(String[] args) {

        byte b = (byte) 120;

        for (int i = 0; i < 30; i++) {
            b++;
            System.out.println("b = " + b);
        }
    }
}
