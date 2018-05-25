package main.Service;

import main.Dao.CarRepository;
import main.Dao.RentalRepository;
import main.Dao.UserRepository;
import main.Entity.Car;
import main.Entity.Rental;
import main.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
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

    public Collection<Rental> getCanceledRentals(){
        List<Rental> unpopulated = this.rentalRepository.findAll().stream()
                .filter( rent -> rent.getStatus().equals("Anulowano") ).collect(Collectors.toList());

        for(Rental element : unpopulated) {
            element.setCar(carRepository.findById(element.getCarId()));
            element.setUser(userRepository.findById(element.getUserId()));
        }

        return unpopulated;
    }

    public void addNewRental(Rental rental){
        Optional<Car> car = carRepository.findById(rental.getCarId());
        Optional<User> user = userRepository.findById(rental.getUserId());

        Date date1 = rental.getStartDate();
        Date date2 = rental.getEndDate();

        long diff = date2.getTime() - date1.getTime();
        int days = (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

        Double payment = days * car.get().getPrice() * ( 1 - rental.getDiscount());

        car.get().setTotalIncome(car.get().getTotalIncome() + payment);
        car.get().setTotalRentals(car.get().getTotalRentals() + 1);
        this.carRepository.save(car.get());

        user.get().setMoneySpent(user.get().getMoneySpent() + payment);
        user.get().setNumberOfRentals(user.get().getNumberOfRentals() + 1);
        this.userRepository.save(user.get());

        rental.setPayment(payment);
        this.rentalRepository.save(rental);

    }
}
