package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    Poker game = new Poker();

    @Test
    void getMoney() {
        Player tom = new Player("Tom",100);
        tom.setBet(15,game);
        assertEquals(85,tom.getMoney());
        assertEquals(15,game.getPot());

    }

    @Test
    void bet() {
        Player paul = new Player("Paul",200);
        paul.setBet(25,game);
        assertEquals(175,paul.getMoney());
        assertEquals(25,game.getPot());

    }
}