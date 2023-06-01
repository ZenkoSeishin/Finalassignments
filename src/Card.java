class Card { //klassen Card
    private String suit;
    private String value;

    public Card(String suit, String value) { //konstruktor som deklarerar värdena för suit och value
        this.suit = suit;
        this.value = value;
    }

    public int getValue() { //kollar när Ace ska vara 1 eller 10
        if (value.equals("Ace")) {
            return 1;
        } else if (value.equals("King") || value.equals("Queen") || value.equals("Jack")) {
            return 10;
        } else {
            return Integer.parseInt(value);
        }
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}