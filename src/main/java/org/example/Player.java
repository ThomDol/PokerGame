package org.example;

public class Player {

    private String name;
    private Hand hand;

    public Player (){}

    public Player (String name){
        this.name=name;}



    public String getName() {
        return name;
    }

    public Hand getHand() {
        return hand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }






}