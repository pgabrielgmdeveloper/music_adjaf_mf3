package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Music {
    @Id
    private String id;
    private String singer;
    private String name;
    private String letter;
}

