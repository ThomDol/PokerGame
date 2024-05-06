package org.example;

import java.util.Objects;

public class Index implements Comparable<Index>{
    public static final Index AS = new Index("As", 14);
    public static final Index DEUX = new Index("Deux", 2);
    public static final Index TROIS = new Index("Trois", 3);
    public static final Index QUATRE = new Index("Quatre", 4);
    public static final Index CINQ = new Index("Cinq", 5);
    public static final Index SIX = new Index("Six", 6);
    public static final Index SEPT = new Index("Sept", 7);
    public static final Index HUIT = new Index("Huit", 8);
    public static final Index NEUF = new Index("Neuf", 9);
    public static final Index DIX = new Index("Dix", 10);
    public static final Index VALET = new Index("Valet", 11);
    public static final Index DAME = new Index("Dame", 12);
    public static final Index ROI = new Index("Roi", 13);

    private String name;
    private int value;

    public Index(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Index index = (Index) o;
        return value == index.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }


    public String toString(){

        return this.name;
    }

    @Override
    public int compareTo(Index other) {
        int diff =  this.getValue()-other.getValue();
        if (diff<0){return -1;}
        else if(diff==0){return 0;}
        else {return 1;}

    }
}