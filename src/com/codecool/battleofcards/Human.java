package com.codecool.battleofcards;

import java.util.concurrent.TimeUnit;
import java.util.Arrays;


class Human extends Player {

    View input;
    

    public Human(String name) {

        input = new View();
        super.setName(name);
    }

    public int chooseStatToPlay() throws InterruptedException {

        boolean repeat = true;
        String[] validOptions = new String[] {"1", "2", "3", "4"};
        String output = "";

        while (repeat) {
            output = input.getInput("\nEnter stat: ");
            if (Arrays.asList(validOptions).contains(output)) {
                repeat = false;
            } else {
                input.print("Choose which statistic to play with: 1, 2, 3 or 4");
                TimeUnit.SECONDS.sleep(2);
            }
        }  
        return Integer.parseInt(output);
    }

    public void addCard(Card card) {

        getPile().addCardToPile(card);
    }
}