package org.davidd.onDec19;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Spliterator;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Dec19 {

    @Before
    public void b() {
    }

    @Test
    public void a() {
        List<Dealer> dealers = new ArrayList<Dealer>() {{
            add(new Dealer());
            add(new Dealer());
            add(new Dealer());
            add(new Dealer());
            add(new Dealer());
            add(new Dealer());
        }};

        List<Dealer> ds = dealers.parallelStream()
                .collect(Collectors.toList());

        List<CompletableFuture<List<Car>>> completableFutures = dealers.stream()
                .map(d -> CompletableFuture.supplyAsync(d::getCars))
                .collect(Collectors.toList());
    }

    static class Dealer {

        private List<Car> cars = new ArrayList<Car>() {{
            add(new Car("audi"));
            add(new Car("vw"));
            add(new Car("bmw"));
        }};

        List<Car> getCars() {
            try {
                Thread.currentThread().sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return cars;
        }

        @Override
        public String toString() {
            return "Dealer{" +
                    "cars=" + cars +
                    '}';
        }
    }

    static class Car {

        private String name;

        public Car(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Car{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
