package org.davidd.methodReferencesAndLambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by David on 10/14/2016.
 */
public class MethodReferences {

    public MethodReferences() {
        Stream<Apple> greenOnes = appleList().stream().filter(Apple::isGreen);

        greenOnes.collect(Collectors.toList()).forEach(System.out::println);
    }

    public static List<Apple> appleList() {
        List<Apple> result = new ArrayList<>();

        result.add(new Apple("blue", 2));
        result.add(new Apple("red", 5));
        result.add(new Apple("green", 10));
        result.add(new Apple("green", 20));

        return result;
    }

    public static List<Apple> filterGreenApples(List<Apple> inv, int weight) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inv) {
            if (apple.getWeight() >= weight) {
                result.add(apple);
            }
        }

        return result;
    }
}
