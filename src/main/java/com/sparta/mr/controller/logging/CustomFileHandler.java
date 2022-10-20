package com.sparta.mr.controller.logging;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;

public class CustomFileHandler {

    public static FileHandler fileHandler;

    static {
        try {
            fileHandler = new FileHandler("src/main/resources/sort-manager-log.log", true);
            fileHandler.setLevel(Level.ALL);
            fileHandler.setFormatter(new CustomFormatter());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static FileHandler getFileHandler() {
        return fileHandler;
    }
}
