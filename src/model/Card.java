package model;

import java.util.ArrayList;

public class Card extends CardOrItem {
    public static ArrayList<Card> allCards = new ArrayList<>();
    private int health;
    private int AP;
    private int MP;


    int disarmTurns = 0;
    int powerBuffTurns = 0;
    int healthBuffTurns = 0;
    int powerWeaknessBuffTurns = 0;
    int healthWeaknessBuffTurns = 0;
    int holyBuffTurns = 0;
    int stunBuffTurns = 0;
    boolean attacked; // should be handled // should be false after anywhere it was true

    int increaseMPturns = 0;

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
