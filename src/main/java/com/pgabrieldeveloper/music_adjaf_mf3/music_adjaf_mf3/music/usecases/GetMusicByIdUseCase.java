package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.usecases;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.MusicResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetMusicByIdUseCase {

    private final MusicRepository repository;

    public MusicResponse execute(String musicId) {
        var music = repository.findById(musicId);
        if (music.isEmpty()){
            return null;
        }
        return MusicResponse.withMusic(music.get());
    }

}
