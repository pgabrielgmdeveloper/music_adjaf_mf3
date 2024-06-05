package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository.Singers;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.music.repositorio.entity.Music;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Praise {
    @Id
    private String id;

    @ManyToOne()
    @JoinColumn(name = "music_id")
    private Music music;

    @ManyToOne()
    @JoinColumn(name = "praise_id")
    private Singers singers;
}
