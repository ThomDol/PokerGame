package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Deck {
    Random random = new Random();
    private List<Carte> deck=new ArrayList<>();
    private Couleur [] couleurs = {Couleur.PIQUE,Couleur.COEUR,Couleur.TREFLE,Couleur.CARREAU};
    private final Index [] listIndex = {Index.DEUX,Index.TROIS,Index.QUATRE,Index.CINQ,Index.SIX,Index.SEPT,Index.HUIT,Index.NEUF,Index.DIX,Index.VALET,Index.DAME, Index.ROI,Index.AS};
    public Deck (){
        for(Couleur couleur : couleurs){
            for(Index index:listIndex){
                this.deck.add(new Carte(index,couleur));}}}

    public List<Carte> getDeck() {
        return deck;
    }

    public void addCarte(Hand hand){
        for (Carte carte:hand.getHandPlayed()){
            this.deck.add(carte);
        }
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

    public List<Carte> shuffle (){
        Collections.shuffle(this.deck);
        return this.deck;
    }

    public Carte dealOneCard (){
        Carte cardDealt=new Carte();
        int randomIndex = random.nextInt(this.size());
        cardDealt=this.deck.get(randomIndex);
        this.deck.remove(randomIndex);
        return cardDealt;
    }


}