package com.example.transactionl.services;

import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;

import java.util.List;

public interface TransactionService {
    void seedTransactions();
    List<TransactionViewModel> getReceiversTransactions(UserEntity user);
    List<TransactionViewModel> getSendersTransactions(UserEntity user);

}
