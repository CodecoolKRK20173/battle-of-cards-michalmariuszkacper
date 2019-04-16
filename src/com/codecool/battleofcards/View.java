package com.codecool.battleofcards;
import java.util.Scanner;
import java.lang.System;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class View {   


    public void displayMenu() {
        System.out.print("\033[H\033[2J");
        System.out.println("MAIN MENU:\n" + "1. Start game\n" + "2. Edit cards\n" + "3. End game\n");
    }

    public void displayTypeOfGame() {
        System.out.print("\033[H\033[2J");
        System.out.println("TYPE OF GAME:\n" + "1. Human vs human [H H]\n" + "2. Human vs Computer [H A]\n" + "3. Back to main menu\n");
    }

    public String getInput(String communique) {
        String data = null;
        BufferedReader sw = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(communique);
        while (true) {
            try {
                data = sw.readLine();
                if (data.length() > 0) {
                    break;
                }
            } catch (IOException e) {
                System.out.println("IOExeption: " + e);
            }
        }
        return data;
    }

    public void displayMessage(boolean validSelection){
        if(validSelection){
            System.out.println("Selection is not allowed");
        }
    }

    public boolean validateTypeOfGameSelection(String typeOfGame) {
        List<String> selections = new ArrayList<>(Arrays.asList("1", "2", "3"));
        if (typeOfGame == "") {
            return false;
        } else if (!selections.contains(typeOfGame.toUpperCase())) {
            return true;
        }
        return false;
    }

    public boolean validateSelectionOfMenu(String selectionOfMenu) {
        List<String> selections = new ArrayList<>(Arrays.asList("1", "2", "3"));
        if (selectionOfMenu == "") {
            return false;
        } else if (!selections.contains(selectionOfMenu)) {
            return true;
        }
        return false;
    }

    

    
}