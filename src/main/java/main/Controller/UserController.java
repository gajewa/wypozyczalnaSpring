package main.Controller;


import main.Entity.User;
import main.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUsers(){
        return this.userService.getAllUsers();
    }

    @RequestMapping(value = "/ranking", method = RequestMethod.GET)
    public Collection<User> getRanking(){
        return this.userService.getRanking();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getuserById(@PathVariable("id") String id){
        return this.userService.getUserByIdNumber(id);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void addNewUser(@RequestBody User user){
        this.userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void getUserByIdNumber(@RequestBody User user)

}
