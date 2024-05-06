package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PokerTest {

    Hand handNothing = new Hand(new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.QUATRE,Couleur.TREFLE),new Carte(Index.AS,Couleur.CARREAU),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handTom = new Hand(new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.DEUX,Couleur.PIQUE),new Carte(Index.DAME,Couleur.TREFLE),new Carte(Index.DAME,Couleur.CARREAU),new Carte(Index.SEPT,Couleur.PIQUE));
    Hand handJack = new Hand(new Carte(Index.DEUX,Couleur.TREFLE),new Carte(Index.DEUX,Couleur.CARREAU),new Carte(Index.DAME,Couleur.PIQUE),new Carte(Index.DAME,Couleur.COEUR),new Carte(Index.SEPT,Couleur.COEUR));
    Hand handJohn = new Hand(new Carte(Index.SEPT,Couleur.COEUR),new Carte(Index.QUATRE,Couleur.PIQUE),new Carte(Index.DAME,Couleur.TREFLE),new Carte(Index.VALET,Couleur.CARREAU),new Carte(Index.HUIT,Couleur.PIQUE));

    Hand handTwoPair = new Hand (new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.SIX,Couleur.CARREAU),new Carte(Index.TROIS,Couleur.PIQUE));
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
        tom.setHand(handTwoPair);
        jack.setHand(handNothing);
        john.setHand(handCouleur);
        tom.setBet(5,game);
        jack.setBet(5,game);
        john.setBet(5,game);
        assertEquals(15,game.getPot());
        tom.getHand().changeCard(5,new Carte (Index.VALET,Couleur.TREFLE));
        jack.getHand().changeCard(1,new Carte (Index.DAME,Couleur.TREFLE));
        jack.getHand().changeCard(5,new Carte (Index.AS,Couleur.TREFLE));
        List<Player> playersStilOn=game.getPlayersRegistered();
        tom.setBet(10,game);
        playersStilOn.remove(jack);
        jack.setBet(0,game);
        john.setBet(20,game);
        assertFalse(game.areBetEqual(playersStilOn));
        tom.setBet(10,game);
        assertTrue(game.areBetEqual(playersStilOn));
        assertEquals(55,game.getPot());
        game.winnerBenefit();
        assertEquals(tom.getName(),game.getWinner().getFirst().getName());
        assertEquals(130,tom.getMoney());
        assertEquals(75,john.getMoney());



    }
}