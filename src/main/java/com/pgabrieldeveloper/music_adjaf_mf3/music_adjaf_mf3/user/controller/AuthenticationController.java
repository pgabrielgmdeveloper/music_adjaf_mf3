package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.controller;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.services.AuthenticationService;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.controller.API.AuthenticationAPI;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.AuthRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.AuthResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.CreateUserRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.repository.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;

@RestController
@RequiredArgsConstructor
public class AuthenticationController  implements AuthenticationAPI {

    private final AuthenticationService service;

    @Override
    public ResponseEntity<AuthResponse> login(AuthRequest authentication) {

        return ResponseEntity.ok(
                service.login(authentication)
        );
    }

    @Override
    public ResponseEntity<Void> createAccount(CreateUserRequest createUserRequest) {
        service.createUser(new User(createUserRequest.username(),createUserRequest.password(),createUserRequest.number(), new HashSet<>()));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
