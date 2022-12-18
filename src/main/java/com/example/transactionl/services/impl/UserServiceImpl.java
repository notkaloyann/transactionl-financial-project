package com.example.transactionl.services.impl;

import com.example.transactionl.models.entities.Role;
import com.example.transactionl.models.entities.RoleEnums;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.UserViewModel;
import com.example.transactionl.repositories.UserRepository;
import com.example.transactionl.services.RoleService;
import com.example.transactionl.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, PasswordEncoder passwordEncoder, RoleService roleService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public void seedUsers() {

        if (this.userRepository.count() == 0) {

            Role adminRole = new Role().setRoleEnum(RoleEnums.ADMIN);
            Role userRole = new Role().setRoleEnum(RoleEnums.USER);
            this.roleService.seedRoles(List.of(adminRole, userRole));

            UserEntity admin = new UserEntity();
            admin.setUsername("notkaloyan").setPassword(this.passwordEncoder.encode("verySecret"))
                    .setEmail("kaloyankondow@mail.bg").setRoles(List.of(adminRole, userRole))
                    .setFirstName("Kaloyan")
                    .setLastName("Kondov");

            UserEntity user = new UserEntity();
            user.setUsername("reggie").setPassword(this.passwordEncoder.encode("notVerySecret"))
                    .setEmail("regularuser@mail.bg").setRoles(List.of(userRole))
                    .setFirstName("Regular")
                    .setLastName("User");

            this.userRepository.saveAll(List.of(admin,user));
        }
    }

    @Override
    public UserViewModel getUserViewModelByUsername(String username) {
        return this.modelMapper.map(this.userRepository.getUserEntityByUsername(username).orElse(null),UserViewModel.class);
    }
}
