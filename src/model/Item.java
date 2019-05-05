package model;

public class Item extends CardOrItem {
    private Card owner;
    private String desc;

    public Card getOwner() {
        return owner;
    }
    public void setOwner(Card owner) {
        this.owner = owner;
    }
    public String getDesc() {
        return desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }

}
