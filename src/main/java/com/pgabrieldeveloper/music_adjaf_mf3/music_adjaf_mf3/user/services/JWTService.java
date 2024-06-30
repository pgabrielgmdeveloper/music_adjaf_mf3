package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.user.services;


import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.*;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JWTService {

    private final JwtEncoder encoder;
    private final JwtDecoder decoder;

    public String generateToken(Authentication authentication){
        var now = Instant.now();
        var expiry = 144400L;
        var scopes = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(" "));
        var claims = JwtClaimsSet.builder()
                .issuer("music_adjaf_mf3")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiry))
                .subject(authentication.getName())
                .claim("scope", scopes)
                .build();
        return encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
    }
    public String validateToken(String token){
        try{
            var tokenn = this.decoder.decode(token);
            return  tokenn.getSubject();
        }catch (JwtValidationException ex) {
            return "";
        }

    }
}
