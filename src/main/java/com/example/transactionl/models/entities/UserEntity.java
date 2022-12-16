package com.example.transactionl.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class UserEntity extends BaseEntity {

    private String username;
    private String email;
    private String password;
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
