package com.sofia.filelogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class LogWriter {
    private File logFile;

    public LogWriter(String path) {
        this.logFile = new File(path);
    }

    public void write(LogEntry entry) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(logFile, true))){
            bw.write(entry.toString());
            bw.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
