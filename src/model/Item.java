package model;

public class Item extends CardOrItem {
    private Card owner;

    public Card getOwner() {
        return owner;
    }
    public void setOwner(Card owner) {
        this.owner = owner;
    }
}
