package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.controller.musicAPI.MusicAPI;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.CreateMusicRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.ErroResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.MusicResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.PressinedUrlResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.services.MusicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicController implements MusicAPI {

    private final MusicService musicService;

    @Override
    public ResponseEntity<?> CreateMusic(MultipartFile music, String musicJson) {

        var mapper = new ObjectMapper();

        try {
            var musicRequest = mapper.readValue(musicJson, CreateMusicRequest.class);
            musicService.createMusic(musicRequest,music);
            return ResponseEntity.status(HttpStatus.CREATED).body(null);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse("Não foi possivel fazer a conversão de dados", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErroResponse("Error ao Salvar dados no banco", e.getMessage()));

        }
    }

    @Override
    public ResponseEntity<List<MusicResponse>> getAllMusic(String name) {
        try {
            return ResponseEntity.ok(musicService.getAllMusic(name));
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @Override
    public ResponseEntity<MusicResponse> getMusicById(String musicId) {
        var response =musicService.getMusicById(musicId);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<PressinedUrlResponse> getPressinedMusic(String musicId) {
        return ResponseEntity.ok(musicService.getPressinedURIMusic(musicId));
    }
}
