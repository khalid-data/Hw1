import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class WarGame {
    Player player1;
    Player player2;

    public WarGame(String name1, String name2){
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getfirstPlayer(){
        return compareStr(player1.name , player2.name) ? player2 :player1;
    }

    public boolean compareStr(String str1, String str2){
        int iters = str1.length() > str2.length() ? str2.length() : str1.length();
        for(int i=0 ; i< iters ; i++){
            if(str1.charAt(i)>str2.charAt(i))
                return true;
            if(str1.charAt(i)<str2.charAt(i))
                return false;
        }
        return str1.length() > str2.length();
    }

    public void initializeGame(){
        System.out.println("Initializing the game...");
        Deck deck = new Deck(true);
        deck.shufffle();
        Player currentPlayer = getfirstPlayer();
        while(!deck.isEmpty()){
            Card currentCard = deck.removeTopCard();
            currentPlayer.gameDeck.cards.add(currentCard);
            currentPlayer = (currentPlayer != player1 ? player1 : player2);
        }
    }

    public void give_player_cards(Player player,ArrayList<Card> p1_cards,ArrayList<Card> p2_cards){//change
        //I know for a fact that p1_cards belong to the first.
        for(int i=p1_cards.size()-1; i>= 0; i--){
            player.wonDeck.cards.add(p2_cards.get(i));
            player.wonDeck.cards.add(p1_cards.get(i));
        }
        p1_cards.clear();
        p2_cards.clear();
    }

    public String drawCard(Player player, ArrayList<Card> cards,boolean inWar){
        Card card = player.drawCard();
        cards.add(card);
        if(!inWar)
            return player.name + " drew " + cards.get(cards.size()-1).toString() ;
        else{
            return player.name + " drew a war card" ;
        }
    }

    public void lexPrintCardDrewing( String string1, String string2){
        if (string1.charAt(0) > string2.charAt(0)){
            System.out.println(string2);
            System.out.println(string1);
        }
        else
            System.out.println(string1);
            System.out.println(string2);
    }




    public String start(){
        /// make them from Deck
        ArrayList<Card> firstPlayerCards = new ArrayList<Card>();
        ArrayList<Card> secondPlayerCards = new ArrayList<Card>();

        initializeGame();

        Player currentPlayer = getfirstPlayer();
        Player otherPlayer = (currentPlayer != player1 ? player1 : player2);
        int round = 1;

        while(!player1.outOfCards() || !player2.outOfCards()) {


            if(!currentPlayer.canDraw() || !otherPlayer.canDraw()){
                System.out.println("shit happened");
                break; }
            System.out.println("------------------------- Round number " + round++ + " -------------------------");
            boolean flag = true;
            boolean isWar = false;

            while (flag) {

                if(!currentPlayer.canDraw() || !otherPlayer.canDraw()){
                    System.out.println("shit happened");
                    break; }

                firstPlayerCards.add(currentPlayer.drawCard());
                System.out.println(currentPlayer.name + " drew " + firstPlayerCards.get(firstPlayerCards.size()-1).toString());
                secondPlayerCards.add(otherPlayer.drawCard());
                System.out.println(otherPlayer.name + " drew " + secondPlayerCards.get(secondPlayerCards.size()-1).toString());

                int comparing = firstPlayerCards.get(firstPlayerCards.size() - 1).compare(secondPlayerCards.get(secondPlayerCards.size() - 1));

                if (comparing == 1) {
                    give_player_cards(currentPlayer, firstPlayerCards, secondPlayerCards);
                    if(!isWar)
                        System.out.println(currentPlayer.name + " won");
                    else
                        System.out.println(currentPlayer.name + " won the war");
                    flag = false;
                } else if (comparing == -1) {
                    give_player_cards(otherPlayer, firstPlayerCards, secondPlayerCards);
                    if(!isWar)
                        System.out.println(otherPlayer.name + " won");
                    else
                        System.out.println(otherPlayer.name + " won the war");
                    flag = false;
                } else if (comparing == 0) {
                    isWar = true;
                    System.out.println("Starting a war...");
                    if(!currentPlayer.canDraw() || !otherPlayer.canDraw()){
                        flag = false;
                        continue;
                    }
                    firstPlayerCards.add(currentPlayer.drawCard());
                    System.out.println(currentPlayer.name + " drew a war card");
                    // System.out.println(currentPlayer.name + " drew " + firstPlayerCards.get(firstPlayerCards.size()-1).toString());
                    secondPlayerCards.add(otherPlayer.drawCard());
                    System.out.println(otherPlayer.name + " drew a war card");
                    // System.out.println(otherPlayer.name + " drew " + secondPlayerCards.get(secondPlayerCards.size()-1).toString());

                    if(!currentPlayer.canDraw() || !otherPlayer.canDraw()){
                        flag = false;
                        continue;
                    }
                    firstPlayerCards.add(currentPlayer.drawCard());
                    System.out.println(currentPlayer.name + " drew a war card");
                    secondPlayerCards.add(otherPlayer.drawCard());
                    System.out.println(otherPlayer.name + " drew a war card" );
                }
            }
           // currentPlayer = (currentPlayer != player1 ? player1 : player2);
          // otherPlayer = (otherPlayer != player1 ? player1 : player2);
        }
        if (player1.outOfCards())
            return player2.name;
        else
            return player1.name;
    }
}
