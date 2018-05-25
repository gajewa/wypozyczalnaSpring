package main.Service;

import main.Dao.UserRepository;
import main.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public Collection<User> getAllUsers(){
        return this.userRepo.findAll();
    }

    public User getUserById(String id){
        return this.getUserById(id);
    }

    public void addUser(User user){
        this.userRepo.save(user);
    }

    public User getUserByIdNumber(String idNumber){
        return this.userRepo.findByIdNumber(idNumber);
    }

    public void updateUser(User user){
        this.userRepo.save(user);
    }

    public Collection<User> getRanking(){
        List<User> temp = new ArrayList<User>(this.userRepo.findAll());
        Collections.sort(temp, (o1, o2) ->  o2.getMoneySpent().intValue() - o1.getMoneySpent().intValue());

        return temp.subList(0, 3);
    }



}
