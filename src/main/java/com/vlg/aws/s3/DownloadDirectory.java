package com.vlg.aws.s3;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.transfer.MultipleFileDownload;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;

import java.io.File;

public class DownloadDirectory {
    public static void main(String[] args) {
        System.out.println("Download started ...");
        String clientRegion = "us-east-1";
        String bucketName = "my-tenant-logs";
        String keyPrefix = "Tenant_1";
        String downloadDir = "/home/viduranga/Desktop/DownloadLogs/logFile.log";

        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                .withCredentials(new ProfileCredentialsProvider())
                .withRegion(clientRegion)
                .build();

        TransferManagerBuilder tmb = TransferManagerBuilder.standard();
        tmb.setS3Client(s3Client);
        TransferManager tm = tmb.build();
        MultipleFileDownload mfd = tm.downloadDirectory(bucketName, keyPrefix, new File(downloadDir));

        System.out.println("Finished downloading");


    }


}
