package com.example.transactionl.models.service;

import com.example.transactionl.models.entities.UserEntity;

import java.time.Instant;

public class TransactionAddServiceModel {

    private String sender;
    private String receiver;
    private String sentOn;
    private double amount;
    private String comment;

    public TransactionAddServiceModel() {
    }

    public String getSender() {
        return sender;
    }

    public TransactionAddServiceModel setSender(String sender) {
        this.sender = sender;
        return this;
    }

    public String getReceiver() {
        return receiver;
    }

    public TransactionAddServiceModel setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public String getSentOn() {
        return sentOn;
    }

    public TransactionAddServiceModel setSentOn(String sentOn) {
        this.sentOn = sentOn;
        return this;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionAddServiceModel setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public TransactionAddServiceModel setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
