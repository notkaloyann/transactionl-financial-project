package com.example.transactionl.services;

import com.example.transactionl.models.view.UserViewModel;

import java.util.Optional;

public interface UserService {
    void seedUsers();
    UserViewModel getUserViewModelByUsername(String username);
}
