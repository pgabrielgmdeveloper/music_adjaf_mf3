package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CultRepository extends JpaRepository<Cult, String> {

    @Query(value = "SELECT * FROM cult WHERE cult_date >= NOW() - INTERVAL '24 HOURS'", nativeQuery = true)
    List<Cult> findAllCult();


}
