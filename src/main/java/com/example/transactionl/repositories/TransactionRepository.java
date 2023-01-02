package com.example.transactionl.repositories;

import com.example.transactionl.models.entities.Transaction;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> getTransactionsByReceiver(UserEntity user);
    List<Transaction> getTransactionsBySender(UserEntity user);

}
