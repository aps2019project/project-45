package model;

public class Card {

    private int money;
    private int x;
    private int y;
    private Account owner;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }

    public void goToGraveYard(){
        this.owner.getPlayerGraveYard().add(this);
    }

}
