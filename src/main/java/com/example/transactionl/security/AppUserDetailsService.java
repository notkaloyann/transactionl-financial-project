package com.example.transactionl.security;

import com.example.transactionl.models.entities.UserEntity;
import com.example.transactionl.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserEntity user = this.userRepository.getUserEntityByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format("User %s is not found",username)));

        return mapToUserDetails(user);
    }

    private UserDetails mapToUserDetails(UserEntity user) {
        return new User(user.getUsername(), user.getPassword(),
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority("ROLE" + role.getRoleEnum().name())).collect(Collectors.toList()));

    }
}
