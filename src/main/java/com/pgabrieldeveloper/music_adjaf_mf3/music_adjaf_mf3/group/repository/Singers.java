package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.group.repository;

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
public class Singers {

    @Id
    private String id;
    private String name;

}
