import java.util.ArrayList;

public class Player {
    /**
     * this class represents a player in the wargame
     * each player has a final name and two deck
     * the game deck is the one he plays with
     * and the wondeck id the one he puts the cards he wins in
     */
    final public String name;
    public Deck gameDeck;
    public Deck wonDeck;


    public Player(String name) {
        /**
         * the constructor of this class
         * it takes a name of the player and sets it
         * and it intializes two empty decks for the player
         */
        this.name = name;
        gameDeck = new Deck(false);
        wonDeck = new Deck(false);
    }


    public void addCard(Deck deck, Card card) {
        /**
         * this method takes a deck and a card and adds the card to the decks arraylist of cards
         */
        deck.cards.add(card);
    }

    public Card drawCard() {
        /**
         * this method removes a card from the top of the games deck arraylist of cards
         * it returns the card object it removed
         */
        return gameDeck.removeTopCard();
    }

    public boolean outOfCards() {
        /**
         * this method check if at least one of the players deck has cards
         */
        return (this.gameDeck.isEmpty() && this.wonDeck.isEmpty());
    }

    public String toString() {
        /**
         * returns a string of the players name
         */
        return this.name;
    }

    void refillCards() {
        /**
         * this method checks if we should refill the game dick from the winning cards dick
         */
        if (this.gameDeck.isEmpty() && !this.wonDeck.isEmpty()) {
            this.wonDeck.shufffle();
            Deck temp = this.gameDeck;
            this.gameDeck = this.wonDeck;
            this.wonDeck = temp;

        }

    }
}

