package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.controller;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.controller.API.SingerAPI;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.CreateSingerRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.SingerResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.SingerRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.services.SingerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SingerController implements SingerAPI {

    private final SingerService service;

    @Override
    public ResponseEntity<?> createSinger(CreateSingerRequest request) {
        try {
            service.createSinger(request.name());
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        }catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<List<SingerResponse>> getAllSinger() {
        return ResponseEntity.ok(service.getAllSinger());
    }
}
