package com.example.transactionl.services;

import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.service.UserRegisterServiceModel;
import com.example.transactionl.models.view.UserViewModel;

import java.util.Optional;

public interface UserService {
    void seedUsers();
    UserViewModel getUserViewModelByUsername(String username);
    boolean userAlreadyExist(String username);

    void registerUser(UserRegisterServiceModel userRegisterServiceModel);

    UserEntity returnUserById(Long id);
}
