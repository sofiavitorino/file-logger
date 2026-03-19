package com.sofia.filelogger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EventSimulator logCreator = new EventSimulator();

        logCreator.start();
    }
}
