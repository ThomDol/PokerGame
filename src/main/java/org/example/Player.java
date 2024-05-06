package org.example;

public class Player {

    private String name;
    private Hand hand;
    private int money;

    private int bet;

    public Player (String name,int money){
        this.name=name;
        this.money=money;}

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }


    public void setHand(Hand hand) {
        this.hand = hand;
    }

    public void setBet(int amount, Poker game){
        this.bet+=amount;
        this.money-=amount;
        game.setPot(game.getPot()+amount);
    }

    public int getBet(){
        return this.bet;
    }






}
