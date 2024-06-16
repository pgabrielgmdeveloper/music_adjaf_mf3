package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CultResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.CultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetCultByIdUseCase {


    private final CultRepository repository;

    public CultResponse execute(String id) {
        return CultResponse.withCult(repository.findById(id).get());
    }

}
