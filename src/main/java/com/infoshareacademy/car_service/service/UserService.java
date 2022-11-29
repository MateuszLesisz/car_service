package com.infoshareacademy.car_service.service;

import com.infoshareacademy.car_service.dto.UserDto;
import com.infoshareacademy.car_service.exception.user.UserAlreadyExistsException;
import com.infoshareacademy.car_service.model.User;
import com.infoshareacademy.car_service.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .phoneNumber(userDto.getPhoneNumber())
                .active(false)
                .build();
       userRepository.save(user);
    }

    public Optional<User> isUserAlreadyExists(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);

        if(user.isPresent()) {
            throw new UserAlreadyExistsException(email);
        }
        return user;
    }
}
