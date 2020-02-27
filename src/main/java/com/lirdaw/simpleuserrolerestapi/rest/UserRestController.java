package com.lirdaw.simpleuserrolerestapi.rest;

import com.lirdaw.simpleuserrolerestapi.entity.User;
import com.lirdaw.simpleuserrolerestapi.service.RoleService;
import com.lirdaw.simpleuserrolerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserRestController {
    private UserService userService;
    private RoleService roleService;

    @Autowired
    public UserRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/users/{idUser}")
    public User getUser(@PathVariable int idUser) {
        return userService.findById(idUser);
    }

    @PostMapping("/users")
    public User addUser(@RequestBody User user) {
        user.setIdUser(0);

        userService.save(user);

        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.save(user);

        return user;
    }

    @DeleteMapping("/users/{idUser}")
    public String updateUser(@PathVariable int idUser) {
        User user = userService.findById(idUser);

        if (user == null) {
            throw new RuntimeException("User with given id (" + idUser + ") not found.");
        }

        userService.deleteById(idUser);

        return "User successfully deleted.";
    }
}
