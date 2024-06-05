package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.usecase;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.SingerRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.Singers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class CreateSingerUseCase {
    private final SingerRepository repository;

    public void execute(String name) {
        var singer = Singers.builder()
                .id(UUID.randomUUID().toString())
                .name(name)
                .build();
        repository.save(singer);
    }

}
