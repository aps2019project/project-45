package model;

import view.menus.GraveYard;
import view.menus.PlayerCollection;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String userName;
    private String passWord;
    private int wins;
    private int losts;

    private PlayerCollection collection;
    //private ArrayList<Battle> matchHistory;
    private ArrayList<ArrayList<CardOrItem>> decks;
    private ArrayList<CardOrItem> mainDeck;
    private ArrayList<CardOrItem> hand;
    private GraveYard playerGraveYard;
    private ArrayList<String> enemyName = new ArrayList();
    private ArrayList<String> matchStatuse = new ArrayList();
    private ArrayList<Date> matchTime = new ArrayList();


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

    public GraveYard getPlayerGraveYard() {
        return playerGraveYard;
    }

    public ArrayList<CardOrItem> getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(ArrayList<CardOrItem> mainDeck) {
        this.mainDeck = mainDeck;
    }
}
