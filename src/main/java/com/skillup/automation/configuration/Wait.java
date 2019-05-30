package com.skillup.automation.configuration;

//создали класс Wait, чтобы иметь централизированное место - где хранятся ожидания
public class Wait {
    public static final int FIVE_SECONDS = 5;
    public static final int TEN_SECONDS = 10;

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            //TODO: log this exception
        }
    }
}
