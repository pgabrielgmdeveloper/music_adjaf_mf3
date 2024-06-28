package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.model;

import java.util.List;

public record AuthResponse(
        String token,
        List<String> roles
) {
}
