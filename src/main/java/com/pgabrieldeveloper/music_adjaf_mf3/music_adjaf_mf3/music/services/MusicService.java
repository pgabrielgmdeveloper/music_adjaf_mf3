package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.services;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.infrastructure.uploadfile.UploadFile;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.infrastructure.uploadfile.adpters.GetPressinedFileAdpater;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.CreateMusicRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.MusicResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.model.PressinedUrlResponse;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.usecases.CreateMusicUseCase;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.usecases.GetAllMusicUseCase;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.usecases.GetMusicByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MusicService {
    private final CreateMusicUseCase useCase;
    private final UploadFile uploadFile;
    private final GetAllMusicUseCase getAllMusic;
    private final GetMusicByIdUseCase getMusicByIdUseCase;
    private final GetPressinedFileAdpater getPressinedFileAdpater;
    public void createMusic(CreateMusicRequest request, MultipartFile music) throws Exception {
        var musicResponse = useCase.execute(request);
        var file = createTempFile(music);
        uploadFile.putFile(file.getAbsolutePath(), musicResponse.name());
    }

    public MusicResponse getMusicById(String musicId) {
        return getMusicByIdUseCase.execute(musicId);
    }

    public PressinedUrlResponse getPressinedURIMusic(String id){
        var music = getMusicByIdUseCase.execute(id);
        if(music == null) {
            return null;
        }
        var URI = getPressinedFileAdpater.PressinedFile(music.name());
        return new PressinedUrlResponse(
                music.id(),
                music.singer(),
                music.name(),
                music.letter(),
                URI
        );

    }

    public List<MusicResponse> getAllMusic(String name) throws Exception {
        return getAllMusic.execute(name);
    }

    private File createTempFile(MultipartFile music) throws IOException {
        var file = File.createTempFile("music", music.getOriginalFilename());
        music.transferTo(file);
        return file;
    }
}
