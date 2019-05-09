package model;

public class Item extends CardOrItem {
    private Card owner;
    private String desc;
    private boolean Collectable;
    private boolean Usable;

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

    public boolean isCollectable() {
        return Collectable;
    }
    public void setCollectable(boolean collectable) {
        Collectable = collectable;
    }
    public boolean isUsable() {
        return Usable;
    }
    public void setUsable(boolean usable) {
        Usable = usable;
    }
}
