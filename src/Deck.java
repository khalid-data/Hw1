import java.util.ArrayList;
import java.util.Collections;
import java.util.Formattable;
import java.util.Random;


public class Deck {
    public ArrayList<Card> cards;

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

    void addCard(Card card){
        cards.add(card);
    }

    Card removeTopCard(){// check if this is what thwy ment by last card
        Card temp = cards.get(cards.size()-1);
        cards.remove(cards.size()-1);
        return temp;
    }

    boolean isEmpty(){
        return cards.isEmpty();
    }

    void shufffle(){
        for (int i = 0; i<50; i++){
            int index1 = Main.rnd.nextInt(cards.size());
            int index2 = Main.rnd.nextInt(cards.size());
            Collections.swap(cards, index1, index2);
        }
    }
}