package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.dto.UserDto;
import com.infoshareacademy.car_service.model.User;
import com.infoshareacademy.car_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final EmailSenderService emailSenderService;
    private static final String SUBJECT = "Car Service Registration";
    private static final String BODY = "Below is a registration link. Click it to activate your account";

    public void createUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .active(false)
                .build();
        userRepository.save(user);
        emailSenderService.sendEmail(user.getEmail(), SUBJECT,  BODY);
    }
}