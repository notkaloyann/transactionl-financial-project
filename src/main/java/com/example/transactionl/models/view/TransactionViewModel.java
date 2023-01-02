package com.example.transactionl.models.view;

import com.example.transactionl.models.entities.UserEntity;

import java.time.Instant;

public class TransactionViewModel {
    private String sender;
    private String receiver;
    private String sentOn;
    private double amount;
    private String comment;

    public TransactionViewModel() {
    }

    public String getSender() {
        return sender;
    }

    public TransactionViewModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public TransactionViewModel setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getSentOn() {
        return sentOn;
    }

    public TransactionViewModel setSentOn(String sentOn) {
        this.sentOn = sentOn;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionViewModel setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public TransactionViewModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
