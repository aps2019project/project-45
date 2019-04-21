package model;

import java.util.ArrayList;

public class Account {

    private ArrayList<Card> collection;
    private ArrayList<Battle> matchHistory;
    private ArrayList<ArrayList<Card>> decks;
    private ArrayList<Card> mainDeck;

    public ArrayList<Card> getMainDeck() {
        return mainDeck;
    }

    public void setMainDeck(ArrayList<Card> mainDeck) {
        this.mainDeck = mainDeck;
    }
}
