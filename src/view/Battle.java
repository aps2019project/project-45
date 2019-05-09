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

    private Account[] actvieAccounts = new Account[2];
    private Square[][] square = new Square[5][9];
    private ArrayList<Item> flags = new ArrayList<>();
    private Card selectedCard;
    private PlayingType playingType;

    public void gameInfo(int mode) {
        System.out.println(actvieAccounts[0].getUserName() + " mana : " + actvieAccounts[0].getMana());
        System.out.println(actvieAccounts[1].getUserName() + " mana : " + actvieAccounts[1].getMana());
        switch (mode) {
            case 1:
                System.out.println(actvieAccounts[0].getUserName() + " health : " + actvieAccounts[0].getHero().getHealth());
                System.out.println(actvieAccounts[1].getUserName() + " health : " + actvieAccounts[0].getHero().getHealth());
                break;
            case 2:
                System.out.printf("flag is in (%d , %d) house.\n", flags.get(0).getSquare().getX(), flags.get(0).getSquare().getY());
                if (flags.get(0).getOwner() == null) System.out.println("Flag isn't owned by any player!");
                else
                    System.out.printf("flag owner is %s from player %s\n", flags.get(0).getOwner().getCardID() ,
                            flags.get(0).getUserAccountOwner().getUserName());
                break;
            case 3:
                System.out.println("owners of flags : ");
                for (int i = 0; i < flags.size(); i++) {
                    System.out.printf("%d. %s from player %s\n", i + 1 , flags.get(i).getOwner().getCardID() ,
                            flags.get(i).getUserAccountOwner().getUserName());
                }
                break;
        }
    }
    public void showMyMinions(boolean turn){
        Account account;
        if (turn) account = actvieAccounts[0];
        else account = actvieAccounts[1];
        Hero hero = account.getHero();
        System.out.printf("%s : %s, health : %d, location : (%d, %d), power : %d\n", hero.getCardID() ,
                hero.getName() , hero.getHealth() , hero.getSquare().getX() , hero.getSquare().getY() , hero.getAP());
        for (Minion minion : account.getActiveMinions()){
        //for (int i = 0; i < account.getActiveMinions().size(); i++) {
            //Minion minion = account.getActiveMinions().get(i);
            System.out.printf("%s : %s, health : %d, location : (%d, %d), power : %d\n" , minion.getCardID() , minion.getName() ,
                    minion.getHealth() , minion.getSquare().getX() , minion.getSquare().getY() , minion.getAP());
        }
    }
    public void showOpponentMinions(boolean turn) { showMyMinions(!turn); } // need to modify in Request
    public void select(boolean turn , String cardID){
        Account account;
        if (turn) account = actvieAccounts[0];
        else account = actvieAccounts[1];
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
        account.setSelectedCardInBattle(selectedCard);
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

    }


    //almozakhrafat
    private boolean checkForValidMoving(int x, int y) {
        if (Math.abs(x - selectedCard.getSquare().getX()) + Math.abs(y - selectedCard.getSquare().getY()) > 2){
            System.out.println("Invalid target");
            return true;
        }
        if (square[x][y].getIsOccupied()) {
            System.out.println("Invalid target");
            return true;
        }
        if (x != selectedCard.getSquare().getX() && y != selectedCard.getSquare().getY()){
            if (square[selectedCard.getSquare().getX()][y].getIsOccupied() &&
                    square[x][selectedCard.getSquare().getY()].getIsOccupied()){
                System.out.println("Invalid target");
                return true;
            }
        }
        if (y == selectedCard.getSquare().getY()) {
            if (square[selectedCard.getSquare().getX() + (x - selectedCard.getSquare().getX()) / 2][y].getIsOccupied()){
                System.out.println("Invalid target");
                return true;
            }
        }
        if (x == selectedCard.getSquare().getX()) {
            if (square[x][selectedCard.getSquare().getY() + (y - selectedCard.getSquare().getY()) / 2].getIsOccupied()){
                System.out.println("Invalid target");
                return true;
            }
        }
        return false;
    }
    public Account[] getActiveAccounts() {
        return actvieAccounts;
    }
    public PlayingType getPlayingType() {
        return playingType;
    }
    public void setPlayingType(PlayingType playingType) {
        this.playingType = playingType;
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

}
