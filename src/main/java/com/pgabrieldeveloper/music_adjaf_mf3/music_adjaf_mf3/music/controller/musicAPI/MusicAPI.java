package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.controller.musicAPI;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.MusicResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.PressinedUrlResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.RequestMusicPressinedURL;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("v1/music")
public interface MusicAPI {


    @PostMapping
    ResponseEntity<?> CreateMusic(
            @RequestPart("music") MultipartFile music,
            @RequestParam("musicJson") String musicJson
    );

    @GetMapping
    ResponseEntity<List<MusicResponse>> getAllMusic(
            @RequestParam(value = "name", required = false, defaultValue = "") String name
    );

    @GetMapping("{id}")
    ResponseEntity<MusicResponse> getMusicById(
      @PathVariable("id") String musicId
    );

    @PostMapping("pressined")
    ResponseEntity<List<PressinedUrlResponse>> getPressinedMusic(
       @RequestBody  RequestMusicPressinedURL musicsId
    );

}
