package org.example;

import java.util.Objects;

public class Couleur {

    public static final Couleur PIQUE = new Couleur("Pique");
    public static final Couleur COEUR = new Couleur("Coeur");
    public static final Couleur CARREAU = new Couleur("Carreau");
    public static final Couleur TREFLE = new Couleur("Trefle");
    private String name;


    public Couleur (String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Couleur couleur = (Couleur) o;
        return Objects.equals(name, couleur.name);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }




}

