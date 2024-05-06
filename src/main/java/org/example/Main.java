package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Scanner;

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




 /*Scanner clavier = new Scanner(System.in);

        Poker game = new Poker();
        game.registerPlayers(new Player("Tom",100), new Player("John",100), new Player("Franck",100));
        game.start();
        game.displayHands();
        for (int i = 0; i < game.getPlayersRegistered().size(); i++) {
            System.out.println(game.getPlayersRegistered().get(i).getName() + ", voulez vous changer de cartes ? oui ou non");
            String reponse = clavier.nextLine();
            if (reponse.equalsIgnoreCase("oui")) {
                System.out.println("Une, deux, ou trois cartes ?");
                int number = clavier.nextInt();
                for (int j = 0; j < number; j++) {
                    System.out.println("Quelle carte, donnez son numéro ");
                    int repNum = clavier.nextInt();
                    game.getPlayersRegistered().get(i).getHand().changeCard(repNum, game.getDeck().dealOneCard());
                }
                clavier.nextLine();
            }

        }
        game.displayHands();
        for (Player winner : game.getWinner()) {
            System.out.println("Winner : " + winner.getName());
        }*/



