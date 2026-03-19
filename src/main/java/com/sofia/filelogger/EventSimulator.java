package com.sofia.filelogger;

import java.util.Arrays;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

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
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime currentTime = LocalDateTime.now();
            LogLevel level = LogLevel.values()[random.nextInt(LogLevel.values().length)];
            String message = messages[random.nextInt(messages.length)];
            System.out.println("[" + currentTime.format(formatter) + "] [" + level + "] " + message);
            Thread.sleep(500);
        }
    }
}
