package com.codecool.battleofcards;

class Ai extends Player {

    public int chooseStatToPlay() {
        
        Card card = super.getPile().getTopCard();
        int choice = 1;
        int firstStatMax = 39;
        int secondStatMax = 44;
        int thirdStatMax = 34;
        int fourthStatMax = 59;
        int curentPercentage = countPercentage(card.getFirstStat(), firstStatMax);
        
        
        if (countPercentage(card.getSecondStat(), secondStatMax) > curentPercentage) {
            curentPercentage = countPercentage(card.getSecondStat(), secondStatMax);
            choice = 2;
        } else if (countPercentage(card.getThirdStat(), thirdStatMax) > curentPercentage) {
            curentPercentage = countPercentage(card.getThirdStat(), thirdStatMax);
            choice = 3;
        } else if (countPercentage(card.getFourthStat(), fourthStatMax) > curentPercentage) {
            curentPercentage = countPercentage(card.getFourthStat(), fourthStatMax);
            choice = 4;
        }
        return choice;
    }

    private int countPercentage(int number, int max) {

        return number / max * 100;
    }

    public void addCard(Card card) {

        getPile().addCardToPile(card);
    }
}