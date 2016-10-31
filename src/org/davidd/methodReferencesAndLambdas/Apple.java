package org.davidd.methodReferencesAndLambdas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/14/2016.
 */
public class Apple implements Comparable<Apple> {

    private String color;
    private int weight;

    public Apple() {
        this.color = "green";
        this.weight = 2;
    }

    public Apple(String color, int weight) {
        this.color = color;
        this.weight = weight;
    }

    public static List<Apple> appleList() {
        List<Apple> result = new ArrayList<>();

        result.add(new Apple("blue", 2));
        result.add(new Apple("red1", 5));
        result.add(new Apple("red2", 1));
        result.add(new Apple("green1", 3));
        result.add(new Apple("green2", 100));
        result.add(new Apple("green", 20));

        return result;
    }

    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isGreen() {
        return "green".equals(color);
    }

    public boolean isRed() {
        return "red".equals(color);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Apple o) {
        return this.getWeight() - o.getWeight();
    }

    public static int compare(Apple a1, Apple a2) {
        return a1.getWeight() - a2.getWeight();
    }
}
