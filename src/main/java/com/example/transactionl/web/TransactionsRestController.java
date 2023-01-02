package com.example.transactionl.web;

import com.example.transactionl.models.entities.Transaction;
import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;
import com.example.transactionl.repositories.UserRepository;
import com.example.transactionl.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TransactionsRestController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final TransactionService transactionService;

    public TransactionsRestController(UserRepository userRepository, ModelMapper modelMapper, TransactionService transactionService) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.transactionService = transactionService;
    }

    @GetMapping("users/transactions/received")
    public ResponseEntity<List<TransactionViewModel>> receivedTransactions (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserEntity user = userRepository.getUserEntityByUsername(name).orElse(null);
        List<TransactionViewModel> transactionViewModels = this.transactionService.getReceiversTransactions(user);
        return ResponseEntity.of(Optional.of(transactionViewModels));
    }

    @GetMapping("users/transactions/sent")
    public ResponseEntity<List<TransactionViewModel>> sentTransactions (){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        UserEntity user = userRepository.getUserEntityByUsername(name).orElse(null);
        List<TransactionViewModel> transactionViewModels = this.transactionService.getSendersTransactions(user);
        return ResponseEntity.of(Optional.of(transactionViewModels));
    }

}
