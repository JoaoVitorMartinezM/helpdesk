package com.devmarcelino.helpdesk.controllers;

import com.devmarcelino.helpdesk.dto.UserRecord;
import com.devmarcelino.helpdesk.dto.UserResponse;
import com.devmarcelino.helpdesk.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public ResponseEntity<Void> createUser(@RequestBody UserRecord userRecord){

        Optional<UUID> idOpt = userService.createUser(userRecord);

        if (idOpt.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> retrieveUsers(){
        return ResponseEntity.ok(userService.retrieveUsers());
    }
}
