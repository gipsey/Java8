package org.davidd.methodReferencesAndLambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by David on 10/14/2016.
 */
public class MethodReferences {

    public MethodReferences() {
        System.out.println(getClass().getName() + "\n");

        Predicate<Apple> p = Apple::isGreen;
        p = p.or(Apple::isRed);
        Stream<Apple> greenOnes = appleList().stream().filter(p);
        greenOnes.collect(Collectors.toList()).forEach(System.out::println);


        Function<String, String> f = String::toUpperCase;
        System.out.println(f.apply("asd"));


        // CONSTRUCTOR METHOD REFERENCES
        Supplier<Coffee> coffeeSuuplier = Coffee::new;
        Coffee c1 = coffeeSuuplier.get();

        Function<Integer, Coffee> coffeeMaker = Coffee::new;
        Coffee c2 = coffeeMaker.apply(5);

        Map<String, Function<Integer, Coffee>> barista = new HashMap<>();
        barista.put("barista1", Coffee::new);
        barista.put("barista2", Coffee::new);

        Coffee c3 = barista.get("barista2").apply(3);
    }

    public static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }

        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static List findPrimeNumbers(List list, Predicate predicate) {
        List sortedNumbers = new ArrayList();

        list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
            sortedNumbers.add(i);
        });

        return sortedNumbers;
    }

    public static List<Apple> appleList() {
        List<Apple> result = new ArrayList<>();

        result.add(new Apple("blue", 2));
        result.add(new Apple("red", 5));
        result.add(new Apple("green", 10));
        result.add(new Apple("yellow", 5));
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
