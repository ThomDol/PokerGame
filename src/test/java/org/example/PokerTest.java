package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerTest {

    Player tom=new Player("Tom");
    Player jack = new Player("jack");
    Player john = new Player("john");
    Hand handTom = new Hand(new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.DEUX,Couleur.PIQUE),new Carte(Index.DAME,Couleur.TREFLE),new Carte(Index.DAME,Couleur.CARREAU),new Carte(Index.SEPT,Couleur.PIQUE));
    Hand handJack = new Hand(new Carte(Index.DEUX,Couleur.TREFLE),new Carte(Index.DEUX,Couleur.CARREAU),new Carte(Index.DAME,Couleur.PIQUE),new Carte(Index.DAME,Couleur.COEUR),new Carte(Index.SEPT,Couleur.COEUR));
    Hand handJohn = new Hand(new Carte(Index.SEPT,Couleur.COEUR),new Carte(Index.QUATRE,Couleur.PIQUE),new Carte(Index.DAME,Couleur.TREFLE),new Carte(Index.VALET,Couleur.CARREAU),new Carte(Index.HUIT,Couleur.PIQUE));
    Poker game = new Poker();


    @Test
    void registerPlayers() {
        game.registerPlayers(tom,jack,john);
        assertEquals(3,game.getPlayersRegistered().size());


    }

    @Test
    void start() {
        assertEquals(52,game.getDeck().size());
        game.registerPlayers(tom,jack,john);
        game.start();
        assertEquals(37,game.getDeck().size());
    }

    @Test
    void getWinner(){
        tom.setHand(handTom);
        jack.setHand(handJack);
        john.setHand(handJohn);
        game.registerPlayers(tom,jack,john);
        assertEquals(3,game.getPlayersRegistered().size());
        assertEquals(2,game.getWinner().size());
        assertTrue(game.getWinner().contains(tom) && game.getWinner().contains(jack));
    }
}