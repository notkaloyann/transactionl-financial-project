package com.example.transactionl.services.impl;

import com.example.transactionl.models.entities.Role;
import com.example.transactionl.models.entities.RoleEnums;
import com.example.transactionl.repositories.RoleRepository;
import com.example.transactionl.services.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void seedRoles(List<Role> roles) {
        this.roleRepository.saveAll(roles);

    }

    @Override
    public Role returnRoleByName(String roleEnum) {
        return this.roleRepository.findRoleByRoleEnum(RoleEnums.valueOf(roleEnum));
    }
}
