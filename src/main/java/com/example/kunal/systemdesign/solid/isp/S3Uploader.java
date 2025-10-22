package com.example.kunal.systemdesign.solid.isp;

public class S3Uploader implements FileUploader{

    @Override
    public void uploadFile(String name) {
        System.out.println("File " + name + " uploaded to S3.");
    }
}
