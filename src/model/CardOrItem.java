package model;

public class CardOrItem {
    private String name;
    private int cost;
    private Square square;
    private Account userAccount;
    private String cardID;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public Square getSquare() {
        return square;
    }
    public void setSquare(Square square) {
        this.square = square;
    }
    public Account getUserAccountOwner() {
        return userAccount;
    }
    public void setUserAccountOwner(Account accountOwner) {
        this.userAccount = accountOwner;
    }
    public String getCardID() {
        return cardID;
    }
    public void setCardID(String cardID) {
        this.cardID = cardID;
    }


}
