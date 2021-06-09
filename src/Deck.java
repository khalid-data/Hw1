import java.util.ArrayList;
import java.util.Collections;


/**
 * this class represents decks of card
 * we use the decks in class player
 * a deck can be either empty or has objects from class card in it
 */
public class Deck {
    public ArrayList<Card> cards;


    /**
     * this class represents decks of card
     * we use the decks in class player
     * a deck can be either empty or has objects from class card in it
     */
    public Deck(boolean variable) {
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


    /**
     * this method adds a new card to the decks arraylist of cards
     */
    void addCard(Card card){
        cards.add(card);
    }


    /**
     * this method removes the top card from this decks arraylist of cards
     * it returns the card it removed
     */
    Card removeTopCard(){
        Card temp = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return temp;
    }


    /**
     * this method returns true if this decks arraylist of card is empty
     * and false if not
     */
    boolean isEmpty(){
        return cards.isEmpty();
    }


    /**
     * this method shuffles the deck
     * chooses two indexes in the decks cards arraylist and replaces their values
     * it does that 50 times
     */
    void shufffle(){
        for (int i = 0; i<50; i++){
            int index1 = Main.rnd.nextInt(cards.size());
            int index2 = Main.rnd.nextInt(cards.size());
            Collections.swap(cards, index1, index2);
        }
    }




}


