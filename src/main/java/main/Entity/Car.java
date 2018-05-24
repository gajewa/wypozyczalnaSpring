package main.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cars")
public class Car {

    @Id
    public String id;

    public String make;
    public String model;
    public String body;
    public String engine;
    public int totalRentals;
    public int seats;
    public int price;
    public double totalIncome;
    public Date updated_date;

    public Car(String id, String make, String model, String body, String engine, int totalRentals, int seats, int price, double totalIncome, Date updated_date) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.body = body;
        this.engine = engine;
        this.totalRentals = totalRentals;
        this.seats = seats;
        this.price = price;
        this.totalIncome = totalIncome;
        this.updated_date = updated_date;
    }

    @Override
    public String toString() {
        return String.format(
                "Car[id=%s, make='%s', model='%s', body='%s', engine='%s', totalRentals='%s', seats='%s', price='%s', totalIncome='%s', updated_date='%s']",
                id, make, model, body, engine, totalRentals, seats, price, totalIncome, updated_date);
    }

    

}
