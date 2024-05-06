package org.example;

import java.util.*;

public class Hand implements Comparable<Hand> {

    private List<Carte> handPlayed=new ArrayList<>();
    Scanner clavier = new Scanner(System.in);


    public Hand(){}
    public Hand(Carte... cartes){
        for (Carte carte:cartes){
            this.handPlayed.add(carte);
        }
    }

    public List<Carte> getHandPlayed() {
        return handPlayed;
    }
    public void addCard(Carte carte){
        this.handPlayed.add(carte);
    }




    private HashMap<Index, Integer> numberOfSameCard() {
        HashMap<Index, Integer> cardByOccurrence = new HashMap<>();

        for (Carte carte : this.handPlayed) {
            Index currentIndex = carte.getIndex();
            if (cardByOccurrence.containsKey(currentIndex)) {
                int count = cardByOccurrence.get(currentIndex);
                cardByOccurrence.put(currentIndex, count + 1);
            } else {
                cardByOccurrence.put(currentIndex, 1);
            }
        }
        return cardByOccurrence;
    }

    private String sortResult (){
        List<Map.Entry<Index, Integer>> list = new ArrayList<>(this.numberOfSameCard().entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Index, Integer>>() {
            @Override
            public int compare(Map.Entry<Index, Integer> o1, Map.Entry<Index, Integer> o2) {
                int compare =  o2.getValue().compareTo(o1.getValue());
                if (compare ==0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                return compare;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Index, Integer> entry : list) {
            sb.append(String.valueOf(entry.getValue()*entry.getKey().getValue())+"/");
        }
        return sb.toString();
    }

    private Collection<Integer> getOccurencesHand (){
        HashMap<Index,Integer> res = this.numberOfSameCard();
        return res.values();
    }


    private String gotNothing(){
        String score="";
        Collection<Integer> resInt = this.getOccurencesHand();
        if((resInt.stream().filter(elem->elem==1).count()==5) && this.gotQuinte().isEmpty()){
            score="J/"+this.sortResult();
        }
        return score;
    }
    private String gotOnePair (){
        String score="";
        Collection<Integer> resInt = this.getOccurencesHand();
        if ((resInt.stream().filter(elem->elem==2).count()==1) && (resInt.stream().filter(elem->elem==1).count()==3)){
            score="I/"+this.sortResult();
        }
        return score;
    }

    private String gotTwoPair (){
        String score="";
        Collection<Integer> resInt = this.getOccurencesHand();
        if ((resInt.stream().filter(elem->elem==2).count()==2) && (resInt.stream().filter(elem->elem==1).count()==1)){
            score=  "H/"+this.sortResult();
        }
        return score;
    }

    private String gotBrelan (){
        String score="";
        Collection<Integer> resInt = this.getOccurencesHand();
        if ((resInt.stream().filter(elem->elem==3).count()==1) && (resInt.stream().filter(elem->elem==2).count()==0)){
            score="G/"+this.sortResult();
        }
        return score;
    }

    private String gotFull() {
        String score="";
        Collection<Integer> resInt = this.getOccurencesHand();
        if (resInt.stream().filter(elem -> elem == 3).count() == 1 && resInt.stream().filter(elem -> elem == 2).count() == 1 ){
            score= "D/"+this.sortResult();
        }
        return score;
    }

    private String gotSquare(){
        String score="";
        Collection<Integer> resInt = this.getOccurencesHand();
        if( resInt.stream().filter(elem->elem==4).count()==1){
            score="C/"+this.sortResult();
        }
        return score;
    }

    private String gotQuinte() {
        String score="";
        boolean isQuinte = false;
        List <Integer> index = new ArrayList<>();
        for (int i = 0; i < this.handPlayed.size(); i++) {
            index.add(this.handPlayed.get(i).getIndex().getValue());
        }
        Collections.sort(index);
        boolean tempQuinte=true;
        for(int j=0;j < index.size()-1; j++){
            if (index.get(j+1)-index.get(j)!=1){tempQuinte=false;}

        }
        if (tempQuinte){isQuinte=true;}
        if(isQuinte){score="F/"+this.sortResult();};
        return score;
    }

    private String gotColor (){
        String score="";
        boolean isColor=true;
        for (int i = 1;i<this.handPlayed.size();i++){
            if(!this.handPlayed.get(i).getCouleur().equals(this.handPlayed.get(0).getCouleur())){isColor=false;}
        }
        if(isColor){score="E/"+this.sortResult();}
        return score;
    }

    private String gotQuinteFlush(){
        String score="";
        boolean isQuinteFlush=false;
        if (!this.gotQuinte().isEmpty() && !this.gotColor().isEmpty()){isQuinteFlush= true;}
        if(isQuinteFlush){score="B/"+this.sortResult();}
        return score;
    }

    private String gotQuinteFlushRoyal(){
        String score="";
        String [] part = this.gotQuinteFlush().split("/");
       if(!this.gotQuinteFlush().isEmpty() && Integer.parseInt(part[part.length-1])==10 ){score = "A/"+this.sortResult();}
       return score;
    }




    private String nameOfHand(){
        if(!this.gotQuinteFlushRoyal().isEmpty()){return  this.gotQuinteFlushRoyal();}
        else if(!this.gotQuinteFlush().isEmpty()){return this.gotQuinteFlush();}
        else if (!this.gotSquare().isEmpty()) {return this.gotSquare();}
        else if(!this.gotFull().isEmpty()){return this.gotFull();}
        else if (!this.gotColor().isEmpty()){return this.gotColor();}
        else if(!this.gotQuinte().isEmpty()){return this.gotQuinte();}
        else if(!this.gotBrelan().isEmpty()){return this.gotBrelan();}
        else if(!this.gotTwoPair().isEmpty()){return this.gotTwoPair();}
        else if(!this.gotOnePair().isEmpty()){return this.gotOnePair();}
        else {return this.gotNothing();}

    }



    @Override
    public int compareTo(Hand other) {
        String[] parts = this.nameOfHand().split("/");
        String[] otherParts = other.nameOfHand().split("/");
        String firstLetter = parts[0];
        String firstLetterOther = otherParts[0];
        int res = firstLetter.compareTo(firstLetterOther);
        if (res!=0){return -res;}
        else{
            int j = 1;
            while(Integer.parseInt(parts[j])==(Integer.parseInt(otherParts[j])) && j<(Integer.min(parts.length,otherParts.length)-1))
            {j++;}
            return Integer.parseInt(parts[j])-Integer.parseInt(otherParts[j]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hand hand = (Hand) o;
        return Objects.equals(handPlayed, hand.handPlayed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(handPlayed);
    }


    public String toString(){
        StringBuilder handToString = new StringBuilder();
        for(Carte carte:this.handPlayed){
            handToString.append(carte.toString()+"-");
        }
        return handToString.toString();
    }

    public void changeCard (int index,Carte newCarte){
        this.handPlayed.set(index-1,newCarte);
    }
}