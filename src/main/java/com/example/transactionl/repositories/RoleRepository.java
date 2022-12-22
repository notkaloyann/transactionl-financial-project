package com.example.transactionl.repositories;

import com.example.transactionl.models.entities.Role;
import com.example.transactionl.models.entities.RoleEnums;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

     Role findRoleByRoleEnum(RoleEnums roleEnum);

}
