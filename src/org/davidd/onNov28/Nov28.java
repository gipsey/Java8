package org.davidd.onNov28;

import org.davidd.Coffee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Nov28 {

    @Test
    public void test_count() {
        long count = Coffee.coffeeList()
                .stream()
                .count();

        System.out.println(count);
    }

    @Test
    public void test_totalValue() {
        long totalValue = Coffee.coffeeList()
                .stream()
                .collect(Collectors.summingInt(Coffee::getPrice));

        System.out.println(totalValue);
    }

    @Test
    public void test_summaryStatistics() {
        IntSummaryStatistics summaryStatistics = Coffee.coffeeList()
                .stream()
                .collect(Collectors.summarizingInt(Coffee::getPrice));

        System.out.println(summaryStatistics);
    }

    @Test
    public void test_reduce() {
//        int i = Coffee.coffeeList()
//                .stream()
//                .reduce(0, (Coffee c) -> 1, Integer::sum);
//
//        System.out.println(i);
    }

    @Test
    public void minSize() {
        Optional<Coffee> o = Coffee.coffeeList()
                .stream()
                .collect(
                        Collectors.minBy(
                                Comparator.comparing(Coffee::getSize)));

        System.out.println(o.orElse(new Coffee()));
    }

    @Test
    public void combine() {
        List<Coffee> identity = new ArrayList<>();

        List<Coffee> list = Coffee.coffeeList()
                .stream()
                .collect(
                        Collectors.reducing(
                                identity,
                                (Coffee c) -> {
                                    identity.add(c);
                                    return identity;
                                },
                                (l1, l2) -> {
                                    l1.addAll(l2);
                                    return l1;
                                }
                        ));

        list.stream()
                .forEach(System.out::println);
    }
}
