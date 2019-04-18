package com.codecool.battleofcards;

import java.util.List;
import java.util.ArrayList;

class Card {

    private String name;
    private Integer firstStat;
    private Integer secondStat;
    private Integer thirdStat;
    private Integer fourthStat;

    public Card(String name, ArrayList<Integer> abilities) {

        this.name = name;
        this.firstStat = abilities.get(0);
        this.secondStat = abilities.get(1);
        this.thirdStat = abilities.get(2);
        this.fourthStat = abilities.get(3);

    }

    public String getName() {
        return name;
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

        return name + " " + firstStat + " " + secondStat + " " + thirdStat + " " + fourthStat;
    }
}