package com.lirdaw.simpleuserrolerestapi.service;

import com.lirdaw.simpleuserrolerestapi.entity.Role;
import com.lirdaw.simpleuserrolerestapi.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int idRole) {
        Optional<Role> result = roleRepository.findById(idRole);

        Role role;

        if (result.isPresent()) {
            role = result.get();
        } else {
            throw new RuntimeException("There is no role with idRole: " + idRole);
        }

        return role;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);

    }

    @Override
    public void deleteById(int idRole) {
        roleRepository.deleteById(idRole);
    }
}
