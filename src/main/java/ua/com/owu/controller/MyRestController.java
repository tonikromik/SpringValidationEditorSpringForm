package ua.com.owu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.owu.entity.User;
import ua.com.owu.service.user.UserService;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private UserService userService;

    @GetMapping("/giveAllUsers")
    public List<User> giveAllUsers() {
        return userService.findAll();
    }

//    @PostMapping("/saveUserRest")
//    public void saveUserRest(@RequestBody User user){
//        userService.save(user);
//    }

    @PutMapping("/saveUserRest/{xxx}")
//    @RequestMapping(value = "/saveUserRest/{xxx}", method = RequestMethod.PUT)
    public void saveUser2(@PathVariable("xxx") String name) {
        User user = new User();
        user.setName(name);
        userService.save(user);
    }

}
