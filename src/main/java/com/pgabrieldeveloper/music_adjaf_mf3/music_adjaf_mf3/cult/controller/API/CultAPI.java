package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.controller.API;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CreateCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CultResponse;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("v1/cult")
public interface CultAPI {

    @PostMapping
    ResponseEntity<?> createCult(
            @RequestBody CreateCultRequest request
    );

    @GetMapping
    ResponseEntity<List<CultResponse>> getAllCultResponse();
}
