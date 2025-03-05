public class LeaderBoard {
    private int gameNumber;
    private int userWin;
    private int computerWin;
    private int draw;

    public LeaderBoard(){
        this.gameNumber = 0;
        this.userWin = 0;
        this.computerWin = 0;
        this.draw = 0;
    }

    //setters
    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public void setUserWin(int userWin) {
        this.userWin = userWin;
    }

    public void setComputerWin(int computerWin) {
        this.computerWin = computerWin;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    //getters
    public int getGameNumber() {
        return gameNumber;
    }

    public int getUserWin() {
        return userWin;
    }

    public int getComputerWin() {
        return computerWin;
    }

    public int getDraw() {
        return draw;
    }

    //toString
    public String toString() { // returns the complete leader board
        return  "\n--------------------------------\n" +
                "Leader Board Summary\n" +
                "--------------------------------\n" +  
                "Games played: " + gameNumber + "\n" +
                "User wins: " + userWin + "\n" +
                "Computer wins: " + computerWin + "\n" +
                "Draws: " + draw + "\n" +
                "--------------------------------\n\n" + 
                "Thanks for playing! Bye!\n";
    }
}
