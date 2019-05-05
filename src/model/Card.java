package model;

import java.util.ArrayList;

public class Card extends CardOrItem {
    public static ArrayList<Card> allCards = new ArrayList<>();
    private int health;
    private int AP;
    private int MP;

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public int getAP() {
        return AP;
    }
    public void setAP(int AP) {
        this.AP = AP;
    }
    public int getMP() {
        return MP;
    }
    public void setMP(int MP) {
        this.MP = MP;
    }
}
