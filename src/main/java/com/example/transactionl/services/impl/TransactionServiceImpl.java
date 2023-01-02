package com.example.transactionl.services.impl;

import com.example.transactionl.models.entities.Transaction;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;
import com.example.transactionl.repositories.TransactionRepository;
import com.example.transactionl.services.TransactionService;
import com.example.transactionl.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final UserService userService;
    private final TransactionRepository transactionRepository;
    private final ModelMapper modelMapper;

    public TransactionServiceImpl(UserService userService, TransactionRepository transactionRepository, ModelMapper modelMapper) {
        this.userService = userService;
        this.transactionRepository = transactionRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void seedTransactions() {
        if (this.transactionRepository.count() == 0) {
            Transaction transaction = new Transaction();
            transaction.setSender(this.userService.returnUserById(1L)).setReceiver(this.userService.returnUserById(2L)).setAmount(20).setSentOn(Instant.now()).setComment("Here you go");
            transactionRepository.save(transaction);

            Transaction transaction2 = new Transaction();
            transaction2.setSender(this.userService.returnUserById(2L)).setReceiver(this.userService.returnUserById(1L)).setAmount(10).setSentOn(Instant.now()).setComment("You're welcome");
            transactionRepository.save(transaction2);
        }
    }

    @Override
    public List<TransactionViewModel> getReceiversTransactions(UserEntity user) {
        List<Transaction> transactions = this.transactionRepository.getTransactionsByReceiver(user);
        return mapToViewModel(transactions);
    }

    @Override
    public List<TransactionViewModel> getSendersTransactions(UserEntity user) {
        List<Transaction> transactions = this.transactionRepository.getTransactionsBySender(user);
        return mapToViewModel(transactions);
    }

    private List<TransactionViewModel> mapToViewModel(List<Transaction> transactions){
        List<TransactionViewModel> transactionViewModels = new ArrayList<>();
        transactions.forEach(x -> {
            String sender = x.getSender().getUsername();
            String receiver = x.getReceiver().getUsername();
            String sentOn = x.getSentOn().toString();
            TransactionViewModel transactionViewModel = this.modelMapper.map(x, TransactionViewModel.class);
            transactionViewModel.setSender(sender);
            transactionViewModel.setReceiver(receiver);
            transactionViewModel.setSentOn(sentOn);
            transactionViewModels.add(transactionViewModel);

        });
        return transactionViewModels;
    }


}
