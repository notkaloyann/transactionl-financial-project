package com.example.transactionl.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private String username;
    private String email;
    private String password;
    private String bio;
    private String firstName;
    private String lastName;
    private Set<Transaction> receivedTransactions = new LinkedHashSet<>();
    private Set<Transaction> sentTransactions = new LinkedHashSet<>();

    @OneToMany(mappedBy = "receiver",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<Transaction> getReceivedTransactions() {
        return receivedTransactions;
    }

    public UserEntity setReceivedTransactions(Set<Transaction> receivedTransactions) {
        this.receivedTransactions = receivedTransactions;
        return this;
    }

    @OneToMany(mappedBy = "sender",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    public Set<Transaction> getSentTransactions() {
        return sentTransactions;
    }

    public UserEntity setSentTransactions(Set<Transaction> sentTransactions) {
        this.sentTransactions = sentTransactions;
        return this;
    }

    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name")
    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Column(name = "bio")
    public String getBio() {
        return bio;
    }

    public UserEntity setBio(String bio) {
        this.bio = bio;
        return this;
    }

    private List<Role> roles;

    public UserEntity() {
    }

    @Column(name = "username", nullable = false, unique = true)
    @Length(min = 5, max = 20)
    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    @Column(name = "email", nullable = false,unique = true)
    @Length(min = 5)
    public String getEmail() {
        return email;
    }

    public UserEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    //TODO - regex for password to contain certain symbols
    @Length(min = 8)
    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    public List<Role> getRoles() {
        return roles;
    }

    public UserEntity setRoles(List<Role> roles) {
        this.roles = roles;
        return this;
    }




}
