package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.praise.repository.entity.Praise;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cult {
    @Id
    private String id;
    private String name;
    private Date cultDate;

    @OneToMany()
    @JoinColumn(name = "cult_id")
    private Set<Praise> praises = new HashSet<>();


}
