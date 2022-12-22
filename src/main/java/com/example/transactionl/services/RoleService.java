package com.example.transactionl.services;

import com.example.transactionl.models.entities.Role;
import com.example.transactionl.models.entities.RoleEnums;

import java.util.List;

public interface RoleService {

    void seedRoles(List<Role> roles);
    Role returnRoleByName(String roleEnum);

}
