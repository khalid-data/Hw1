import java.util.ArrayList;

public class Player {
    final public String name;
    public Deck gameDeck ;
    public Deck wonDeck ;


    public Player(String name) {
        this.name = name;
        gameDeck = new Deck(false);
        wonDeck = new Deck(false);
    }


    public void addCard(Deck deck, Card card){
        deck.cards.add(card);
    }

    public Card drawCard(){
        return gameDeck.removeTopCard();
    }

    public boolean outOfCards(){
        return (this.gameDeck.isEmpty() && this.wonDeck.isEmpty());
    }

    public String toString(){
        return this.name;
    }

    public boolean canDraw() {
        if (!this.gameDeck.isEmpty()) {
            return true;
        } else {
            //System.out.println(this.name);
            if (this.wonDeck.isEmpty()) {
                return false;
            } else {
                this.wonDeck.shufffle();
                Deck temp ;
                temp = this.wonDeck;
                this.gameDeck = temp;
                return true;
            }
        }
    }


}
