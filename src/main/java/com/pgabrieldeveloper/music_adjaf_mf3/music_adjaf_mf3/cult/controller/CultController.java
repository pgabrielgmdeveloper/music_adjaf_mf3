package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.controller;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.controller.API.CultAPI;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.AddPraiseOnCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CreateCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CultResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.service.CultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CultController implements CultAPI {


    private final CultService service;

    @Override
    public ResponseEntity<?> createCult(CreateCultRequest request) {
        service.createCult(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @Override
    public ResponseEntity<List<CultResponse>> getAllCultResponse() {
        return ResponseEntity.ok(service.getCultDay());
    }

    @Override
    public ResponseEntity<?> addPraise(AddPraiseOnCultRequest request) {
        service.AddPraiseInCult(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(null);

    }
}
