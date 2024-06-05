package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.service;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.AddPraiseOnCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CreateCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CultResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase.AddPraiseInCultUseCase;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase.CreateCultUseCase;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase.GetCultDayUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CultService {

    private final CreateCultUseCase createCultUseCase;
    private final GetCultDayUseCase getCultDayUseCase;
    private final AddPraiseInCultUseCase addPraiseInCultUseCase;

    public void createCult(CreateCultRequest request) {
        createCultUseCase.execute(request);
    }

    public List<CultResponse> getCultDay() {
        return getCultDayUseCase.execute();
    }

    public void AddPraiseInCult(AddPraiseOnCultRequest request){
        addPraiseInCultUseCase.execute(request);
    }
}
