package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Carte implements Comparable<Carte>{
    private Couleur couleur;
    private Index index;

    private List<String> listIndex = new ArrayList<>(Arrays.asList("deux","trois","quatre","cinq","six","sept","huit","neuf","dix","valet","dame","roi","as"));




    public Carte(){}
    public Carte(Index index, Couleur couleur){
        this.index=index;
        this.couleur=couleur;

    }

    public Couleur getCouleur() {
        return couleur;
    }

    public Index getIndex() {
        return index;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carte carte = (Carte) o;
        return Objects.equals(couleur, carte.couleur) && Objects.equals(index, carte.index);
    }

    @Override
    public int hashCode() {
        return Objects.hash(couleur, index);
    }

    @Override
    public int compareTo(Carte other) {
        int diff =  this.getIndex().getValue()-other.getIndex().getValue();
        if (diff<0){return -1;}
        else if(diff==0){return 0;}
        else {return 1;}
    }

    public String toString(){
        return this.index.getName()+" de "+this.couleur.getName();
    }



}