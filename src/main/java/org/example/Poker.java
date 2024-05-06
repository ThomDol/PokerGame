package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Poker {
    private Deck deck;
    private List<Player> playersRegistered=new ArrayList<>();
    private int numberOfCardByHand=5;

    private int pot;



    public Poker (){
        Deck newDeck = new Deck();
        newDeck.shuffle();
        this.deck=newDeck;
        this.pot=0;

    }

    public void setPot(int pot) {
        this.pot = pot;
    }

    public int getPot() {
        return pot;
    }

    public Deck getDeck() {
        return deck;
    }

    public List<Player> getPlayersRegistered() {
        return playersRegistered;
    }

    public List<Player> getWinner(){
        List<Player> winners= new ArrayList<>();
        winners.add(this.playersRegistered.getFirst());
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

    /*public List<Player> getWinners() {
    List<Player> winners = new ArrayList<>();
    List<Player> players = new ArrayList<>(this.playersRegistered);
    Collections.sort(players, Comparator.comparing(Player::getHand).reversed());
    Player maxHandPlayer = players.get(0);
    for (Player player : players) {
        if (player.getHand().compareTo(maxHandPlayer.getHand()) == 0) {
            winners.add(player);
        } else {

            break;
        }
    }
    return winners;
}*/

    public void winnerBenefit() {
        if(this.getWinner().size()==1){
            this.getWinner().get(0).setMoney(this.getWinner().get(0).getMoney()+getPot());
        }
    }

    public void displayHands(){
        for(Player player: this.playersRegistered){
           Main.LOGGER.trace(player.getName()+" : "+player.getHand().toString());
        }
    }

    public void registerPlayers (Player ...players){
        this.playersRegistered.addAll(Arrays.asList(players));
    }

    public void start() {
        for (Player player : this.playersRegistered) {
            Hand hand = new Hand();
            for (int i = 1; i <= numberOfCardByHand; i++) {
                hand.addCard(deck.dealOneCard());
                player.setHand(hand);}
                player.setBet(5,this);
        }
    }


    public boolean areBetEqual(List<Player> players){
        List<Integer> bets = new ArrayList<>();
        for (Player player : players){
            bets.add(player.getBet());
        }
        for(Integer num : bets){
            if(Collections.max(bets)!=num){return false;}
        }
        return true;
    }

    public void end(){
        for (Player player:this.playersRegistered){
            this.deck.addCarte(player.getHand());
        }
        this.deck.shuffle();

    }







}
