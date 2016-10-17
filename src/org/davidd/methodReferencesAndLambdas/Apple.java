package org.davidd.methodReferencesAndLambdas;

/**
 * Created by David on 10/14/2016.
 */
public class Apple {

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


    public String getColor() {
        return color;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isGreen() {
        return "green".equals(color);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
