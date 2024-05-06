package org.example;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main (String[] args){
        Scanner clavier = new Scanner(System.in);

        Poker game = new Poker();
        game.registerPlayers(new Player("Tom"),new Player("John"),new Player("Franck"));
        game.start();
        game.displayHands();
        for (int i = 0;i<game.getPlayersRegistered().size();i++){
            System.out.println(game.getPlayersRegistered().get(i).getName()+", voulez vous changer de cartes ? oui ou non");
            String reponse= clavier.nextLine();
            if(reponse.equalsIgnoreCase("oui")){
                System.out.println("Une, deux, ou trois cartes ?");
                int number= clavier.nextInt();
                for (int j=0;j<number;j++){
                    System.out.println("Quelle carte, donnez son numéro ");
                    int repNum = clavier.nextInt();
                    game.getPlayersRegistered().get(i).getHand().changeCard(repNum,game.getDeck().dealOneCard());
                }
                clavier.nextLine();
            }

        }
        game.displayHands();
        System.out.println("Winner : "+game.getWinner().getName());
    }




}


