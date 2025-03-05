import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;

    public Player() {
        this.name = "Computer";
        this.hand = new ArrayList<>();
    }
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    // getters
    public String getName() {
        return name;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void draw(Card c) {
        this.hand.add(c);
    } // add the card to the hand

    public int totalHand() {
        // returns the total value of the hand as an integer
        int total = 0;
        for (Card c : hand) {
            if (c.findFaceValue().equals("Ace")) {
                total += findAceValue(total);
            } else {
                total += c.findCardValue();
            }
        }
        return total;
    }

    public int findAceValue(int total) {
        // returns 1 if hand is greater than 11 and its value if is less than 11
        if (total + 11 > 21) {
            return 1;
        } else {
            return 11;
        }
    }

    public void emptyHand() {
        // empties the hand
        this.hand.clear();
    }

    public String toString() {
        return name + "'s hand: " + hand;
    }
}
