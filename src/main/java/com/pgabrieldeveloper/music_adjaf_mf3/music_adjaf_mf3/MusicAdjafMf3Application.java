package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.MusicRepository;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity.Music;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MusicAdjafMf3Application {

	public static void main(String[] args) {
		SpringApplication.run(MusicAdjafMf3Application.class, args);
	}

}
