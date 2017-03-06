package org.davidd.presentation;

/**
 * Created by David on 3/6/2017.
 */
public class Apple {

    private String code;
    private String color;
    private int weight;
    private int price;

    public Apple(String code, String color, int weight, int price) {
        this.code = code;
        this.color = color;
        this.weight = weight;
        this.price = price;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isGreen() {
        return "green".equalsIgnoreCase(getColor());
    }


    public boolean isYellow() {
        return "yellow".equalsIgnoreCase(getColor());
    }

    public boolean isWeightAboveThen4() {
        return getWeight() > 4;
    }

    public boolean filter(String color) {
        return color.equalsIgnoreCase(getColor());
    }

    public boolean filter(String color, int priceisAboveThen) {
        return color.equalsIgnoreCase(getColor()) && getPrice() > priceisAboveThen;
    }

    @Override
    public String toString() {
        return "{" +
                "code='" + code + '\'' +
                ", color='" + color + '\'' +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
