package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.controller.API;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.CreateSingerRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.model.SingerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("v1/singer")
public interface SingerAPI {

    @PostMapping
    public ResponseEntity<?> createSinger(
            @RequestBody CreateSingerRequest request
            );

    @GetMapping
    public ResponseEntity<List<SingerResponse>> getAllSinger();
}
