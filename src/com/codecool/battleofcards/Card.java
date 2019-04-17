package com.codecool.battleofcards;

class Card {

    private int id;
    private int firstStat;
    private int secondStat;
    private int thirdStat;
    private int fourthStat;


    public Card(int id, int firstStat, int secondStat, int thirdStat, int fourthStat) {
        this.id = id;
        this.firstStat = firstStat;
        this.secondStat = secondStat;
        this.thirdStat = thirdStat;
        this.fourthStat = fourthStat;
    }

    public Integer getId() {
        return id;
    }

    public Integer getFirstStat() {
        return firstStat;
    }

    public Integer getSecondStat() {
        return secondStat;
    }

    public Integer getThirdStat() {
        return thirdStat;
    }

    public Integer getFourthStat() {
        return fourthStat;
    }

    public int getStat(int choice) {

        switch (choice) {
            case (1):
                return firstStat;
            case (2):
                return secondStat;
            case (3):
                return thirdStat;
            case (4):
                return fourthStat;
        }
        return 0;
    }

    public String toString() {

        return id + " " + firstStat + " " + secondStat + " " + thirdStat + " " + fourthStat;
    }
}