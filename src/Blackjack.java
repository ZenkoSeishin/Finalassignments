
import java.util.Scanner;
import java.util.InputMismatchException;

public class Blackjack { //klassen blackjack
    private Deck deck;
    private Dealer dealer;
    private Player player;

    private Player cheater;

    public Blackjack() { //konstruktor

        deck = new Deck(); //deklarerar variabler
        dealer = new Dealer();
        player = new Player();
       cheater = new Cheat();
    }

    public void playGame(boolean showOpponentCards) { //metoden som kör spelets innehåll
        deck.shuffle();

        // Deal initial cards
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());
        player.addCard(deck.drawCard());
        dealer.addCard(deck.drawCard());

        // Show initial hands
        player.showHand(false);
        if (showOpponentCards) {
            dealer.showHand(true);
        } else {
            System.out.println("\nDealer's hand:");
            System.out.println("Card 1: [Hidden]");
            System.out.println("Card 2: " + dealer.hand.get(1));
        }

        // Player's turn
        while (player.getHandValue() < 21) {
            System.out.println("\n1. Hit");
            System.out.println("2. Stand");
            System.out.print("Choose an option: ");
            Scanner scanner = new Scanner(System.in);
//kollar user input för att se vad de valt för val när det kommer till att fuska eller inte
            try {
                int choice = scanner.nextInt();

                if (choice == 1) {
                    Card card = deck.drawCard();
                    if (card != null) {
                        player.addCard(card);
                        cheater.showHand(false);
                    } else {
                        System.out.println("Deck is empty!");
                        break;
                    }
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println("Invalid choice! Please choose again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }

        // Dealer's turn
        dealer.play(deck, showOpponentCards);

        // Bestämmer vem som har vunnit
        int playerValue = player.getHandValue();
        int dealerValue = dealer.getHandValue();

        System.out.println("\nPlayer's hand value: " + playerValue);
        System.out.println("Dealer's hand value: " + dealerValue);
//kollar ifall värdet på ditt kort överskrider ett visst värde och ifall värdet är mindre än dealerns hand så förlorar man
        if (playerValue > 21) {
            System.out.println("Player busts! Dealer wins.");
        } else if (dealerValue > 21) {
            System.out.println("Dealer busts! Player wins.");
        } else if (playerValue > dealerValue) {
            System.out.println("Player wins.");
        } else if (playerValue < dealerValue) {
            System.out.println("Dealer wins.");
        } else {
            System.out.println("It's a tie.");
        }
    }
}