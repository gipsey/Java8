package org.davidd.methodReferencesAndLambdas;

/**
 * Created by David on 10/31/2016.
 */
public class Coffee implements Comparable<Coffee> {

    int price;
    String name;

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

    @Override
    public String toString() {
        return "Coffee{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Coffee o) {
        return this.price - o.price;
    }
}
