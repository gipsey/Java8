package org.davidd.streams;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by David on 11/7/2016.
 */
public class DealersTest {

    class Dealer {
        private String city;
        private List<Car> cars;

        public Dealer(String city, List<Car> cars) {
            this.city = city;
            this.cars = cars;
        }
    }

    class Car {
        private int manufacturerYear;
        private int price;

        public Car(int manufacturerYear, int price) {
            this.manufacturerYear = manufacturerYear;
            this.price = price;
        }
    }

    private List<Dealer> dealerList;

    @Test
    public void buildDealerList() {
        dealerList = new ArrayList<>();

        List<Car> cars1 = new ArrayList<>();
        cars1.add(new Car(2009, 12));
        cars1.add(new Car(2011, 20));
        cars1.add(new Car(2016, 8));

        dealerList.add(new Dealer("London", cars1));

        List<Car> cars2 = new ArrayList<>();
        cars1.add(new Car(2009, 12));
        cars1.add(new Car(2011, 20));
        cars1.add(new Car(2016, 8));

        dealerList.add(new Dealer("Viena", cars2));
    }
}
