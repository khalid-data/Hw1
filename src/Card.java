/**
 * this class represents the game cards
 * we use the cards in the Decks of each player
 * every card object has a final number and final shape
 */
public class Card {
    final int CardNumber;
    final Shape Shape;


    /**
     * the classes constructor, it takes a number and a shape
     * and put them it the cards number and shape
     */
    public Card(int CardNumber, Shape shape){
        this.CardNumber = CardNumber;
        this.Shape = shape;
    }


    /**
     * returns the cards number
     */
    public int getCardNumber() {
        return CardNumber;
    }


    /**
     * retuens the shape of the card
     */
    public Shape getShape() {
        return Shape;
    }


    /**
     * comapres this card with another
     * if this card is bigger it returns 1
     * if it is smaller returns -1
     * and if they are equal it retuens 0
     */
    int compare(Card other){
        if(this.CardNumber < other.CardNumber)
            return -1;
        else if(this.CardNumber == other.CardNumber)
            return 0;
        else
            return 1;
    }


    /**
     * this method returns a string that has the card value (number) and the icon that represents its shape
     */
    @Override
    public String toString(){
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
