import java.util.Scanner;

public class GameOf21 extends CardGame{
    Scanner scanner = new Scanner(System.in);

    private Player user;
    private Player computer;
    private LeaderBoard record;

    public GameOf21(String user){
        super("Game of 21");
        this.user = new Player();
        this.user.setName(user);
        this.computer = new Player();
        this.record = new LeaderBoard();
    }
    

    @Override
    public void startGame(){
        printTitle();
        printInstructions();
        playGame();
    }

    @Override
    protected void printTitle() {
        System.out.println("How to play Game of 21");
        System.out.println("----------------------------------------");
    }

    @Override
    protected void printInstructions() {
        System.out.println("The objective of the game is getting the closest to 21 without going over. Each player is dealt with 2 cards. The\n" + //
                        "user can then decide whether to draw another card. The computer does the same.\n" + //
                        "Face cards have a value of 10 and Aces can be high or low (that is, 11 points or 1 point) depending on achieving\n" + //
                        "the closest score to 21 without going over.\n" + //
                        "After 2 or more cards have been drawn by each player, the score is totaled, and a winner is declared.");
    }

    @Override
    protected void playGame() {
        record.setGameNumber(record.getGameNumber() + 1); //increase by one the number of the game

        user.draw(dealCard()); // get 2 cards from the deck for the user
        user.draw(dealCard());

        computer.draw(dealCard()); // get 2 cards from the deck for the computer
        computer.draw(dealCard());

        while (true) {

            // prints how many cards the user have
            System.out.println(user.getName() + " has " + user.getHand().size() + " cards:");
            for (int i = 0; i < user.getHand().size(); i++) {
                System.out.println((i + 1) + ") " + user.getHand().get(i));
            }

            System.out.println(user.totalHand());

            System.out.println();

            // prints how many cards the computer have
            System.out.println(computer.getName() + " has " + computer.getHand().size() + " cards:");
            for (int i = 0; i < computer.getHand().size(); i++) {
                System.out.println((i + 1) + ") " + computer.getHand().get(i));
            }

            System.out.println(computer.totalHand());

            // if user gets 21 and computer doesn't
            if (user.totalHand() == 21 && computer.totalHand() != 21) {
                record.setUserWin(record.getUserWin() + 1);
                break;
            }
            // if computer gets 21 and computer doesn't
            if (user.totalHand() != 21 && computer.totalHand() == 21) {
                record.setComputerWin(record.getComputerWin() + 1);
                break;
            }
            // if computer and user get 21
            if (user.totalHand() == 21 && computer.totalHand() == 21) {
                record.setDraw(record.getDraw() + 1);
                break;
            }

            // if user has over 21 computer wins
            if (user.totalHand() > 21) {
                System.out.println("The user has over 21.");
                record.setComputerWin(record.getComputerWin() + 1);
                break;
            }

            // if computer has over 21 user wins
            if (computer.totalHand() > 21) {
                System.out.println("The computer has over 21.");
                record.setUserWin(record.getUserWin() + 1);
                break;
            }

            System.out.println();

            // ask the user if it wants another card
            System.out.print("Do you want another card (Y/N)? ");
            String answer = scanner.next().toLowerCase();

            // if the user wants
            if (answer.equals("y")) {
                user.draw(dealCard());
                if (computer.totalHand() < 17) {
                    computer.draw(dealCard());
                    System.out.println("\n" + computer.getName() + " stands.\n");
                }
            }
            // if the user does not want
            else {
                System.out.println(user.getName() + " stands.");

                // determine who won
                if (user.totalHand() > computer.totalHand()){
                    record.setUserWin(record.getUserWin() + 1);
                } else if (computer.totalHand() > user.totalHand()){
                    record.setComputerWin(record.getComputerWin() + 1);
                } else {
                    record.setDraw(record.getDraw() + 1);
                }

                break;
            }
        }

        printWinner();
        playAgain();
    }

    @Override
    protected void printWinner() {

        System.out.println("-------------------------------");
        System.out.println("Game of 21 Game #" + record.getGameNumber());
        System.out.println("-------------------------------");
        System.out.println(user.getName() + " points: " + record.getUserWin());
        System.out.println(computer.getName() + " points: " + record.getComputerWin());
        System.out.println("-------------------------------");

        // print that the user won if its hand total is higher and if it is not above 21
        if ((user.totalHand() > computer.totalHand() && user.totalHand() <= 21) || computer.totalHand() > 21){
            System.out.println(user.getName() + " wins!");
        }
        // print that the computer won if its hand total is higher and if it is not above 21
        else if ((computer.totalHand() > user.totalHand() && computer.totalHand() <= 21) || user.totalHand() > 21){
            System.out.println(computer.getName() + " wins!");
        }
        // if the game is a draw
        else {
            System.out.println("Game is a draw.");
        }
        System.out.println("-------------------------------\n");
    }

    @Override
    protected void playAgain() {
        // hands empty
        user.emptyHand();
        computer.emptyHand();

        // ask if the user wants to play again
        System.out.print("Play another game (Y/N) ? ");
        String answer = scanner.next().toLowerCase();

        if (answer.equals("y")) playGame();
        else System.out.println(record.toString());
    }
}
