package main.Service;

import main.Dao.CarRepository;
import main.Entity.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepo;

    public Collection<Car> getAllCars() {
        return this.carRepo.findAll();
    }

    public Optional<Car> getCarById(String id) {
        return this.carRepo.findById(id);
    }

    public Collection<Car> getCarByMake(String make) {
        return this.carRepo.findByMake(make);
    }

    public void saveCar(Car car) {
        this.carRepo.save(car);
    }

    public void updateCar(Car car) {
        this.carRepo.save(car);
    }

    public void deleteCar(Car car) {
        this.carRepo.delete(car);
    }
}
