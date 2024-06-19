package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model;

public record CreateUserRequest(
        String username,
        String password,
        String number
) {

}
