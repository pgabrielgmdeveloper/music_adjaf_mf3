package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingerRepository extends JpaRepository<Singers,String> {

}
