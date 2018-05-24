package main.Controller;

import main.Entity.Car;
import main.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/cars")

public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Car> getAllCars(){
        return this.carService.getAllCars();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Optional<Car> getCarByID(@PathVariable("id") String id){
        return this.carService.getCarById(id);
    }

    @RequestMapping(value = "/name/{make}", method = RequestMethod.GET)
    public Collection<Car> getCarByMake(@PathVariable("make") String make){
        return this.carService.getCarByMake(make);
    }

}
