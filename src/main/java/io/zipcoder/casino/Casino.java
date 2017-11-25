package io.zipcoder.casino;


public class Casino {

    //public Games games;
    private enum Games{BLACKJACK, CRAPS, GOFISH, EXIT}
    private String playerName;
    private Player player;

    public void start() {

        playerName=Console.getStringInput("Please enter your name");
        player=new Player(playerName, 10000, true);
        for(Games game: Games.values())
            System.out.print(" {"+game+"} ");
        String userInput="";
        do {
            for(Games game: Games.values())
                System.out.print(" {"+game+"} ");
            try {
                userInput = Console.getStringInput("\nEnter the name of the game you would like to play: ");
                Games gameSelection = Games.valueOf(userInput);
                gameSelection(gameSelection);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid Choice");
            }
        }while(!"Exit".equalsIgnoreCase(userInput));


    }

    private void gameSelection(Games userInput){

        switch(userInput){
            case CRAPS: break;
            case BLACKJACK: playBlackJack();
                break;
            case GOFISH: playGoFish();
                break;
            case EXIT: System.console().flush();
            break;

        }
    }

    private void playBlackJack() {
        BlackJack blackJack=new BlackJack();
        //todo setup bank for player
        BlackJackGambler blackJackGambler=new BlackJackGambler(player, 10000);
        blackJack.play(blackJackGambler);
    }

    private void playGoFish() {
        GoFish goFish=new GoFish();
        GoFishPlayer goFishPlayer=new GoFishPlayer(player);
        goFish.play(goFishPlayer);
    }
}
