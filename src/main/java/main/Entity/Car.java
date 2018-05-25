package main.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "cars")
public class Car {


    @Id
    private String id;

    private String make;
    private String model;
    private String body;
    private String engine;

    public String getId() {
        return id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public int getTotalRentals() {
        return totalRentals;
    }

    public void setTotalRentals(int totalRentals) {
        this.totalRentals = totalRentals;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(double totalIncome) {
        this.totalIncome = totalIncome;
    }

    public Date getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Date updated_date) {
        this.updated_date = updated_date;
    }

    private int totalRentals;
    private int seats;
    private int price;
    private double totalIncome;
    private Date updated_date;


    public Car(){}

    public Car(String make, String model, String body, String engine,
               int totalRentals, int seats, int price, double totalIncome,
               Date updated_date) {
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
                "Car[id='%s', make='%s', model='%s', body='%s', engine='%s', totalRentals='%s', " +
                        "seats='%s', price='%s', totalIncome='%s', updated_date='%s']",
                id, make, model, body, engine, totalRentals, seats, price, totalIncome, updated_date);
    }

    

}
