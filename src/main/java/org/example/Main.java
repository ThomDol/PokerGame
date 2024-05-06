package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        LOGGER.trace("message de trace");
        LOGGER.debug("message de debug");
        LOGGER.info("message de info");
        LOGGER.warn("message de warn");
        LOGGER.error("message de error");
        LOGGER.fatal("message de fatal");
    }
}








