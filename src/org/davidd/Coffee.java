package org.davidd;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 10/31/2016.
 */
public class Coffee implements Comparable<Coffee> {

    int price;
    int size;
    String name;
    boolean strong;

    public static List<Coffee> coffeeList() {
        List<Coffee> c = new ArrayList<>();

        c.add(new Coffee(20, 12, "Americana", false));
        c.add(new Coffee(40, 22, "Latte", false));
        c.add(new Coffee(50, 32, "Machiato", false));
        c.add(new Coffee(70, 40, "GoodCoffee", true));
        c.add(new Coffee(100, 50, "Strong Americano", true));
        c.add(new Coffee(110, 60, "Strong cappuchino", true));
        c.add(new Coffee(120, 70, "StrongSimple", true));

        return c;
    }

    public Coffee() {
    }

    public Coffee(int price) {
        this.price = price;
    }

    public Coffee(String name) {
        this.name = name;
    }

    public Coffee(int price, String name) {
        this.price = price;
        this.name = name;
    }

    public Coffee(int price, String name, boolean strong) {
        this.price = price;
        this.name = name;
        this.strong = strong;
    }

    public Coffee(int price, int size, String name, boolean strong) {
        this.price = price;
        this.size = size;
        this.name = name;
        this.strong = strong;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStrong() {
        return strong;
    }

    public void setStrong(boolean strong) {
        this.strong = strong;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Coffee{" +
                "price=" + price +
                ", size=" + size +
                ", name='" + name + '\'' +
                ", strong=" + strong +
                '}';
    }

    @Override
    public int compareTo(Coffee o) {
        return this.price - o.price;
    }
}
