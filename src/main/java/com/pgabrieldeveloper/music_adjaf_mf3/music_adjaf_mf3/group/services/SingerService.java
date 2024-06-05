package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.services;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.SingerResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.usecase.CreateSingerUseCase;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.usecase.GetAllSingersUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SingerService {
    private final CreateSingerUseCase createSingerUseCase;
    private final GetAllSingersUseCase getAllSingersUseCase;

    public void createSinger(String name){
        createSingerUseCase.execute(name);
    }

    public List<SingerResponse> getAllSinger() {
        return getAllSingersUseCase.execute();
    }
}
