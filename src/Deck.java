import java.util.ArrayList;
import java.util.Collections;
import java.util.Formattable;
import java.util.Random;


public class Deck {
    /**
     * this class represents decks of card
     * we use the decks in class player
     * a deck can be either empty or has objects from class card in it
     */
    public ArrayList<Card> cards;

    public Deck(boolean variable) {
        /**
         * this is the constructor of the deck objects
         * it takes a boolean variable and fills the array list accordingly
         */
        if (variable) {
            cards = new ArrayList<Card>();
            for (Shape shape : Shape.values()) {
                for (int cardNumber = 1; cardNumber <= 13; cardNumber++) {
                    cards.add(new Card(cardNumber, shape));
                }
            }
        }
        else
            cards = new ArrayList<Card>();
    }

    void addCard(Card card){
        /**
         * this method adds a new card to the decks arraylist of cards
         */
        cards.add(card);
    }

    Card removeTopCard(){
        /**
         * this method removes the top card from this decks arraylist of cards
         * it returns the card it removed
         */
        Card temp = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return temp;
    }

    boolean isEmpty(){
        /**
         * this method returns true if this decks arraylist of card is empty
         * and false if not
         */
        return cards.isEmpty();
    }

    void shufffle(){
        /**
         * this method shuffles the deck
         * chooses two indexes in the decks cards arraylist and replaces their values
         * it does that 50 times
         */
        for (int i = 0; i<50; i++){
            int index1 = Main.rnd.nextInt(cards.size());
            int index2 = Main.rnd.nextInt(cards.size());
            Collections.swap(cards, index1, index2);
        }
    }




}


