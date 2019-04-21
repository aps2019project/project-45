package model;

import java.util.ArrayList;

public class Account {

    private String userName;
    private String passWord;

    private PlayerCollection collection;
    //private ArrayList<Battle> matchHistory;
    private ArrayList<ArrayList<Card>> decks;
    private ArrayList<Card> mainDeck;
    private ArrayList<Card> hand;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public Account(String userName , String passWord){
        this.userName = userName;
        this.passWord = passWord;
    }

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(ArrayList<Card> mainDeck) {
        this.mainDeck = mainDeck;
    }
}
