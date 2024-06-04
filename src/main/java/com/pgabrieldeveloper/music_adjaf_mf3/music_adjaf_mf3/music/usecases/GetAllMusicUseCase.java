package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.usecases;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.MusicResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.MusicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllMusicUseCase {

    private final MusicRepository repository;

    public List<MusicResponse> execute(String name) {
        return repository.GetAllMusicByName(name)
                .stream()
                .map(MusicResponse::withMusic)
                .toList();
    }

}
