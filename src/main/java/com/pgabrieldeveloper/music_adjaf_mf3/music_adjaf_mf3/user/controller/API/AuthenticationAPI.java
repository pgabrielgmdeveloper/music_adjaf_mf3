package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.controller.API;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.AuthRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.AuthResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model.CreateUserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("v1/authentication")
public interface AuthenticationAPI {

    @PostMapping
    ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authentication);

    @PostMapping("createuser")
    ResponseEntity<Void> createAccount(@RequestBody CreateUserRequest createUserRequest);

}
