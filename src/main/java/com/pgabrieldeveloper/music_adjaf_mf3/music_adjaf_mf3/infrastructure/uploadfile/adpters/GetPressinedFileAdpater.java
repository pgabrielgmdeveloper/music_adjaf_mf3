package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.infrastructure.uploadfile.adpters;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.infrastructure.uploadfile.GetPressinedFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetPressinedFileAdpater implements GetPressinedFile {

    private final AmazonS3 amazonS3;

    @Value("${BUCKET_NAME}")
    private String bucketName;

    @Override
    public String PressinedFile(String filename) {
        GeneratePresignedUrlRequest pressinedUrlRequest = new GeneratePresignedUrlRequest(bucketName, filename);
        var url = amazonS3.generatePresignedUrl(pressinedUrlRequest);
        return url.toString();
    }
}
