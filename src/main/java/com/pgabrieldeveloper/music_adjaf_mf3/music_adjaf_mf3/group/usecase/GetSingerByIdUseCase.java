package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.usecase;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.SingerResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.SingerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class GetSingerByIdUseCase {
    private final SingerRepository repository;

    public SingerResponse execute(String id) {
        return SingerResponse.withSinget(repository.findById(id).get());
    }
}
