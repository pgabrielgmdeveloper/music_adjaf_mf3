package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase;


import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CultResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.CultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCultDayUseCase {
    private final CultRepository repository;

    public List<CultResponse> execute() {
        var response = repository.findAllCult();
        return response.stream().map(CultResponse::withCult).toList();
    }
}
