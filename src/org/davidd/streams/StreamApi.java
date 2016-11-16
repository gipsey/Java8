package org.davidd.streams;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

/**
 * Created by David on 11/12/2016.
 */
public class StreamApi {

    public StreamApi() {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        Stream<String> s = in.lines().limit(3);
        s.forEach(str -> System.out.println("XXX-" + str));
        System.out.print(s.count());
    }
}
