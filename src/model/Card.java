package model;

import java.util.ArrayList;

public class Card extends CardOrItem {
    public static ArrayList<Card> allCards = new ArrayList<>();
    private int health;
    private int AP;
    private int MP;

    private int disarmTurns = 0;
    private int powerBuffTurns = 0;
    private int holyBuffTurns = 0;
    private int stunTurns;
    private boolean attacked; // should be handled


    int getHealth() {
        return health;
    }

    void setHealth(int health) {
        this.health = health;
    }

    int getAP() {
        return AP;
    }

    void setAP(int AP) {
        this.AP = AP;
    }

    int getMP() {
        return MP;
    }

    void setMP(int MP) {
        this.MP = MP;
    }

    int getDisarmTurns() {
        return disarmTurns;
    }

    void setDisarmTurns(int disarmTurns) {
        this.disarmTurns = disarmTurns;
    }

    int getPowerBuffTurns() {
        return powerBuffTurns;
    }

    void setPowerBuffTurns(int powerBuffTurns) {
        this.powerBuffTurns = powerBuffTurns;
    }

    int getHolyBuffTurns() {
        return holyBuffTurns;
    }

    void setHolyBuffTurns(int holyBuffTurns) {
        this.holyBuffTurns = holyBuffTurns;
    }

    public int getStunTurns() {
        return stunTurns;
    }

    public void setStunTurns(int stunTurns) {
        this.stunTurns = stunTurns;
    }

    boolean isAttacked() {
        return attacked;
    }

    void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }
}