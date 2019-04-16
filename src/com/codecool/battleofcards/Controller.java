package com.codecool.battleofcards;


class Controller {
    private View view = new View();
    private Game game = new Game();
    
    
    public void runGame(){
        String selectionOfMenu = "";
        do{
            view.displayMenu();
            view.displayMessage(view.validateSelectionOfMenu(selectionOfMenu));

            selectionOfMenu = view.getInput("Selection: ");
            switch (selectionOfMenu) {
                case "1":
                    startGame();
                    break;
                case "2":
                    System.out.println("You picked option 2");
                    break;
                case "3":
                    System.out.println("Closed correctly.");
                    break;
            }
        }while(view.validateSelectionOfMenu(selectionOfMenu));
        
    }

    public void startGame() {
        String typeOfGame = "";
        do{
            view.displayTypeOfGame();
            view.displayMessage(view.validateTypeOfGameSelection(typeOfGame));
            
            typeOfGame = view.getInput("Type of game: ");
            switch (typeOfGame) {
                case "1":

                    game.createPlayers();
                    break;
                case "2":
                    System.out.println("You picked option 2");
                    break;
                case "3":
                    runGame();
                    break;
            }
        }while(view.validateTypeOfGameSelection(typeOfGame));
        
    }

    
}