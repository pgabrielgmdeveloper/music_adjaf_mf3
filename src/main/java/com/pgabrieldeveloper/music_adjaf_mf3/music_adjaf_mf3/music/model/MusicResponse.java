package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity.Music;

public record MusicResponse(
        String id,
        String singer,
        String name,
        String letter
) {
    public static MusicResponse withMusic(Music music){
        return new MusicResponse(music.getId(), music.getSinger(), music.getName(), music.getLetter());
    }
}
