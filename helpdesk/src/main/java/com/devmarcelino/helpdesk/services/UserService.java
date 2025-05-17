package com.devmarcelino.helpdesk.services;

import com.devmarcelino.helpdesk.dto.UserRecord;
import com.devmarcelino.helpdesk.dto.UserResponse;
import com.devmarcelino.helpdesk.models.User;

import com.devmarcelino.helpdesk.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<UUID> createUser(UserRecord userRecord){
        var userModel = new User();
        BeanUtils.copyProperties(userRecord, userModel);

        User user = userRepository.save(userModel);

        return Optional.of(user.getId());


    }

    public List<UserResponse> retrieveUsers() {
        List<User> users = userRepository.findAll();

        List<UserResponse> mappedList = users.stream().map(u -> new UserResponse(u.getId(), u.getUsername())).collect(Collectors.toList());
        return mappedList;
    }
}
