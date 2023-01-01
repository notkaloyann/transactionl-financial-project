package com.example.transactionl;

import com.example.transactionl.services.TransactionService;
import com.example.transactionl.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TransactionlApplicationInIt implements CommandLineRunner {

    private final UserService userService;
    private final TransactionService transactionService;

    public TransactionlApplicationInIt(UserService userService, TransactionService transactionService) {
        this.userService = userService;
        this.transactionService = transactionService;
    }


    @Override
    public void run(String... args) throws Exception {

        this.userService.seedUsers();
        this.transactionService.seedTransactions();

    }
}
