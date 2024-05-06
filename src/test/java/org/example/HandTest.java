package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HandTest {
    Hand handNothing = new Hand (new Carte(Index.NEUF,Couleur.COEUR),new Carte(Index.NEUF,Couleur.PIQUE),new Carte(Index.VALET,Couleur.TREFLE),new Carte(Index.DIX,Couleur.TREFLE),new Carte(Index.HUIT,Couleur.PIQUE));
    Hand handNothing2 = new Hand (new Carte(Index.NEUF,Couleur.COEUR),new Carte(Index.NEUF,Couleur.PIQUE),new Carte(Index.CINQ,Couleur.TREFLE),new Carte(Index.HUIT,Couleur.TREFLE),new Carte(Index.SEPT,Couleur.PIQUE));
    Hand handOnePair = new Hand (new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.ROI,Couleur.TREFLE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handTwoPair = new Hand (new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.SIX,Couleur.CARREAU),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handTwoPair2 = new Hand (new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.SIX,Couleur.CARREAU),new Carte(Index.QUATRE,Couleur.PIQUE));
    Hand handBrelan = new Hand (new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.DEUX,Couleur.PIQUE),new Carte(Index.DEUX,Couleur.TREFLE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handQuinte= new Hand(new Carte(Index.QUATRE,Couleur.COEUR),new Carte(Index.DEUX,Couleur.CARREAU),new Carte(Index.CINQ,Couleur.PIQUE),new Carte(Index.SIX,Couleur.TREFLE),new Carte(Index.TROIS,Couleur.PIQUE));
    Hand handCouleur = new Hand(new Carte(Index.HUIT,Couleur.COEUR),new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.CINQ,Couleur.COEUR),new Carte(Index.SIX,Couleur.COEUR),new Carte(Index.ROI,Couleur.COEUR));
    Hand handQuinteFlush = new Hand(new Carte(Index.DEUX,Couleur.COEUR),new Carte(Index.TROIS,Couleur.COEUR),new Carte(Index.QUATRE,Couleur.COEUR),new Carte(Index.CINQ,Couleur.COEUR),new Carte(Index.SIX,Couleur.COEUR));
    Hand handQuinteFlush2 = new Hand(new Carte(Index.SEPT,Couleur.COEUR),new Carte(Index.QUATRE,Couleur.COEUR),new Carte(Index.TROIS,Couleur.COEUR),new Carte(Index.CINQ,Couleur.COEUR),new Carte(Index.SIX,Couleur.COEUR));

    Hand getHandQuinteFlushRoyal = new Hand(new Carte(Index.DIX,Couleur.CARREAU),new Carte(Index.VALET,Couleur.CARREAU),new Carte(Index.DAME,Couleur.CARREAU),new Carte(Index.ROI,Couleur.CARREAU),new Carte(Index.AS,Couleur.CARREAU));
    Hand handSquare = new Hand(new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.VALET,Couleur.TREFLE),new Carte(Index.VALET,Couleur.CARREAU),new Carte(Index.SIX,Couleur.CARREAU));
    Hand handFull = new Hand(new Carte(Index.VALET,Couleur.COEUR),new Carte(Index.VALET,Couleur.PIQUE),new Carte(Index.VALET,Couleur.TREFLE),new Carte(Index.SIX,Couleur.COEUR),new Carte(Index.SIX,Couleur.CARREAU));
    @Test
    void compareTo() {
        assertTrue(handBrelan.compareTo(handTwoPair2)>0);
        assertTrue(handTwoPair2.compareTo(handTwoPair)>0);
        assertTrue(handQuinteFlush2.compareTo(handQuinteFlush)>0);
        assertTrue(handQuinte.compareTo(handCouleur)<0);
        assertTrue(getHandQuinteFlushRoyal.compareTo(handQuinteFlush)>0);
        assertTrue(handNothing2.compareTo(handNothing)<0);
    }

    @Test
    void changeCard(){
        assertEquals(Index.VALET,handFull.getHandPlayed().getFirst().getIndex());
        assertEquals(Couleur.COEUR,handFull.getHandPlayed().getFirst().getCouleur());
        handFull.changeCard(1,new Carte(Index.AS,Couleur.CARREAU));
        assertEquals(Index.AS,handFull.getHandPlayed().getFirst().getIndex());
        assertEquals(Couleur.CARREAU,handFull.getHandPlayed().getFirst().getCouleur());
    }





}