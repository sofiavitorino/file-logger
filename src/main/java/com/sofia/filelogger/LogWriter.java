package com.sofia.filelogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    private File logFile;
    private LogRotator rotator;

    public LogWriter(String path, LogRotator rotator) {
        this.logFile = new File(path);
        this.rotator = rotator;
        logFile.getParentFile().mkdirs();
    }

    public void write(LogEntry entry) {
        if (rotator.shouldRotate(logFile)) {
            try {
                rotator.rotate(logFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))) {
            bw.write(entry.toString());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
