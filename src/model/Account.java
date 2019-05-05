package model;

import view.menus.GraveYard;
import view.menus.PlayerCollection;
import view.menus.GraveYard;
import view.menus.PlayerCollection;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String userName;
    private String passWord;
    private int mana;
    private int money;
    private int wins;
    private int losts;
    private Card selectedCardInBattle;

    private PlayerCollection collection;

    private ArrayList<CardOrItem> hand;
    private GraveYard playerGraveYard;
    private ArrayList<String> lastEnemyNames = new ArrayList<>();
    private ArrayList<String> matchStatuses = new ArrayList<>();
    private ArrayList<Date> matchTimes = new ArrayList<>();
    private Hero hero;
    private ArrayList<Minion> activeMinions = new ArrayList<>();
    private ArrayList<Spell> activeSpells = new ArrayList<>();

    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public int getLosts() {
        return losts;
    }
    public void setLosts(int losts) {
        this.losts = losts;
    }
    public int getWins() {
        return wins;
    }
    public void setWins(int wins) {
        this.wins = wins;
    }
    public Hero getHero() {
        return hero;
    }
    public ArrayList<Minion> getActiveMinions() {
        return activeMinions;
    }
    public ArrayList<Spell> getActiveSpells() {
        return activeSpells;
    }
    public PlayerCollection getCollection() {
        return collection;
    }
    public Card getSelectedCardInBattle() {
        return selectedCardInBattle;
    }
    public void setSelectedCardInBattle(Card selectedCardInBattle) {
        this.selectedCardInBattle = selectedCardInBattle;
    }


    /*public GraveYard getPlayerGraveYard() {
        return playerGraveYard;
    }*/

    /*public void setMainDeck(ArrayList<CardOrItem> mainDeck) {
        this.mainDeck = mainDeck;
    }*/

}
