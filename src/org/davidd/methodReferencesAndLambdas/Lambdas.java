package org.davidd.methodReferencesAndLambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;

/**
 * Created by daviddebre on 19/10/16.
 */
public class Lambdas {

    @FunctionalInterface
    interface MyFunction<T, K, R> {
        R apply(T t, K k);
    }

    public Lambdas() {
        System.out.println(getClass().getName() + "\n");

        IntPredicate p = (i) -> i > 6;
        System.out.println(p.test(7));


        IntFunction<String> toString = i -> String.valueOf(i) + "i";
        System.out.println(String.valueOf(5) + "i");

        //
        System.out.println(map(Apple.appleList(), "whatever", (a, kk) -> a.toString() + kk));

        //
        List<Apple> apples = Apple.appleList();
        System.out.println(apples);

//        apples.sort(Comparator.comparingInt(Apple::getWeight));
//        System.out.println(apples);
//
//        Collections.sort(apples, Apple::compareTo);
//        System.out.println(apples);

        Collections.sort(apples, Apple::compare);
        System.out.println(apples);

    }

    public static <R, T, K> List<R> map(List<T> list, K aString, MyFunction<T, K, R> f) {
        List<R> returned = new ArrayList<>();

        for (T t : list) {
            returned.add(f.apply(t, aString));
        }

        return returned;
    }
}
