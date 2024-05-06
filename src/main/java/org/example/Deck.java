package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {

    private List<Carte> deck=new ArrayList<>();
    private Couleur [] couleurs = {Couleur.PIQUE,Couleur.COEUR,Couleur.TREFLE,Couleur.CARREAU};
    private static  final Index [] LISTINDEX = {Index.DEUX,Index.TROIS,Index.QUATRE,Index.CINQ,Index.SIX,Index.SEPT,Index.HUIT,Index.NEUF,Index.DIX,Index.VALET,Index.DAME, Index.ROI,Index.AS};
    public Deck (){
        for(Couleur couleur : couleurs){
            for(Index index:LISTINDEX){
                this.deck.add(new Carte(index,couleur));}}}

    public List<Carte> getDeck() {
        return deck;
    }

    public void addCarte(Hand hand){
        this.deck.addAll(hand.getHandPlayed());
    }


    public int size(){
        return this.deck.size();
    }



    public boolean contains (Carte carte2){
        for(Carte carte:this.deck){
            if (carte.equals(carte2)){return true;}
        }
        return false;
    }

    public void shuffle (){
        Collections.shuffle(this.deck);
    }

    public Carte dealOneCard (){

        Carte cardDealt=this.deck.getFirst();
        this.deck.removeFirst();
        return cardDealt;
    }


}