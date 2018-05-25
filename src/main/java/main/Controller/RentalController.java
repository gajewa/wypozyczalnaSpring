package main.Controller;

import main.Entity.Rental;
import main.Service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Rental> getAllRentals(){
        return this.rentalService.getAllRentals();
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Collection<Rental> getPopulatedRentals(){
        return this.rentalService.getPopulatedRentals();
    }
}
