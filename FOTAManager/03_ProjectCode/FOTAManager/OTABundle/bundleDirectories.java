package com.sloki.FOTAManager.OTABundle;

import android.net.Uri;

public class bundleDirectories {
    private String fileName;
    private long fileSize;
    private String checksum;
    private Uri filePath;

    public bundleDirectories(String fileName, long fileSize, String checksum, Uri filePath) {
        this.fileName = fileName;
        this.fileSize = fileSize;
        this.checksum = checksum;
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getChecksum() {
        return checksum;
    }

    public void setChecksum(String checksum) {
        this.checksum = checksum;
    }

    public Uri getFilePath() {
        return filePath;
    }

    public void setFilePath(Uri filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "FirmwareImageFile{" +
                "fileName='" + fileName + '\'' +
                ", fileSize=" + fileSize +
                ", checksum='" + checksum + '\'' +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
