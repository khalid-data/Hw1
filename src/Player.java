/**
 * this class represents a player in the wargame
 * each player has a final name and two deck
 * the game deck is the one he plays with
 * and the wondeck id the one he puts the cards he wins in
 */
public class Player {
    final public String name;
    public Deck gameDeck;
    public Deck wonDeck;


    /**
     * the constructor of this class
     * it takes a name of the player and sets it
     * and it intializes two empty decks for the player
     */
    public Player(String name) {
        this.name = name;
        gameDeck = new Deck(false);
        wonDeck = new Deck(false);
    }


    /**
     * this method takes a deck and a card and adds the card to the decks arraylist of cards
     */
    public void addCard(Deck deck, Card card) {
        deck.cards.add(card);
    }


    /**
     * this method removes a card from the top of the games deck arraylist of cards
     * it returns the card object it removed
     */
    public Card drawCard() {
        return gameDeck.removeTopCard();
    }


    /**
     * this method check if at least one of the players deck has cards
     */
    public boolean outOfCards() {
        return (this.gameDeck.isEmpty() && this.wonDeck.isEmpty());
    }


    /**
     * returns a string of the players name
     */
    public String toString() {
        return this.name;
    }


    /**
     * this method checks if we should refill the game dick from the winning cards dick
     */
    void refillCards() {
        if (this.gameDeck.isEmpty() && !this.wonDeck.isEmpty()) {
            this.wonDeck.shufffle();
            Deck temp = this.gameDeck;
            this.gameDeck = this.wonDeck;
            this.wonDeck = temp;

        }

    }
}

