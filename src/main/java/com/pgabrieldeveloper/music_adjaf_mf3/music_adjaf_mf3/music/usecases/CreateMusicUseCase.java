package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.usecases;


import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.CreateMusicRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.MusicResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.MusicRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity.Music;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateMusicUseCase {
    private final MusicRepository repository;

    public MusicResponse execute(CreateMusicRequest music) throws Exception {
        var musicEntity = Music
                .builder()
                .name(music.name())
                .id(UUID.randomUUID().toString())
                .letter(music.letter())
                .singer(music.singer())
                .build();

        var musicE = repository.save(musicEntity);
        return new MusicResponse(
                musicE.getId(),
                musicE.getSinger(),
                musicE.getName(),
                musicE.getLetter()
        );
    }
}
