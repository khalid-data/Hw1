public class Card {
    final int CardNumber;
    final Shape Shape;

    public Card(int CardNumber, Shape shape){
        this.CardNumber = CardNumber;
        this.Shape = shape;
    }

    public int getCardNumber() {
        return CardNumber;
    }

    public Shape getShape() {
        return Shape;
    }


    int compare(Card other){
        if(this.CardNumber < other.CardNumber)
            return -1;
        else if(this.CardNumber == other.CardNumber)
            return 0;
        else
            return 1;
    }


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
