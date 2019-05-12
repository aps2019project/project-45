package view;

import model.*;
import view.menus.Menu;
import model.PlayingType;

import java.util.ArrayList;

public class Battle extends Menu {
    private static final Battle BATTLE = new Battle();
    private Battle() {
    }
    public static Battle getInstance() {
        return BATTLE;
    }

    private Account[] battlePlayers = new Account[2];
    private Square[][] square = new Square[5][9];
    private ArrayList<Item> flags = new ArrayList<>();
    private Card selectedCard;
    private PlayingType playingType;
    private PlayingMode playingMode;
    private int turn;

    public void gameInfo(int mode) {
        System.out.println(battlePlayers[0].getUserName() + " mana : " + battlePlayers[0].getMana());
        System.out.println(battlePlayers[1].getUserName() + " mana : " + battlePlayers[1].getMana());
        switch (mode) {
            case 1:
                System.out.println(battlePlayers[0].getUserName() + " health : " + battlePlayers[0].getHero().getHealth());
                System.out.println(battlePlayers[1].getUserName() + " health : " + battlePlayers[0].getHero().getHealth());
                break;
            case 2:
                System.out.printf("flag is in (%d , %d) house.\n", flags.get(0).getSquare().getX(), flags.get(0).getSquare().getY());
                if (flags.get(0).getFlagOwner() == null) System.out.println("Flag isn't owned by any player!");
                else
                    System.out.printf("flag owner is %s from player %s\n", flags.get(0).getFlagOwner().getCardID() ,
                            flags.get(0).getUserAccount().getUserName());
                break;
            case 3:
                System.out.println("owners of flags : ");
                for (int i = 0; i < flags.size(); i++) {
                    System.out.printf("%d. %s from player %s\n", i + 1 , flags.get(i).getFlagOwner().getCardID() ,
                            flags.get(i).getUserAccount().getUserName());
                }
                break;
        }
    }
    public void showMyMinions(){
        Hero hero = getActiveAccount().getHero();
        System.out.printf("%s : %s, health : %d, location : (%d, %d), power : %d\n", hero.getCardID() ,
                hero.getName() , hero.getHealth() , hero.getSquare().getX() , hero.getSquare().getY() , hero.getAP());
        for (Minion minion : getActiveAccount().getActiveMinions()){
        //for (int i = 0; i < account.getActiveMinions().size(); i++) {
            //Minion minion = account.getActiveMinions().get(i);
            System.out.printf("%s : %s, health : %d, location : (%d, %d), power : %d\n" , minion.getCardID() , minion.getName() ,
                    minion.getHealth() , minion.getSquare().getX() , minion.getSquare().getY() , minion.getAP());
        }
    }
    public void showOpponentMinions() {
        battlePlayers[0].setActiveAtTheMoment(!battlePlayers[0].isActiveAtTheMoment());
        battlePlayers[1].setActiveAtTheMoment(!battlePlayers[1].isActiveAtTheMoment());
        showMyMinions();
        battlePlayers[0].setActiveAtTheMoment(!battlePlayers[0].isActiveAtTheMoment());
        battlePlayers[1].setActiveAtTheMoment(!battlePlayers[1].isActiveAtTheMoment());
    } // hatman baiad beporsi
    public void select(boolean turn , String cardID){
        Account account;
        if (turn) account = battlePlayers[0];
        else account = battlePlayers[1];
        if (account.getHero().getCardID().equals(cardID)) selectedCard = account.getHero();
        for (Minion minion : account.getActiveMinions()){
            if (minion.getCardID().equals(cardID)){
                selectedCard = minion;
                break;
            }
        }
        if (selectedCard == null) {
            System.out.println("Invalid card id");
            return;
        }
        account.setSelectedCardOrItem(selectedCard);
    }
    public void moveTo(int x , int y){
        if (checkForValidMoving(x, y)) return;
        selectedCard.getSquare().setX(x);
        selectedCard.getSquare().setY(y);
    }
    public void attack(String cardID){

    }
    public void comboAttack(String opponentCardID , String... myCardID){

    }
    public void useSpecialPower(int x , int y){

    }
    public void showHand(){
        Account account = null;
        if (battlePlayers[0].isActiveAtTheMoment()) account = battlePlayers[0];
        else account = battlePlayers[1];

        for (Card card : account.getHand()) {
            System.out.println(card.getCardID());
        }
        System.out.printf("\nNext card in hand : %s\n" , account.getNextCardForHand().getCardID());
    }
    public void insert(String cardID , int x , int y) {
        for (Card card : getActiveAccount().getHand()){
            if (card.getCardID().equalsIgnoreCase(cardID)) {

                //later

            }
        }
        System.out.println("Invalid card name!");
    }
    public void endTurn(){
        int neededCards = 5 - getActiveAccount().getHand().size();
        for (int i = 0; i < neededCards; i++) {
            getActiveAccount().getHand().add((Card) getActiveAccount().getSelectedDeck().get(0));
            getActiveAccount().getSelectedDeck().remove(0);
        }
        battlePlayers[0].setActiveAtTheMoment(!battlePlayers[0].isActiveAtTheMoment());
        battlePlayers[1].setActiveAtTheMoment(!battlePlayers[1].isActiveAtTheMoment());

    }
    public void showCollectables() {
        for (Item item : getActiveAccount().getCollection().getItems()) {
            if (item.isCollectable()) System.out.println(item.getCardID());
        }
    }
    public void selectItem (String cardID) {
        //
    }
    public void showInfo() {//don't make mistake with the lower function

    }
    public void useItem(int x , int y) {

    }
    public void showNextCard() {
        View.showCardOrItemInfoWithCost(getActiveAccount().getNextCardForHand() , 0);
    }
    public void showInfo(String cardID) {
        for (Card card : getActiveAccount().getGraveYard().getCards()) {
            if (card.getCardID().equals(cardID)) {
                View.showCardOrItemInfoWithCost(card , 0);
                return;
            }
        }
    }
    public void showCards() {
        for (int i = 0; i < getActiveAccount().getGraveYard().getCards().size(); i++) {
            View.showCardOrItemInfoWithCost(getActiveAccount().getGraveYard().getCards().get(i) , i);
        }
    }
    public void endGame() {

    }



    //almozakhrafat
    private boolean checkForValidMoving(int x, int y) {
        if (Math.abs(x - selectedCard.getSquare().getX()) + Math.abs(y - selectedCard.getSquare().getY()) > 2){
            System.out.println("Invalid target");
            return true;
        }
        if (square[x][y].getCard() == null) {
            System.out.println("Invalid target");
            return true;
        }
        if (x != selectedCard.getSquare().getX() && y != selectedCard.getSquare().getY()){
            if (square[selectedCard.getSquare().getX()][y].getCard() != null &&
                    square[x][selectedCard.getSquare().getY()].getCard() != null){
                System.out.println("Invalid target");
                return true;
            }
        }
        if (y == selectedCard.getSquare().getY()) {
            if (square[selectedCard.getSquare().getX() + (x - selectedCard.getSquare().getX()) / 2][y].getCard() != null){
                System.out.println("Invalid target");
                return true;
            }
        }
        if (x == selectedCard.getSquare().getX()) {
            if (square[x][selectedCard.getSquare().getY() + (y - selectedCard.getSquare().getY()) / 2].getCard() != null){
                System.out.println("Invalid target");
                return true;
            }
        }
        return false;
    }
    public Account[] getActiveAccounts() {
        return battlePlayers;
    }
    public Square[][] getSquare() {
        return square;
    }
    public PlayingType getPlayingType() {
        return playingType;
    }
    public void setPlayingType(PlayingType playingType) {
        this.playingType = playingType;
    }
    public PlayingMode getPlayingMode() {
        return playingMode;
    }
    public void setPlayingMode(PlayingMode playingMode) {
        this.playingMode = playingMode;
    }

    @Override
    public void help() {
        System.out.print("Game info\nShow my minions\nShow opponent minions\nShow card info [card id]\nSelect [card id]\n" +
                "");
    }

    @Override
    public MenuType getType() {
        return MenuType.BATTLE;
    }

    @Override
    public void open() {
        System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * Battle" +
                " * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    }


    public Account getActiveAccount() {
        if (battlePlayers[0].isActiveAtTheMoment()) return battlePlayers[0];
        else return battlePlayers[1];
    }
    public Account getInActiveAccount() {
        if (battlePlayers[0].isActiveAtTheMoment()) return battlePlayers[1];
        else return battlePlayers[0];
    }
    public int getTurn() {
        return turn;
    }
    public void setTurn(int turn) {
        this.turn = turn;
    }
}
