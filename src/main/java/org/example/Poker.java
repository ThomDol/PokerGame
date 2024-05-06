package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Poker {
    private Deck deck;
    private List<Player> playersRegistered=new ArrayList<>();
    private int numberOfCardByHand=5;
    private Scanner clavier= new Scanner(System.in);




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

    public Player getWinner(){
        Player winner=this.playersRegistered.get(0);
        for (int i = 1;i<this.playersRegistered.size();i++){
            if(this.playersRegistered.get(i).getHand().compareTo(winner.getHand())>0){
                winner=this.playersRegistered.get(i);}}
        return winner;
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
