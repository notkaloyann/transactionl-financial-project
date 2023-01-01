package com.example.transactionl.web;

import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.models.view.TransactionViewModel;
import com.example.transactionl.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TransactionsRestController {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public TransactionsRestController(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @GetMapping("users/transactions/{id}/received/")
    public ResponseEntity<List<TransactionViewModel>> receivedTransactions (@PathVariable Long id){
        UserEntity user = userRepository.findById(id).orElse(null);
        List<TransactionViewModel> transactionViewModels = user.getReceivedTransactions().stream().map(x -> this.modelMapper.map(x, TransactionViewModel.class)).toList();
        return ResponseEntity.of(Optional.of(transactionViewModels));
    }

}
