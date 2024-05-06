package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PokerTest {

    Player tom=new Player("Tom");
    Player jack = new Player("jack");
    Player john = new Player("john");
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
}