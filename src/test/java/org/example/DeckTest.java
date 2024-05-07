package org.example;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Carte troisCarreau = new Carte(Index.TROIS,Couleur.CARREAU);
    Carte deuxPique = new Carte(Index.DEUX,Couleur.PIQUE);





    @org.junit.jupiter.api.Test
    public void size(){
        Deck deck = new Deck();
        assertEquals(52, deck.size());
        assertTrue(deck.contains(troisCarreau));
        assertTrue(troisCarreau.compareTo(deuxPique)>0);

    }

    @org.junit.jupiter.api.Test
    public void shuffle(){
        Deck deck = new Deck();
        assertEquals(deuxPique,deck.getDeck().stream().findFirst().orElse(null));
        deck.shuffle();
        assertNotEquals(deuxPique,deck.getDeck().get(0));
    }

    @org.junit.jupiter.api.Test
    public void dealOneCard(){
        Deck deck = new Deck();
        deck.dealOneCard();
        assertEquals(51, deck.size());
    }

    public void addCarte(){
        Deck deck = new Deck();
        Player tom = new Player("Tom");
        Hand hand = new Hand();
        for (int i = 1; i <= 5; i++) {
            hand.addCard(deck.dealOneCard());
            tom.setHand(hand);}
        assertTrue(deck.size()==37);
        deck.addCarte(tom.getHand());
        assertTrue(deck.size()==52);
    }

}