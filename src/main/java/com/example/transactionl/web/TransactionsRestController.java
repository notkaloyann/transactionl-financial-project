package com.example.transactionl.web;

import com.example.transactionl.models.entities.Transaction;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;
import com.example.transactionl.models.view.UserFinancialInformationViewModel;
import com.example.transactionl.repositories.UserRepository;
import com.example.transactionl.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class TransactionsRestController {

    private final UserRepository userRepository;
    private final TransactionService transactionService;

    public TransactionsRestController(UserRepository userRepository, TransactionService transactionService) {
        this.userRepository = userRepository;
        this.transactionService = transactionService;
    }

    @GetMapping("users/transactions/details")
    public ResponseEntity<UserFinancialInformationViewModel> receivedTransactions (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        return userFinancialInfo(name);
    }

    private ResponseEntity<UserFinancialInformationViewModel> userFinancialInfo(String name) {
        UserEntity user = userRepository.getUserEntityByUsername(name).orElse(null);
        Set<TransactionViewModel> receivedTransactions = this.transactionService.getReceiversTransactions(user);
        Set<TransactionViewModel> sentTransactions = this.transactionService.getSendersTransactions(user);
        UserFinancialInformationViewModel userFinancialInformationViewModel = new UserFinancialInformationViewModel();
        userFinancialInformationViewModel.setSentTransactions(sentTransactions);
        userFinancialInformationViewModel.setReceivedTransactions(receivedTransactions);
        userFinancialInformationViewModel.setUsername(name);
        return ResponseEntity.of(Optional.of(userFinancialInformationViewModel));

    }

}
