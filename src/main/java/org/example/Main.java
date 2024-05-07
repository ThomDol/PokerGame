package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static final Logger LOGGER = LogManager.getLogger(Main.class);


    public static void main(String[] args) {
        /*LOGGER.trace("message de trace");
        LOGGER.debug("message de debug");
        LOGGER.info("message de info");
        LOGGER.warn("message de warn");
        LOGGER.error("message de error");
        LOGGER.fatal("message de fatal");*/

        Poker game = new Poker();
        List<Player> players=new ArrayList<>();
        for (int j = 0;j<10;j++){players.add(new Player());
        game.registerPlayers(players.get(j));}
        for(int i=0;i<50;i++){
            game.party();
        }
        LOGGER.info(game.getStatGame());


    }
}








