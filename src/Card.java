public class Card {

    private String suit;
    private int rank;

    public Card(){
        this.suit = "";
        this.rank = 0;
    }

    public Card(String suit){
        this.suit = suit;
        this.rank = 1;
    }
    public Card(String suit, int rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public boolean isSameSuit(Card other) {
        // returns true if the suits of this card and other are the same
        return this.suit.equals(other.suit);
    }

    public String findFaceValue() {
        // returns the face value of the card as a String
        return switch (rank) {
            case 1 -> "Ace";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Jack";
            case 12 -> "Queen"; 
            case 13 -> "King";
            default -> "";
        };
    }

    public int findCardValue() {
        // returns the value of the card as an integer
        return rank <= 10 ? rank : 10;
    }

    public boolean isGreaterThan(Card other) {
        // returns true if this card is greater than other
        return this.rank > other.rank;
    }   

    public boolean equals(Card other) {
        // returns true if this card is equal to other
        return this.rank == other.rank;
    }   

    public String toString() {
        return findFaceValue() + " of " + suit;
    }
}
