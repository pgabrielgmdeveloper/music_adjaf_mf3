package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.config;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class S3Config {

    @Value("${ACCESS_KEY}")
    private String accessKey;

    @Value("${SECRET_KEY}")
    private String secretKey;

    @Value("${AWS_REGION}")
    private String region;


    @Bean
    public AmazonS3 s3Client() {
        var credentials = new BasicAWSCredentials(accessKey,secretKey);
        var S3Client = AmazonS3Client
                .builder()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(region)
                .build();

        return S3Client;
    }

}
