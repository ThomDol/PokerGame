package org.example;

import org.junit.Test;

import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Carte troisCarreau = new Carte(Index.TROIS,Couleur.CARREAU);
    Carte deuxPique = new Carte(Index.DEUX,Couleur.PIQUE);
    Deck deck = new Deck();




    @org.junit.jupiter.api.Test
    public void size(){
        assertEquals(52, deck.size());
        assertTrue(deck.contains(troisCarreau));
        assertTrue(troisCarreau.compareTo(deuxPique)>0);

    }

    @org.junit.jupiter.api.Test
    public void shuffle(){
        assertEquals(deuxPique,deck.getDeck().stream().findFirst().orElse(null));
        deck.shuffle();
        assertNotEquals(deuxPique,deck.getDeck().get(0));
    }

    @org.junit.jupiter.api.Test
    public void dealOneCard(){
        deck.dealOneCard();
        assertEquals(51, deck.size());
    }

}