package com.codecool.battleofcards;

class Card {
    
    private int firtsStat;
    private int secondStat;
    private int thirdStat;
    private int fourthStat;
    private Pile containingPile;


    public Pile getContainingPile() {
        return containingPile;
    }

    public void setContainingPile(Pile containingPile) {
        this.containingPile = containingPile;
    }

    public int getFirstStat() {
        return firtsStat;
    }

    public int getSecondStat() {
        return secondStat;
    }

    public int getThirdStat() {
        return thirdStat;
    }

    public int getFourthStat() {
        return fourthStat;
    }

    public void moveToPile(Pile destPile) {
        this.getContainingPile().getCards().remove(this);
        destPile.addCard(this);
    }
}