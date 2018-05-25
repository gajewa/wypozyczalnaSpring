package main.Dao;

import main.Entity.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RentalRepository extends MongoRepository<Rental, String> {
}
