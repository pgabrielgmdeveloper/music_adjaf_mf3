package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.model;

import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.cult.repository.entity.Cult;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.praise.repository.entity.Praise;

import java.util.List;

public record CultResponse(
        String id,
        String name,
        List<PraiseResponse> praiseResponses

) {
    public static CultResponse withCult (Cult cult) {
        return new CultResponse(
                cult.getId(),
                cult.getName(),
                cult.getPraises() != null ? cult.getPraises().stream().map(PraiseResponse::withPraiseE).toList() : null
        );
    }
}

record Music(
        String id,
        String singer,
        String name,
        String letter
) {

}
record Group(
        String id,
        String name
) {

}

record PraiseResponse(
        String id,
        Group group,
        Music music
) {
    public static PraiseResponse withPraiseE(Praise praise) {
        return new PraiseResponse(
                praise.getId(),
                praise.getSingers() != null ?new Group(
                        praise.getSingers().getId(),
                        praise.getSingers().getName()
                ) : null,
                praise.getMusic() != null ? new Music(
                        praise.getMusic().getId(),
                        praise.getMusic().getSinger(),
                        praise.getMusic().getName(),
                        praise.getMusic().getLetter()
                ) : null
        );
    }
}