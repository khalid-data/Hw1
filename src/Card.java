public class Card {
    /**
     * this class represents the game cards
     * we use the cards in the Decks of each player
     * every card object has a final number and final shape
     */
    final int CardNumber;
    final Shape Shape;

    public Card(int CardNumber, Shape shape){
        /**
         * the classes constructor, it takes a number and a shape
         * and put them it the cards number and shape
         */
        this.CardNumber = CardNumber;
        this.Shape = shape;
    }

    public int getCardNumber() {
        /**
         * returns the cards number
         */
        return CardNumber;
    }

    public Shape getShape() {
        /**
         * retuens the shape of the card
         */
        return Shape;
    }


    int compare(Card other){
        /**
         * comapres this card with another
         * if this card is bigger it returns 1
         * if it is smaller returns -1
         * and if they are equal it retuens 0
         */
        if(this.CardNumber < other.CardNumber)
            return -1;
        else if(this.CardNumber == other.CardNumber)
            return 0;
        else
            return 1;
    }


    @Override
    public String toString(){
        /**
         * this method returns a string that has the card value (number) and the icon that represents its shape
         */
        String cardValue = null;
        if(this.CardNumber == 1)
            cardValue = "Ace";
        else if (this.CardNumber >1 && this.CardNumber < 11)
            cardValue = String.valueOf(this.CardNumber);
        else if(this.CardNumber == 11)
            cardValue = "Jack";
        else if(this.CardNumber == 12)
            cardValue = "Queen";
        else if(this.CardNumber == 13)
            cardValue = "King";


        if (this.Shape == Shape.Hearts)
            return cardValue + " of" + " ♥";
        else if (this.Shape == Shape.Clubs)
            return cardValue + " of" + " ♣";
        else if (this.Shape == Shape.Spades)
            return cardValue + " of" + " ♠";
        else if (this.Shape == Shape.Diamonds)
            return cardValue + " of" + " ♦";
        return "No such card";
    }
}
