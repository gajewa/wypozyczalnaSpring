package main.Dao;

import main.Entity.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CarRepository extends MongoRepository<Car, String> {


    public Optional<Car> findById(String id);
    public List<Car> findByMake(String make);
}
