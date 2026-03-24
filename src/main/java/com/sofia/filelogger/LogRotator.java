package com.sofia.filelogger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogRotator {
    private long maxSizeBytes;

    public LogRotator(long maxSizeBytes){
        this.maxSizeBytes = maxSizeBytes;
    }

    public boolean shouldRotate(File logFile) {
        return logFile.length() >= maxSizeBytes;
    }

    public void rotate(File logFile) throws IOException {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd_HHmmss"));
        String rotatedName = "app_" + timestamp + ".log";
        File rotatedFile = new File(logFile.getParent(), rotatedName);
        Files.move(logFile.toPath(), rotatedFile.toPath());
    }
}
