package com.sofia.filelogger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogEntry {
    private LocalDateTime currentTime;
    private LogLevel messageLevel;
    private String message;

    LogEntry(LocalDateTime currentTime, LogLevel messageLevel, String message) {
        this.currentTime = currentTime;
        this.messageLevel = messageLevel;
        this.message = message;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return "[" + currentTime.format(formatter) + "] [" + messageLevel + "] " + message;
    }

}
