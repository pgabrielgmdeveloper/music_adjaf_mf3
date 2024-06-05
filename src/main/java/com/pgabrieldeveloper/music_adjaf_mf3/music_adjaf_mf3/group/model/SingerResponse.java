package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.Singers;

public record SingerResponse(
        String id,
        String name
) {
    public static SingerResponse withSinget(Singers singers) {
        return new SingerResponse(singers.getId(), singers.getName());
    }
}
