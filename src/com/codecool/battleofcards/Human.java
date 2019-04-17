package com.codecool.battleofcards;

class Human extends Player {

    View input;
    

    public Human(String name) {

        input = new View();
        super.setName(name);
    }

    public int chooseStatToPlay() {
        
        return Integer.parseInt(input.getInput("Enter stat: "));
    }

    public void addCard(Card card) {
        getPile().addCardToPile(card);
    }
}