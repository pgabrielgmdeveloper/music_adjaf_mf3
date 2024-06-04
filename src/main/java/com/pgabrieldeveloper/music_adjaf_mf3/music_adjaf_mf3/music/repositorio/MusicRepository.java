package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicRepository extends JpaRepository<Music, String> {

    @Query(value = "SELECT * FROM music WHERE name ilike %:name%", nativeQuery = true)
    List<Music> GetAllMusicByName(@Param("name") String name);

}
