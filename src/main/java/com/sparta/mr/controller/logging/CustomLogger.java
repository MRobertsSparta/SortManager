package com.sparta.mr.controller.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomLogger {

    public static Logger getLogger() {
        Logger logger = Logger.getLogger("Custom Logger");
        configureLogger(logger);
        return logger;
    }

    public static void configureLogger(Logger logger) {
        logger.setUseParentHandlers(false);
        logger.setLevel(Level.ALL);
        logger.addHandler(CustomFileHandler.getFileHandler());
    }

}
