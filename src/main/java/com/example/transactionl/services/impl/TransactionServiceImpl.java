package com.example.transactionl.services.impl;

import com.example.transactionl.models.entities.Transaction;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.repositories.TransactionRepository;
import com.example.transactionl.services.TransactionService;
import com.example.transactionl.services.UserService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;

    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
    }


    @Override
    public void seedTransactions() {
        Transaction transaction = new Transaction();
        transaction.setSender(this.userService.returnUserById(1L)).setReceiver(this.userService.returnUserById(2L)).setAmount(20).setSentOn(Instant.now()).setComment("Here you go");
        userService.returnUserById(1L).addTransaction(transaction,"sent");
        userService.returnUserById(2L).addTransaction(transaction,"received");
        transactionRepository.save(transaction);
    }



}
