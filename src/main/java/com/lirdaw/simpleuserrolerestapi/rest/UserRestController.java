package com.lirdaw.simpleuserrolerestapi.rest;

import com.lirdaw.simpleuserrolerestapi.entity.Role;
import com.lirdaw.simpleuserrolerestapi.entity.User;
import com.lirdaw.simpleuserrolerestapi.service.RoleService;
import com.lirdaw.simpleuserrolerestapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
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
        if (user.getIdUser() != 0) {
            throw new RuntimeException("To insert user, id must be equal 0.");
        }

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new RuntimeException("To insert user, it must have defined roles.");
        }

        HashSet<Role> roles = new HashSet<>();
        user.getRoles().forEach(role -> roles.add(roleService.findById(role.getIdRole())));
        user.setRoles(roles);

        userService.save(user);

        return user;
    }

    @PutMapping("/users")
    public User updateUser(@RequestBody User user) {
        userService.findById(user.getIdUser());

        if (user.getRoles() == null || user.getRoles().isEmpty()) {
            throw new RuntimeException("To update user, it must have defined roles.");
        }

        // get all roles / check if exists in database - for user by id
        HashSet<Role> roles = new HashSet<>();
        user.getRoles().forEach(role -> roles.add(roleService.findById(role.getIdRole())));
        user.setRoles(roles);

        userService.save(user);

        return user;
    }

    @DeleteMapping("/users/{idUser}")
    public String deleteUser(@PathVariable int idUser) {
        userService.findById(idUser);

        userService.deleteById(idUser);

        return "User successfully deleted.";
    }
}
