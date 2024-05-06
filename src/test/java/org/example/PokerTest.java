package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerTest {


    Hand handTom = new Hand(new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.DEUX,Couleur.PIQUE),new Carte(Index.DAME,Couleur.TREFLE),new Carte(Index.DAME,Couleur.CARREAU),new Carte(Index.SEPT,Couleur.PIQUE));
    Hand handJack = new Hand(new Carte(Index.DEUX,Couleur.TREFLE),new Carte(Index.DEUX,Couleur.CARREAU),new Carte(Index.DAME,Couleur.PIQUE),new Carte(Index.DAME,Couleur.COEUR),new Carte(Index.SEPT,Couleur.COEUR));
    Hand handJohn = new Hand(new Carte(Index.SEPT,Couleur.COEUR),new Carte(Index.QUATRE,Couleur.PIQUE),new Carte(Index.DAME,Couleur.TREFLE),new Carte(Index.VALET,Couleur.CARREAU),new Carte(Index.HUIT,Couleur.PIQUE));

    Hand handBrelan = new Hand (new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.DEUX,Couleur.PIQUE),new Carte(Index.DEUX,Couleur.TREFLE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handQuinte= new Hand(new Carte(Index.QUATRE,Couleur.COEUR),new Carte(Index.DEUX,Couleur.CARREAU),new Carte(Index.CINQ,Couleur.PIQUE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handCouleur = new Hand(new Carte(Index.HUIT,Couleur.COEUR),new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.CINQ,Couleur.COEUR),new Carte(Index.SIX,Couleur.COEUR),new Carte(Index.ROI,Couleur.COEUR));


    @Test
    void registerPlayers() {
        Poker game = new Poker();
        Player tom=new Player("Tom",100);
        Player jack = new Player("jack",100);
        Player john = new Player("john",100);
        game.registerPlayers(tom,jack,john);
        assertEquals(3,game.getPlayersRegistered().size());


    }

    @Test
    void start() {
        Poker game = new Poker();
        Player tom=new Player("Tom",100);
        Player jack = new Player("jack",100);
        Player john = new Player("john",100);
        //Pot à 0 avant de commencer et jeu de 52 cartes (pas encore distribuées)
        assertEquals(0,game.getPot());
        assertEquals(52,game.getDeck().size());
        game.registerPlayers(tom,jack,john);
        game.start();
        //début de la partie, chacun a 5 cartes, et chacun mise 5
        assertEquals(15,game.getPot());
        assertEquals(37,game.getDeck().size());
        game.winnerBenefit();
        assertEquals(110,game.getWinner().get(0).getMoney());
    }

    @Test
    void end(){
        Poker game = new Poker();
        Player tom=new Player("Tom",100);
        Player jack = new Player("jack",100);
        Player john = new Player("john",100);
        game.registerPlayers(tom,jack,john);
        game.start();
        game.end();
        assertEquals(52,game.getDeck().size());

    }

    @Test
    void getWinner(){
        Poker game = new Poker();
        Player tom=new Player("Tom",100);
        Player jack = new Player("jack",100);
        Player john = new Player("john",100);
        //tom et jack avec 2 mains égales et john en dessous
        tom.setHand(handTom);
        jack.setHand(handJack);
        john.setHand(handJohn);
        game.registerPlayers(tom,jack,john);
        // 2 gagnants
        assertEquals(2,game.getWinner().size());
        assertTrue(game.getWinner().contains(tom) && game.getWinner().contains(jack));
        // Nouvelle partie avec mise
        tom.setHand(handBrelan);
        jack.setHand(handQuinte);
        john.setHand(handCouleur);
        tom.bet(15,game);
        jack.bet(15,game);
        john.bet(15,game);
        assertEquals(45,game.getPot());
        assertEquals(1,game.getWinner().size());
        game.winnerBenefit();
        assertEquals(john,game.getWinner().get(0));
        assertEquals(130,john.getMoney());
        assertEquals(85,tom.getMoney());



    }
}