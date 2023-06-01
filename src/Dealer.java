class Dealer extends Player { //Dealer klassen har liknar Player klassen
    public void play(Deck deck, boolean showAllCards) { //metoden som kollar på värdet som dealern har
        while (getHandValue() < 17) {
            Card card = deck.drawCard();
            if (card != null) {
                addCard(card);
            } else {
                System.out.println("Deck is empty!");
                break;
            }
        }
        System.out.println("\nDealer's hand:");
        showHand(showAllCards);
    }
}