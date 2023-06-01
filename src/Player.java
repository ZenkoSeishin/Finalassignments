import java.util.ArrayList;
import java.util.List;

class Player { //klassen player
    protected List<Card> hand;

    public Player() { //konstruktorn
        hand = new ArrayList<>();
    }

    //metoder
    public void addCard(Card card) {
        hand.add(card);
    }


    public void showHand(boolean showAllCards) {}
//getters setters
    public int getHandValue() {
        int value = 0;
        int numAces = 0;

        for (Card card : hand) {
            value += card.getValue();
            if (card.getValue() == 1) {
                numAces++;
            }
        }

        while (value <= 11 && numAces > 0) {
            value += 10;
            numAces--;
        }

        return value;
    }
    }
