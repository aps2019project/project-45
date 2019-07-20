package model;

import javafx.scene.image.Image;
import view.Battle;


import java.util.ArrayList;

public class Card implements Cloneable {
    //Battle battle = Battle.getInstance();

    String name;
    int cost;
    int MP;
    Square square;
    Account userAccount;
    String cardID;
    int health;
    int AP;
    String imageName;

    int disarmTurns;
    int stunTurns;
    ArrayList<Integer> increaseAPturns = new ArrayList<>();
    ArrayList<Integer> increaseAPamount = new ArrayList<>();
    ArrayList<Integer> decreaseAPturns = new ArrayList<>();
    ArrayList<Integer> decreaseAPamount = new ArrayList<>();
    ArrayList<Integer> holyBuffTurns = new ArrayList<>();
    ArrayList<Integer> holyBuffAmount = new ArrayList<>();
    ArrayList<Integer> increaseHealthTurns = new ArrayList<>();
    ArrayList<Integer> increaseHealthAmount = new ArrayList<>();
    ArrayList<Integer> decreaseHealthTurns = new ArrayList<>();
    ArrayList<Integer> decreaseHealthAmount = new ArrayList<>();
    boolean attacked;
    EffectTime effectTime;


    public void setDisarmTurns(int disarmTurns) {
        if (disarmTurns == -1) {
            this.disarmTurns = -1;
            return;
        }
        if (this.disarmTurns < disarmTurns) {
            this.disarmTurns = disarmTurns;
        }
    }

    public void setStunTurns(int stunTurns) {
        if (stunTurns == -1) {
            this.stunTurns = -1;
            return;
        }
        if (this.stunTurns < stunTurns) {
            this.stunTurns = stunTurns;
        }
    }

    public void setIncreaseAP(int increaseAPturns, int increaseAPamount) {
        if (increaseAPturns == -1) {
            this.increaseAPturns.add(-1);
            this.increaseAPamount.add(increaseAPamount);
            return;
        }
        this.increaseAPturns.add(increaseAPturns);
        this.increaseAPamount.add(increaseAPamount);
    }

    public void increaseAP() {
        for (Integer integer : increaseAPamount) {
            this.AP += integer;
        }
    }

    public void setDecreaseAP(int decreaseAPturns, int decreaseAPamount) {
        if (decreaseAPturns == -1) {
            this.decreaseAPturns.add(-1);
            this.decreaseAPamount.add(decreaseAPamount);
            return;
        }
        this.decreaseAPturns.add(decreaseAPturns);
        this.decreaseAPamount.add(decreaseAPamount);
    }

    public void decreaseAP() {
        for (Integer integer : decreaseAPamount) {
            this.AP -= integer;
        }
    }

    public void setHolyBuff(int holyBuffTurns, int holyBuffAmount) {
        this.holyBuffTurns.add(holyBuffTurns);
        this.holyBuffAmount.add(holyBuffAmount);
    }

    public void setIncreaseHealth(int increaseHealthTurns, int increaseHealthAmount) {
        if (increaseHealthTurns == -1) {
            this.increaseHealthTurns.add(-1);
            this.increaseHealthAmount.add(increaseHealthAmount);
            return;
        }
        this.increaseHealthTurns.add(increaseHealthTurns);
        this.increaseHealthAmount.add(increaseHealthAmount);
    }

    public void increaseHealth() {
        for (Integer integer : increaseHealthAmount) {
            this.AP += integer;
        }
    }

    public void setDecreaseHealth(int decreaseHealthTurns, int decreaseHealthAmount) {
        if (decreaseHealthTurns == -1) {
            this.decreaseHealthTurns.add(-1);
            this.decreaseHealthAmount.add(decreaseHealthAmount);
            return;
        }
        this.decreaseHealthTurns.add(decreaseHealthTurns);
        this.decreaseHealthAmount.add(decreaseHealthAmount);
    }

    public void decreaseHealth() {
        for (Integer integer : decreaseHealthAmount) {
            this.AP -= integer;
        }
    }

    public void handleEffectTime(String time) {
        if (true) {

        }
    }

    void kill() {
        this.setSquare(null);
        this.userAccount.getGraveYard().add(this);
        this.userAccount.getActiveMinions().remove(this);
        this.userAccount.getActiveCardsOnGround().remove(this);
        if (this instanceof Hero){
            this.userAccount.setHero(null);
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }



    public Square getSquare() {
        return square;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Account getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Account userAccount) {
        this.userAccount = userAccount;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAP() {
        return AP;
    }

    public void setAP(int AP) {
        this.AP = AP;
    }

    public ArrayList<Integer> getDecreaseHealthAmount() {
        return decreaseHealthAmount;
    }

    public ArrayList<Integer> getDecreaseHealthTurns() {
        return decreaseHealthTurns;
    }

    public ArrayList<Integer> getIncreaseHealthAmount() {
        return increaseHealthAmount;
    }

    public ArrayList<Integer> getIncreaseHealthTurns() {
        return increaseHealthTurns;
    }

    public ArrayList<Integer> getHolyBuffAmount() {
        return holyBuffAmount;
    }

    public ArrayList<Integer> getHolyBuffTurns() {
        return holyBuffTurns;
    }

    public ArrayList<Integer> getDecreaseAPamount() {
        return decreaseAPamount;
    }

    public ArrayList<Integer> getDecreaseAPturns() {
        return decreaseAPturns;
    }

    public ArrayList<Integer> getIncreaseAPturns() {
        return increaseAPturns;
    }

    public ArrayList<Integer> getIncreaseAPamount() {
        return increaseAPamount;
    }

    public int getStunTurns() {
        return stunTurns;
    }

    public int getDisarmTurns() {
        return disarmTurns;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
