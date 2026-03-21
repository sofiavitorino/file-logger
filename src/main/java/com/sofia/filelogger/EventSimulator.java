package com.sofia.filelogger;

import java.util.Random;
import java.time.LocalDateTime;

public class EventSimulator {

    private Random random;

    private String[] messages = {
            "Backup completed successfully.",
            "Database connection established.",
            "User authentication failed.",
            "Service is unavailable.",
            "Invalid argument",
            "High memory usage",
            "CPU usage over threshold"
    };

    public EventSimulator() {
        this.random = new Random();
    }

    public void start() throws InterruptedException {
        while(true) {
            LocalDateTime currentTime = LocalDateTime.now();
            LogLevel level = LogLevel.values()[random.nextInt(LogLevel.values().length)];
            String message = messages[random.nextInt(messages.length)];
            LogEntry entry = new LogEntry(currentTime, level, message);
            System.out.println(entry);
            Thread.sleep(500);
        }
    }
}
