package org.leviatanplatform.crypto.engine.poc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PocShuffle {

    public static void main(String[] args) {

        long seed = 122222L;
        Random random = new Random(seed);

        int n = 20;
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i);
        }

        System.out.println(indices);

        Collections.shuffle(indices, random);

        System.out.println(indices);
    }
}
