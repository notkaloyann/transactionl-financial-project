package com.example.transactionl.services;

import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;

import java.util.HashSet;
import java.util.List;

public interface TransactionService {
    void seedTransactions();
    HashSet<TransactionViewModel> getReceiversTransactions(UserEntity user);
    HashSet<TransactionViewModel> getSendersTransactions(UserEntity user);

}
