package com.lirdaw.simpleuserrolerestapi.rest;

import com.lirdaw.simpleuserrolerestapi.entity.Role;
import com.lirdaw.simpleuserrolerestapi.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RoleRestController {
    private RoleService roleService;

    @Autowired
    public RoleRestController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/roles")
    public List<Role> getUsers() {
        return roleService.findAll();
    }

    @GetMapping("/roles/{idRole}")
    public Role getRole(@PathVariable int idRole) {
        return roleService.findById(idRole);
    }

    @PostMapping("/roles")
    public Role addRole(@RequestBody Role role) {
        role.setIdRole(0);

        roleService.save(role);

        return role;
    }

    @PutMapping("/roles")
    public Role updateUser(@RequestBody Role role) {
        roleService.save(role);

        return role;
    }

    @DeleteMapping("/roles/{idRole}")
    public String updateRole(@PathVariable int idRole) {
        Role role = roleService.findById(idRole);

        if (role == null) {
            throw new RuntimeException("Role with given id (" + idRole + ") not found.");
        }

        roleService.deleteById(idRole);

        return "Role successfully deleted.";
    }
}
