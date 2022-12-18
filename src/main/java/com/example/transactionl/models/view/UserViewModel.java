package com.example.transactionl.models.view;

public class UserViewModel {

    private String username;
    private String email;
    private String bio;
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public UserViewModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserViewModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBio() {
        return bio;
    }

    public UserViewModel setBio(String bio) {
        this.bio = bio;
        return this;
    }


    public UserViewModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserViewModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserViewModel setEmail(String email) {
        this.email = email;
        return this;
    }
}
