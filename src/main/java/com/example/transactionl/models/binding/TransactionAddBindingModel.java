package com.example.transactionl.models.binding;


import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class TransactionAddBindingModel {

    private String receiver;
    private double amount;
    private String comment;

    public TransactionAddBindingModel() {
    }

    @NotNull
    public String getReceiver() {
        return receiver;
    }

    public TransactionAddBindingModel setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }


    @NotNull
    @Min(value = 0)
    public double getAmount() {
        return amount;
    }

    public TransactionAddBindingModel setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    @Length(max = 20)
    public String getComment() {
        return comment;
    }

    public TransactionAddBindingModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
