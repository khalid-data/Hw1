import java.util.ArrayList;

/**
 * this class represents the war game
 * each war game has two players
 */
public class WarGame {
    Player player1;
    Player player2;


    /**
     * the constructor of the wargame
     * initializes the players objects of this war game
     */
    public WarGame(String name1, String name2){
        this.player1 = new Player(name1);
        this.player2 = new Player(name2);
    }


    /**
     * returns the player1
     */
    public Player getPlayer1() {
        return player1;
    }


    /**
     * returns the player2
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * sets player1
     */
    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }


    /**
     * sets player2
     */
    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }


    /**
     * returns the player that should start first
     * this method calls the comparestr method to find out witch player should start
     * is used in the initializegame method
     */
    public Player getfirstPlayer(){
        return compareStr(player1.name , player2.name) ? player2 :player1;
    }


    /**
     * this method taked two strings of players names and returns a boolean variable according to whom is bigger
     * is used in getfirstplayer method
     */
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


    /**
     * this method initializes the ga,e
     * it makes a new object of Deck class and constructs it so it has a full playing cards set
     * it shuffles the deck and divide it for the players starting from the one that should start first
     * is used in start method
     */
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


    /**
     * this method is used in the start method
     * it adds the cards that the players played with and returns them to the winner
     */
    public void givePlayerCards(Player player,ArrayList<Card> player1_cards,ArrayList<Card> player2_cards){
        for(int i=player1_cards.size()-1; i>= 0; i--){
            player.wonDeck.cards.add(player2_cards.get(i));
            player.wonDeck.cards.add(player1_cards.get(i));
        }
        player1_cards.clear();
        player2_cards.clear();
    }


    /**
     * this method plays the game
     * it initializes two arraylists of cards for each player
     * these arraylists are the deck on the center(the one they play their cards on)
     * we can change them with a deck instead
     * but " if it works don"t change it :P "
     * we check witch player should play first
     * and starts the game
     * the game continues as long as both players have cards
     */
    public String start(){
        ArrayList<Card> firstPlayerCards = new ArrayList<Card>();
        ArrayList<Card> secondPlayerCards = new ArrayList<Card>();

        initializeGame();

        Player currentPlayer = getfirstPlayer();
        Player otherPlayer = (currentPlayer != player1 ? player1 : player2);
        int round = 1;

        while((!player1.outOfCards() && !player2.outOfCards())) {

            System.out.println("------------------------- Round number " + round++ + " -------------------------");
            boolean flag = true;
            boolean isWar = false;

            while (flag) {

                if(currentPlayer.outOfCards() || otherPlayer.outOfCards()){
                    flag = false;
                    break;
                }
                currentPlayer.refillCards();
                otherPlayer.refillCards();

                firstPlayerCards.add(currentPlayer.drawCard());
                System.out.println(currentPlayer.name + " drew " + firstPlayerCards.get
                        (firstPlayerCards.size()-1).toString());
                secondPlayerCards.add(otherPlayer.drawCard());
                System.out.println(otherPlayer.name + " drew " + secondPlayerCards.get
                        (secondPlayerCards.size()-1).toString());

                int comparing = firstPlayerCards.get(firstPlayerCards.size() - 1)
                        .compare(secondPlayerCards.get(secondPlayerCards.size() - 1));

                if (comparing == 1) {
                    givePlayerCards(currentPlayer, firstPlayerCards, secondPlayerCards);
                    if(!isWar)
                        System.out.println(currentPlayer.name + " won");
                    else
                        System.out.println(currentPlayer.name + " won the war");
                    flag = false;
                } else if (comparing == -1) {
                    givePlayerCards(otherPlayer, firstPlayerCards, secondPlayerCards);
                    if(!isWar)
                        System.out.println(otherPlayer.name + " won");
                    else
                        System.out.println(otherPlayer.name + " won the war");
                    flag = false;
                } else if (comparing == 0) {
                    isWar = true;
                    System.out.println("Starting a war...");
                    if(currentPlayer.outOfCards() || otherPlayer.outOfCards()){
                        flag = false;
                        break;
                    }
                    currentPlayer.refillCards();
                    otherPlayer.refillCards();
                    firstPlayerCards.add(currentPlayer.drawCard());
                    System.out.println(currentPlayer.name + " drew a war card");
                    secondPlayerCards.add(otherPlayer.drawCard());
                    System.out.println(otherPlayer.name + " drew a war card");

                    if(currentPlayer.outOfCards() || otherPlayer.outOfCards()){
                        flag = false;
                        break;
                    }
                    currentPlayer.refillCards();
                    otherPlayer.refillCards();
                    firstPlayerCards.add(currentPlayer.drawCard());
                    System.out.println(currentPlayer.name + " drew a war card");
                    secondPlayerCards.add(otherPlayer.drawCard());
                    System.out.println(otherPlayer.name + " drew a war card" );
                }
            }
        }
        if (player1.outOfCards())
            return player2.name;
        else
            return player1.name;
    }
}
