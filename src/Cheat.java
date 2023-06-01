
public class Cheat extends Player { //cheat extendar Player genom att ta funktionen av Player men lägga till sina egna värden
    @Override
    public void showHand(boolean showAllCards) { //metoden som gör så att Player kan "Cheata"
        System.out.println("Player's hand:");
        for (Card card : this.hand) {
            System.out.println(card);
        }
        System.out.println("Total value: " + getHandValue());
    }
}
