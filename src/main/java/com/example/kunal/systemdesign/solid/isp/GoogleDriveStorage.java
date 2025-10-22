package com.example.kunal.systemdesign.solid.isp;

public class GoogleDriveStorage implements FileUploader, Shareable{

    @Override
    public void uploadFile(String name) {
        System.out.println("File " + name + " uploaded to Google Drive.");
    }

    @Override
    public void shareFile(String name) {
        System.out.println("File " + name + " shared from Google Drive.");
    }
}
