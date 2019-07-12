package model;

import view.menus.GraveYard;
import view.menus.PlayerCollection;

import java.util.*;

public class Account {
    public Account(String username, String passWord) {
        this.username = username;
        this.passWord = passWord;
    }

    private String username;
    private String passWord;
    private String deckName;
    private int mana;
    private int money;
    private int wins;
    private int losts;
    private int MP;
    private Card selectedCard;
    private boolean activeAtTheMoment;

    private PlayerCollection playerCollection = new PlayerCollection();
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

    public String getUsername() {
        return username;
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
        for (Card card : selectedDeck.values()) return card;
        return null;
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

    public String getDeckName() {
        return deckName;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName;
    }

    public PlayerCollection getPlayerCollection() {
        return playerCollection;
    }

    public void setPlayerCollection(PlayerCollection playerCollection) {
        this.playerCollection = playerCollection;
    }
}
