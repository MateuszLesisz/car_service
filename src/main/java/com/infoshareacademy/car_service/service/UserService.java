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

    public void createUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .lastname(userDto.getLastname())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .city(userDto.getCity())
                .street(userDto.getStreet())
                .houseNumber(userDto.getHouseNumber())
                .zipCode(userDto.getZipCode())
                .build();
       userRepository.save(user);
    }
}
