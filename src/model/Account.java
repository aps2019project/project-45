package model;

import view.menus.GraveYard;
import view.menus.PlayerCollection;

import java.util.*;

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
    private int MP;
    private Card selectedCard;
    private boolean activeAtTheMoment;

    private Map<String, Card> selectedDeck = new HashMap<>();
    private Map<String, Card> hand = new HashMap<>();
    private Card nextCardForHand;
    private ArrayList<Card> graveYard = new ArrayList<>();
    private ArrayList<String> lastEnemyNames = new ArrayList<>();
    private ArrayList<String> matchStatuses = new ArrayList<>();
    private ArrayList<Date> matchTimes = new ArrayList<>();
    private Map<String, Card> activeCardsOnGround = new HashMap<>();
    private Hero hero = new Hero();
    private Map<String, Minion> activeMinions = new HashMap<>();
    private Map<String, Spell> activeSpells = new HashMap<>();

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

    public Card getNextCardForHand() {
        Random random = new Random();
        while (true) {
            int randInt = random.nextInt(20) - 1; //age nafahmidi bepors khaheshan
            if (getSelectedDeck().get(randInt) instanceof Minion || getSelectedDeck().get(randInt) instanceof Spell)
                return (Card) getSelectedDeck().get(randInt);
        }
    }

    public Card getSelectedCard() {
        return selectedCard;
    }

    public void setSelectedCard(Card selectedCard) {
        this.selectedCard = selectedCard;
    }

    public boolean isActiveAtTheMoment() {
        return activeAtTheMoment;
    }

    public void setActiveAtTheMoment(boolean activeAtTheMoment) {
        this.activeAtTheMoment = activeAtTheMoment;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Map<String, Card> getSelectedDeck() {
        return selectedDeck;
    }

    public void setSelectedDeck(Map<String, Card> selectedDeck) {
        this.selectedDeck = selectedDeck;
    }

    public Map<String, Card> getHand() {
        return hand;
    }

    public void setHand(Map<String, Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getGraveYard() {
        return graveYard;
    }

    public void setGraveYard(ArrayList<Card> graveYard) {
        this.graveYard = graveYard;
    }

    public Map<String, Card> getActiveCardsOnGround() {
        return activeCardsOnGround;
    }

    public void setActiveCardsOnGround(Map<String, Card> activeCardsOnGround) {
        this.activeCardsOnGround = activeCardsOnGround;
    }

    public Map<String, Minion> getActiveMinions() {
        return activeMinions;
    }

    public void setActiveMinions(Map<String, Minion> activeMinions) {
        this.activeMinions = activeMinions;
    }

    public Map<String, Spell> getActiveSpells() {
        return activeSpells;
    }

    public void setActiveSpells(Map<String, Spell> activeSpells) {
        this.activeSpells = activeSpells;
    }
}
