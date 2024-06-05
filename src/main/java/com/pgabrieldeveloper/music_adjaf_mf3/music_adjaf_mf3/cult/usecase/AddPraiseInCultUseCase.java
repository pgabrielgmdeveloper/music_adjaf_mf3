package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.usecase;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.AddPraiseOnCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.CultRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.Praise;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.PraiseRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.Singers;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity.Music;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AddPraiseInCultUseCase {

    private final CultRepository repository;
    private final PraiseRepository praiseRepository;

    @Transactional
    public void execute(AddPraiseOnCultRequest request){
        var record = repository.findById(request.id());
        var cult = record.get();
        var praise = Praise.builder()
                .music(
                        Music
                                .builder()
                                .id(request.music().id())
                                .name(request.music().name())
                                .letter(request.music().letter())
                                .singer(request.music().singer())
                                .build()
                )
                .singers(
                        Singers
                                .builder()
                                .name(request.group().name())
                                .id(request.group().id())
                                .build()
                )
                .id(UUID.randomUUID().toString())
                .build();
        var recordPraise = praiseRepository.save(praise);
        cult.getPraises().add(
                recordPraise
        );
        repository.save(cult);
        System.out.println("Salvo");
    }
}
