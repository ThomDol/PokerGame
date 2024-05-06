package org.example;

public class Player {

    private String name;
    private Hand hand;
    private int money;

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

    public void bet(int amount, Poker game){
        this.money-=amount;
        game.setPot(game.getPot()+amount);
    }






}
