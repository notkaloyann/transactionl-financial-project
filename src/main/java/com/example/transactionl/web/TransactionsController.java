package com.example.transactionl.web;

import com.example.transactionl.models.binding.TransactionAddBindingModel;
import com.example.transactionl.models.service.TransactionAddServiceModel;
import com.example.transactionl.services.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("transactions")
public class TransactionsController {

    private final ModelMapper modelMapper;
    private final TransactionService transactionService;

    public TransactionsController(ModelMapper modelMapper, TransactionService transactionService) {
        this.modelMapper = modelMapper;
        this.transactionService = transactionService;
    }

    @GetMapping("/all")
    public String showTransactions(){
        return "transactions";
    }

    @GetMapping("new")
    public String newTransactions (){
        return "send-transaction";
    }

    @PostMapping("new")
    public String recordTransaction(@Valid TransactionAddBindingModel transactionAddBindingModel,
                                    BindingResult bindingResult,
                                    RedirectAttributes redirectAttributes){
        TransactionAddServiceModel transactionAddServiceModel =
                this.modelMapper.map(transactionAddBindingModel, TransactionAddServiceModel.class);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String sender = auth.getName();
        transactionAddServiceModel.setSender(sender);
        this.transactionService.addTransaction(transactionAddServiceModel);


        return "redirect:all";

    }


}
