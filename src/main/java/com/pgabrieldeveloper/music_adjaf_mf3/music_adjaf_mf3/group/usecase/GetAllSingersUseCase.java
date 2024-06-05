package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.usecase;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.SingerResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.SingerRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.Singers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class GetAllSingersUseCase {
    private final SingerRepository repository;

    public List<SingerResponse> execute() {
        return repository.findAll().stream().map(SingerResponse::withSinget).toList();
    }

}
