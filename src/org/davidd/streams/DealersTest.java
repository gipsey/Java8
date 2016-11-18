package org.davidd.streams;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 11/7/2016.
 */
public class DealersTest {

    class Dealer {

        private List<Car> cars;
        private Address address;

        public Dealer(List<Car> cars, Address address) {
            this.cars = cars;
            this.address = address;
        }

        public List<Car> getCars() {
            return cars;
        }

        public Address getAddress() {
            return address;
        }

        @Override
        public String toString() {
            return "Dealer{" +
                    "cars=" + cars +
                    ", address=" + address +
                    '}';
        }
    }

    class Car {

        private int manufacturerYear;
        private int price;
        private String brand;

        public Car(int manufacturerYear, int price, String brand) {
            this.manufacturerYear = manufacturerYear;
            this.price = price;
            this.brand = brand;
        }

        public int getManufacturerYear() {
            return manufacturerYear;
        }

        public int getPrice() {
            return price;
        }

        public String getBrand() {
            return brand;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "manufacturerYear=" + manufacturerYear +
                    ", price=" + price +
                    ", brand='" + brand + '\'' +
                    '}';
        }
    }

    class Address {

        private String country;
        private String city;

        public Address(String country, String city) {
            this.country = country;
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        @Override
        public String toString() {
            return "Address{" +
                    "country='" + country + '\'' +
                    ", city='" + city + '\'' +
                    '}';
        }
    }

    private List<Dealer> dealerList;

    @Before
    public void setUp() throws Exception {

        Address a1 = new Address("RO", "Cluj");
        Address a2 = new Address("HU", "Budapest");
        Address a3 = new Address("HU", "Budapest");
        Address a4 = new Address("AU", "Viena");

        Car c1 = new Car(2009, 10000, "WV");
        Car c2 = new Car(2009, 5000, "Merci");
        Car c3 = new Car(2001, 5000, "Merci");
        Car c4 = new Car(2005, 1000, "WV");
        Car c5 = new Car(2006, 50000, "WV");
        Car c6 = new Car(2007, 60000, "Merci");
        Car c7 = new Car(2011, 7890, "Audi");
        Car c8 = new Car(2011, 12550, "BMW");
        Car c9 = new Car(2012, 8500, "BMW");
        Car c10 = new Car(2013, 3660, "Merci");

        dealerList = new ArrayList<>();
        dealerList.add(new Dealer(
                new ArrayList<Car>() {{
                    add(c1);
                    add(c2);
                    add(c3);
                }}, a1));
        dealerList.add(new Dealer(
                new ArrayList<Car>() {{
                    add(c4);
                    add(c5);
                    add(c6);
                }}, a2));
        dealerList.add(new Dealer(
                new ArrayList<Car>() {{
                    add(c7);
                    add(c8);
                }}, a3));
        dealerList.add(new Dealer(
                new ArrayList<Car>() {{
                    add(c9);
                    add(c10);
                }}, a4));
    }

//    a. Find all cars manufactured in 2009 and sort the by price
//    b. What are the unique brands available for sale
//    c. find all car in city London and sort them by price
//    d. Return a string of all brands sorted alphabetically
//    e. Are any cars in Vienna ?
//    f. Print all car prices from dealers in Bucharest
//    g. What is the most expensive car

    @Test
    public void carsIn2009() {
        dealerList.stream()
                .flatMap(d -> d.getCars().stream())
                .filter(c -> c.getManufacturerYear() == 2009)
                .sorted((c1, c2) -> c1.getPrice() - c2.getPrice())
                .forEach(System.out::println);
    }

    @Test
    public void b() {
        dealerList.stream()
                .flatMap(d -> d.getCars().stream())
                .map(Car::getBrand)
                .distinct()
                .forEach(System.out::println);
    }

    @Test
    public void c() {
        dealerList.stream()
                .filter(d -> d.getAddress().getCountry().equals("HU") && d.getAddress().getCity().equals("Szeged"))
                .flatMap(d -> d.getCars().stream())
                .sorted((c1, c2) -> c1.getPrice() - c2.getPrice())
                .forEach(System.out::println);
    }

    @Test
    public void d() {
        dealerList.stream()
                .flatMap(d -> d.getCars().stream())
                .map(Car::getBrand)
                .distinct()
                .sorted(String::compareTo)
                .forEach(System.out::println);
    }

    @Test
    public void e() {
        boolean any = dealerList.stream()
                .anyMatch(d -> "Viena".equals(d.getAddress().getCity()) && !d.getCars().isEmpty());
        System.out.println(any);
    }

    @Test
    public void f() {
        dealerList.stream()
                .filter(d -> "Budapest".equals(d.getAddress().getCity()))
                .flatMap(d -> d.getCars().stream())
                .map(Car::getPrice)
                .forEach(System.out::println);
    }

    @Test
    public void g() {
        dealerList.stream()
                .flatMap(d -> {
                    System.out.println(d);
                    return d.getCars().stream();
                })
                .reduce((c1, c2) -> {
                    System.out.println("c1 = " + c1 + " ||| c2 = " + c2);
                    return c1.getPrice() > c2.getPrice() ? c1 : c2;
                })
                .ifPresent(System.out::println);
    }
}
