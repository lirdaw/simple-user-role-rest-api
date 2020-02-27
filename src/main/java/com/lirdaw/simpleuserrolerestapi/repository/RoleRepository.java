package com.lirdaw.simpleuserrolerestapi.repository;

import com.lirdaw.simpleuserrolerestapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
