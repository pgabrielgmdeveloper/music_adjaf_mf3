package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${cloud.s3.accessKey}")
    private String accessKey;

    @Value("${cloud.s3.secretKey}")
    private String secretKey;

    @Bean
    public AmazonS3 s3Client() {
        var credentials = new BasicAWSCredentials(accessKey,secretKey);
        var S3Client = AmazonS3Client
                .builder()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_2)
                .build();

        return S3Client;
    }

}
