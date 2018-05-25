package main.Service;

import main.Dao.CarRepository;
import main.Dao.RentalRepository;
import main.Dao.UserRepository;
import main.Entity.Car;
import main.Entity.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepository;

    @Autowired
    private CarRepository carRepository;
    
    @Autowired
    private UserRepository userRepository;

    public Collection<Rental> getAllRentals(){
        return this.rentalRepository.findAll();
    }

    public Collection<Rental> getPopulatedRentals(){
        List<Rental> unpopulated = this.rentalRepository.findAll();

        for(Rental element : unpopulated) {
           element.setCar(carRepository.findById(element.getCarId()));
           element.setUser(userRepository.findById(element.getUserId()));
        }

        return unpopulated;
    }

    public Collection<Rental> getActiveRentals(){
        List<Rental> unpopulated = this.rentalRepository.findAll().stream()
                .filter( rent -> rent.getStatus().equals("Aktywne")).collect(Collectors.toList());

        for(Rental element : unpopulated) {
            element.setCar(carRepository.findById(element.getCarId()));
            element.setUser(userRepository.findById(element.getUserId()));
        }

        return unpopulated;
    }

}
