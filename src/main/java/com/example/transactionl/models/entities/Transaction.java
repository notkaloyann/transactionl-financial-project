package com.example.transactionl.models.entities;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
@Table(name = "transactions")
public class Transaction extends BaseEntity{

    private UserEntity sender;
    private UserEntity receiver;
    private Instant sentOn;
    private double amount;
    private String comment;


    public Transaction() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @NotNull
    public UserEntity getSender() {
        return sender;
    }

    public Transaction setSender(UserEntity sender) {
        this.sender = sender;
        return this;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @NotNull
    public UserEntity getReceiver() {
        return receiver;
    }

    public Transaction setReceiver(UserEntity receiver) {
        this.receiver = receiver;
        return this;
    }

    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Column(name = "sent_on")
    public Instant getSentOn() {
        return sentOn;
    }

    public Transaction setSentOn(Instant sentOn) {
        this.sentOn = sentOn;
        return this;
    }

    @NotNull
    @Column(name = "amount")
    public double getAmount() {
        return amount;
    }

    public Transaction setAmount(double amount) {
        this.amount = amount;
        return this;
    }

    @Length(max = 50)
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    public Transaction setComment(String comment) {
        this.comment = comment;
        return this;
    }
}
