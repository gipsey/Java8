package org.davidd.streams;

import org.davidd.Coffee;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * Created by David on 11/7/2016.
 */
public class Stream1Test {

    @BeforeClass
    public static void b() {

    }

    @Test
    public void stream_concatenation() {
        Stream<Long> s = Stream.of(2L, 5L, 6L, 123L, 2545L, 23L);
        s = s.filter(l -> l % 2 == 0);
//        s = StreamApi.concat(s, StreamApi.of(1L, 1234L, 21346L, 12349L));
        s = s.flatMap(l -> Stream.of(l, 1L, 1234L, 21346L, 12349L));
        s.forEach(l -> System.out.print(l + " "));
    }

    @Test
    public void sorted() {
        Stream.of(2L, 5L, 6L, 123L, 2545L, 23L)
                .sorted()
                .forEach(l -> System.out.print(l + " "));
    }

    @Test
    public void coffeeSorted() {
        Stream.of(new Coffee(12312), new Coffee(1), new Coffee("malac"), new Coffee("jancsi"), new Coffee(213))
                .sorted()
                .forEach(System.out::println);
    }
}