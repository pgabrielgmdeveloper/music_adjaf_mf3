package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.config;

import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;

import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.logging.Logger;

@Configuration
@Slf4j
public class JwtConfig {
    @Value("${security.jwt.pubkey}")
    private String key;
    @Value("${security.jwt.privkey}")
    private String priv;


    @Bean
    JwtEncoder jwtEncoder() throws Exception {
        log.info("Criando JWT ENCODER");
        log.info("public Key: {}", key);
        log.info("private Key: {}", priv);
        var jwk = new RSAKey.Builder(getPublicKey()).privateKey(getPrivateKey()).build();
        var jwks = new ImmutableJWKSet<>(new JWKSet(jwk));
        return new NimbusJwtEncoder(jwks);
    }


    @Bean
    JwtDecoder jwtDecoder() throws Exception {
        return NimbusJwtDecoder.withPublicKey(getPublicKey()).build();
    }




    private RSAPublicKey getPublicKey() {
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpecX509 = new X509EncodedKeySpec(Base64.getDecoder().decode(key));
            return (RSAPublicKey) kf.generatePublic(keySpecX509);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private PrivateKey getPrivateKey() {
        try {
            KeyFactory kf = KeyFactory.getInstance("RSA");
            var privateKey = priv.replaceAll("\\n", "");
            PKCS8EncodedKeySpec keySpecPKCS8 = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
            return kf.generatePrivate(keySpecPKCS8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
