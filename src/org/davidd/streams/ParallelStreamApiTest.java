package org.davidd.streams;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by David on 11/7/2016.
 */
public class ParallelStreamApiTest {

    static List<Long> longs;

    @BeforeClass
    public static void b() {
        Random r = new Random();
        longs = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            longs.add(r.nextLong());
        }
    }

    @Test
    public void q() {
        long now = System.currentTimeMillis();

        List<Long> result = longs.stream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());

        System.out.println((System.currentTimeMillis() - now));
    }

    @Test
    public void w() {
        long now = System.currentTimeMillis();

        List<Long> result = longs.parallelStream().filter(i -> i % 2 == 0).sorted().collect(Collectors.toList());

        System.out.println((System.currentTimeMillis() - now));
    }
}