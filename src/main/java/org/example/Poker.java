package org.example;

import java.util.*;


public class Poker {
    private Deck deck;
    private List<Player> playersRegistered=new ArrayList<>();
    private int numberOfCardByHand=5;

    private HashMap<String,Integer> statGameWinner = new HashMap<>();

    private int pot;



    public Poker (){
        Deck newDeck = new Deck();
        newDeck.shuffle();
        this.deck=newDeck;
        this.pot=0;
        this.statGameWinner.clear();

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

    public void setStatGame(Hand hand){
        String name = hand.nameOfHand().split("/")[1];
        if(statGameWinner.containsKey(name)){
            int count = statGameWinner.get(name);
            statGameWinner.put(name,count+1);}
        else{statGameWinner.put(name,1);}
    }

    public HashMap<String,Integer> getStatGame(){
        return this.statGameWinner;
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
                //player.setBet(5,this);
        }
    }


    public void end(){
        for (Player player:this.playersRegistered){
            this.deck.addCarte(player.getHand());
            player.getHand().getHandPlayed().clear();
        }
        this.deck.shuffle();

    }

    public void party(){
        this.start();
        for(Player winners:this.getWinner()){
        this.setStatGame(winners.getHand());}
        this.end();
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







}
