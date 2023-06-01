import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Deck {
    private List<Card> cards;

    public Deck() { //konstruktorn
        cards = new ArrayList<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] values = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (String suit : suits) {
            for (String value : values) {
                cards.add(new Card(suit, value));
            }
        }
    }

    public void shuffle() { //metoden som ändrar värdet på korten
        Random random = new Random();
        for (int i = cards.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            Card temp = cards.get(i);
            cards.set(i, cards.get(j));
            cards.set(j, temp);
        }
    }

    public Card drawCard() { // drar kort för att se om det finns kort kvar
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(cards.size() - 1);
    }
}