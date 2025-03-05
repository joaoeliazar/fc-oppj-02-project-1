import java.util.ArrayList;
import java.util.Collections;

public abstract class CardGame {

    private String gameType;
    private ArrayList<Card> deck;

    public CardGame(String gameType) {
        this.gameType = gameType;
        this.deck = new ArrayList<>();
        populateDeck();
    }

    public String getGameType() {
        return gameType;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    private void populateDeck(){
        deck.clear();
        // loads an ArrayList<Card> deck with 52 Card objects made up of 4 suits each with 13 ranks
        // once the deck is populated, the helper method shuffle() is called
        for (int i = 0; i < 4; i++) {
            String suit = "";
            if (i == 0) {
                suit = "Hearts";
            } else if (i == 1) {
                suit = "Diamonds";
            } else if (i == 2) {
                suit = "Clubs";
            } else if (i == 3) {
                suit = "Spades";
            }
            for (int rank = 1; rank <= 13; rank++) {
                deck.add(new Card(suit, rank));
            }
        }
        shuffle(deck);
    }

    public Card dealCard(){
        // returns and removes the “top” Card object from the deck
        return deck.remove(0);
    }

    private void shuffle(ArrayList<Card> deck){
        // randomizes the order of the Cards in the deck
        Collections.shuffle(deck);
    }

    public abstract void startGame();
    protected abstract void printTitle();
    protected abstract void printInstructions();
    protected abstract void playGame();
    protected abstract void printWinner();
    protected abstract void playAgain();

}
