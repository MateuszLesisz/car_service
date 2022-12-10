package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.dto.UserDto;
import com.infoshareacademy.car_service.model.Role;
import com.infoshareacademy.car_service.model.User;
import com.infoshareacademy.car_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final EmailSenderService emailSenderService;
    private static final String SUBJECT = "Car Service";
    private static final String BODY = "Welcome in our service!\nNow u can repair your car.";

    public void createUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .role(List.of(new Role("ROLE_USER")))
                .build();
        userRepository.save(user);
        emailSenderService.sendEmail(user.getEmail(), SUBJECT,  BODY);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}