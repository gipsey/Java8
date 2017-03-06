package org.davidd.presentation;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class AppleRepo {

    List<Apple> apples;

    @Before
    public void setUp() {
        apples = new ArrayList<>();
        apples.add(new Apple("q", "green", 1, 100));
        apples.add(new Apple("a", "green", 2, 110));
        apples.add(new Apple("z", "red", 1, 90));
        apples.add(new Apple("w", "red", 4, 120));
        apples.add(new Apple("s", "yellow", 5, 200));
        apples.add(new Apple("x", "yellow", 5, 200));
        apples.add(new Apple("e", "red", 10, 130));
        apples.add(new Apple("d", "red", 5, 140));
    }

    @Test
    public void a_listAll() {
        Printer printer = System.out::println;

        for (Apple a : apples) {
            printer.print(a);
        }
    }

    @Test
    public void b_listAllGreen() {
        Printer printer = System.out::println;
        AppleFilter onlyGreenFilter = Apple::isGreen;

        for (Apple a : apples) {
            if (onlyGreenFilter.filter(a)) {
                printer.print(a);
            }
        }
    }

    @Test
    public void c_listWithCondition() {
        System.out.println("\nWeight above 4 ->");
        for (Apple a : apples) {
            if (a.isWeightAboveThen4()) {
                System.out.println(a);
            }
        }

        System.out.println("\nColor is yellow ->");
        for (Apple a : apples) {
            if (a.isYellow()) {
                System.out.println(a);
            }
        }

        System.out.println("\nColor is yellow again ->");
        for (Apple a : apples) {
            if (a.filter("yellow")) {
                System.out.println(a);
            }
        }

        System.out.println("\nColor is red and price is above 120 ->");
        for (Apple a : apples) {
            if (a.filter("red", 120)) {
                System.out.println(a);
            }
        }
    }

    @Test
    public void d_listWithCondition() {
        System.out.println("\nWeight above 4 ->");
        printWithCondition(Apple::isWeightAboveThen4);

        System.out.println("\nColor is yellow ->");
        printWithCondition(Apple::isYellow);

        System.out.println("\nColor is yellow again ->");
        printWithCondition(apple -> apple.filter("yellow"));

        System.out.println("\nColor is red and price is above 120 ->");
        printWithCondition(a -> a.filter("red", 120));
    }

    void printWithCondition(AppleFilter predicate) {
        for (Apple apple : apples) {
            if (predicate.filter(apple)) {
                System.out.println(apple);
            }
        }
    }

    @Test
    public void e_consumer() {
        Consumer<Apple> consumer = System.out::println;

        for (Apple apple : apples) {
            consumer.accept(apple);
        }
    }

    @Test
    public void f_supplier() {
        Supplier<Apple> supplier = this::createApple;

        System.out.println(supplier.get());
    }

    Apple createApple() {
        return new Apple("code", "black", 1, 2);
    }

    @Test
    public void g_predicate() {
        Predicate<Apple> predicate = Apple::isGreen;

        for (Apple apple : apples) {
            if (predicate.test(apple)) {
                System.out.println(apple);
            }
        }
    }

    @Test
    public void h_function() {
        Function<Apple, String> function = Apple::getCode;

        for (Apple apple : apples) {
            System.out.println(function.apply(apple));
        }
    }

    @FunctionalInterface
    interface Printer {
        void print(Apple a);
    }

    @FunctionalInterface
    interface AppleFilter {
        boolean filter(Apple a);
    }
}
