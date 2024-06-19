package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.controller.API;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.AddPraiseOnCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CreateCultRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model.CultResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.Cult;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("v1/cult")
public interface CultAPI {

    @PostMapping
    ResponseEntity<?> createCult(
            @RequestBody CreateCultRequest request
    );

    @GetMapping
    ResponseEntity<List<CultResponse>> getAllCultResponse();

    @PostMapping("addpraise")
    ResponseEntity<?> addPraise(
            @RequestBody AddPraiseOnCultRequest request
    );
    @GetMapping("/{id}")
    ResponseEntity<CultResponse> getCultById(
            @PathVariable String id
    );
}
