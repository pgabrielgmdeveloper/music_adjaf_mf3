package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CreateCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.Cult;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.CultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashSet;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateCultUseCase {
    private final CultRepository cultRepository;


    public void execute(CreateCultRequest request){
        var cult = new Cult(
                UUID.randomUUID().toString(),
                request.name(),
                new Date(),
                new HashSet<>()
        );
        cultRepository.save(cult);
    }

}
