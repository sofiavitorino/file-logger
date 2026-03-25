package com.sofia.filelogger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LogRotator rotator = new LogRotator(1_048_576);
        LogWriter writer   = new LogWriter("logs/app.log", rotator);
        EventSimulator simulator = new EventSimulator(writer);
        simulator.start();
    }
}
