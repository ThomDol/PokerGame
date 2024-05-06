package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {
    Carte carte = new Carte(Index.CINQ,Couleur.TREFLE);

    @Test
    void testToString() {
        assertEquals("Cinq de Trefle",carte.toString() );
    }
}