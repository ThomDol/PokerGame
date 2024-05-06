package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poker {
    private Deck deck;
    private List<Player> playersRegistered=new ArrayList<>();
    private int numberOfCardByHand=5;




    public Poker (){
        Deck deck = new Deck();
        deck.shuffle();
        this.deck=deck;

    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayersRegistered() {
        return playersRegistered;
    }

    public List<Player> getWinner(){
        List<Player> winners= new ArrayList<>();
        winners.add(this.playersRegistered.get(0));
        for (int i = 1;i<this.playersRegistered.size();i++) {
            boolean isBetter = true;
            boolean isEquals = true;
            for (Player winner : winners) {
                if (this.playersRegistered.get(i).getHand().compareTo(winner.getHand()) < 0) {
                    isBetter = false;
                    isEquals=false;
                } else if (this.playersRegistered.get(i).getHand().compareTo(winner.getHand()) == 0) {
                    isBetter = false;
                } else {
                    isEquals = false;
                }
            }
            if (isBetter) {
                winners.clear();
                winners.add(this.playersRegistered.get(i));
            }
            if (isEquals) {
                winners.add(this.playersRegistered.get(i));
            }
        }
            return winners;
    }

    public void displayHands(){
        for(Player player: this.playersRegistered){
            System.out.println(player.getName()+" : "+player.getHand().toString());
        }
    }

    public void registerPlayers (Player ...players){
        for(Player player : players ){
            this.playersRegistered.add(player);
        }
    }

    public void start() {
        for (Player player : this.playersRegistered) {
            Hand hand = new Hand();
            for (int i = 1; i <= numberOfCardByHand; i++) {
                hand.addCard(deck.dealOneCard());
                player.setHand(hand);
            }
        }
    }







}
