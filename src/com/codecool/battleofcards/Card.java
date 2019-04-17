package com.codecool.battleofcards;

class Card {

    private int id;
    private int firstStat;
    private int secondStat;
    private int thirdStat;
    private int fourthStat;
    private Pile containingPile;

    public Card(int id, int firstStat, int secondStat, int thirdStat, int fourthStat) {
        this.id = id;
        this.firstStat = firstStat;
        this.secondStat = secondStat;
        this.thirdStat = thirdStat;
        this.fourthStat = fourthStat;
    }

    public int getId() {
        return id;
    }

    public Pile getContainingPile() {
        return containingPile;
    }

    public void setContainingPile(Pile containingPile) {
        this.containingPile = containingPile;
    }

    public int getFirstStat() {
        return firstStat;
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

    // public void moveToPile(Pile destPile) {
    // this.getContainingPile().getCards().remove(this);
    // destPile.addCard(this);
    // }
}