import java.util.InputMismatchException;
import java.util.Scanner;

public class Option extends Blackjack { //klassen Option tar in värden från Blackjack

    public Option() { //konstruktor
    Scanner scanner = new Scanner(System.in); //user input
        System.out.println("Choose a version:");
        System.out.println("1. Normal");
        System.out.println("2. Show opponent's cards");
        System.out.print("Enter your choice: ");
    int version;
    boolean showOpponentCards = false;

        while (true) {
        try {
            version = scanner.nextInt();

            if (version == 2) {
                showOpponentCards = true;
            } else if (version != 1) {
                System.out.println("Invalid input. Please enter either 1 or 2.");
                continue;
            }

            break; // Break out of the loop if a valid input is provided

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            scanner.nextLine(); // Clear the input buffer
        }
    }
    Blackjack blackjack = new Blackjack(); //skapar en instans
        blackjack.playGame(showOpponentCards);
}
}
