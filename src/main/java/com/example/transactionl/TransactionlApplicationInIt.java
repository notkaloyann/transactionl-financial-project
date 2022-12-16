package com.example.transactionl;

import com.example.transactionl.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TransactionlApplicationInIt implements CommandLineRunner {

    private final UserService userService;

    public TransactionlApplicationInIt(UserService userService) {
        this.userService = userService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.userService.seedUsers();

    }
}
