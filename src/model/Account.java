package model;

import view.menus.GraveYard;
import view.menus.PlayerCollection;
import view.menus.GraveYard;
import view.menus.PlayerCollection;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Account {
    public Account(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    private String userName;
    private String passWord;
    private int mana;
    private int money;
    private int wins;
    private int losts;
    private CardOrItem selectedCardOrItem;
    private boolean activeAtTheMoment;

    private PlayerCollection collection;

    private ArrayList<CardOrItem> selectedDeck;
    private ArrayList<Card> hand;
    private Card nextCardForHand;
    private GraveYard graveYard;
    private ArrayList<String> lastEnemyNames = new ArrayList<>();
    private ArrayList<String> matchStatuses = new ArrayList<>();
    private ArrayList<Date> matchTimes = new ArrayList<>();
    private Hero hero;
    private ArrayList<Minion> activeMinions = new ArrayList<>();
    private ArrayList<Spell> activeSpells = new ArrayList<>();

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

    public ArrayList<CardOrItem> getSelectedDeck() {
        return collection.getDecks().get(collection.getSelectedDeckName());
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public Card getNextCardForHand() {
        Random random = new Random();
        while (true) {
            int randInt = random.nextInt(20) - 1; //age nafahmidi bepors khaheshan
            if (getSelectedDeck().get(randInt) instanceof Minion || getSelectedDeck().get(randInt) instanceof Spell)
                return (Card)getSelectedDeck().get(randInt);
        }
    }

    public GraveYard getGraveYard() {
        return graveYard;
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

    public CardOrItem getSelectedCardOrItem() {
        return selectedCardOrItem;
    }

    public void setSelectedCardOrItem(Card selectedCardOrItem) {
        this.selectedCardOrItem = selectedCardOrItem;
    }

    public boolean isActiveAtTheMoment() {
        return activeAtTheMoment;
    }
    public void setActiveAtTheMoment(boolean activeAtTheMoment) {
        this.activeAtTheMoment = activeAtTheMoment;
    }

    /*public GraveYard getPlayerGraveYard() {
        return playerGraveYard;
    }*/

    /*public void setMainDeck(ArrayList<CardOrItem> mainDeck) {
        this.mainDeck = mainDeck;
    }*/

}
