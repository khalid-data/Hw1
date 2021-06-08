import java.util.ArrayList;

public class Player {
    final public String name;
    public Deck gameDeck;
    public Deck wonDeck;


    public Player(String name) {
        this.name = name;
        gameDeck = new Deck(false);
        wonDeck = new Deck(false);
    }


    public void addCard(Deck deck, Card card) {
        deck.cards.add(card);
    }

    public Card drawCard() {
        return gameDeck.removeTopCard();
    }

    public boolean outOfCards() {
        return (this.gameDeck.isEmpty() && this.wonDeck.isEmpty());
    }

    public String toString() {
        return this.name;
    }

    void refillCards() {
        if (this.gameDeck.isEmpty() && !this.wonDeck.isEmpty()) {
            this.wonDeck.shufffle();
            Deck temp = this.gameDeck;
            this.gameDeck = this.wonDeck;
            this.wonDeck = temp;

        }

    }
}

