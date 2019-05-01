package model;

public class Card extends CardOrItem {
    private int health;
    private String cardID;
    private int AP;

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public String getCardID() {
        return cardID;
    }
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }
    public int getAP() {
        return AP;
    }
    public void setAP(int AP) {
        this.AP = AP;
    }
}
