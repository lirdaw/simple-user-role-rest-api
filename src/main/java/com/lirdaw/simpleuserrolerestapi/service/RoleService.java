package com.lirdaw.simpleuserrolerestapi.service;

import com.lirdaw.simpleuserrolerestapi.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role findById(int idRole);

    void save(Role role);

    void deleteById(int idRole);
}
