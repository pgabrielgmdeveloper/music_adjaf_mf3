package com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.infrastructure.uploadfile.adpters;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.pgabrieldeveloper.music_adjaf_mf3.music_adjaf_mf3.infrastructure.uploadfile.UploadFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@RequiredArgsConstructor
public class UploadFileAdapter implements UploadFile {

    private final AmazonS3 amazonS3;

    @Value("${cloud.s3.bucket.name}")
    private String bucketName;

    @Override
    public void putFile(String fileName, String name) {
        try {
            if (!amazonS3.doesBucketExistV2(bucketName)) return;
            var requestFile = new PutObjectRequest(bucketName, name, new File(fileName));
            amazonS3.putObject(requestFile);
        } catch (Exception ex) {
            System.out.println("");
        }
    }
}
