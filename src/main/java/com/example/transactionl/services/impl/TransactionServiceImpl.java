package com.example.transactionl.services.impl;

import com.example.transactionl.models.entities.Transaction;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.service.TransactionAddServiceModel;
import com.example.transactionl.models.view.TransactionViewModel;
import com.example.transactionl.repositories.TransactionRepository;
import com.example.transactionl.services.TransactionService;
import com.example.transactionl.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.HashSet;


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
    public HashSet<TransactionViewModel> getReceiversTransactions(UserEntity user) {
        HashSet<Transaction> transactions = new HashSet<>(user.getReceivedTransactions());
        return mapToViewModel(transactions);
    }


    @Override
    public HashSet<TransactionViewModel> getSendersTransactions(UserEntity user) {
        HashSet<Transaction> transactions = new HashSet<Transaction>(user.getSentTransactions());
        return mapToViewModel(transactions);
    }

    @Override
    public void addTransaction(TransactionAddServiceModel transactionAddServiceModel) {
        Transaction transaction = this.modelMapper.map(transactionAddServiceModel,Transaction.class);
        UserEntity sender = this.userService.returnUserEntityByUsername(transactionAddServiceModel.getSender());
        UserEntity receiver = this.userService.returnUserEntityByUsername(transactionAddServiceModel.getReceiver());
        Instant createdOn = Instant.now();
        transaction.setSender(sender).setReceiver(receiver).setSentOn(createdOn);
        this.transactionRepository.save(transaction);
    }

    private HashSet<TransactionViewModel> mapToViewModel(HashSet<Transaction> transactions){
        HashSet<TransactionViewModel> transactionViewModels = new HashSet<>();
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
