package model;

import view.Battle;
import java.util.ArrayList;
import java.util.Random;

public class Card {
    Battle battle = Battle.getInstance();
    String name;
    int cost;
    int neededMana;
    Square square = new Square();
    Account userAccount;
    String cardID;
    String desk;
    CardType cardType;
    HeroOrMinionType heroOrMinionType;
    boolean usableItem;
    boolean collectible;
    Card flagOwner;
    int health;
    int AP;


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
        this.getUserAccount().getGraveYard().add(this);
        this.getUserAccount().getActiveMinions().remove(this);
        this.getUserAccount().getActiveCardsOnGround().remove(this);
        if (this instanceof Hero){
            this.getUserAccount().setHero(null);
        }
    }

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

    public int getNeededMana() {
        return neededMana;
    }

    public void setNeededMana(int neededMana) {
        this.neededMana = neededMana;
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

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public CardType getCardType() {
        return cardType;
    }

    public void setCardType(CardType cardType) {
        this.cardType = cardType;
    }

    public HeroOrMinionType getHeroOrMinionType() {
        return heroOrMinionType;
    }

    public void setHeroOrMinionType(HeroOrMinionType heroOrMinionType) {
        this.heroOrMinionType = heroOrMinionType;
    }

    public boolean isUsableItem() {
        return usableItem;
    }

    public void setUsableItem(boolean usableItem) {
        this.usableItem = usableItem;
    }

    public boolean isCollectible() {
        return collectible;
    }

    public void setCollectible(boolean collectible) {
        this.collectible = collectible;
    }

    public Card getFlagOwner() {
        return flagOwner;
    }

    public void setFlagOwner(Card flagOwner) {
        this.flagOwner = flagOwner;
    }

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

    public boolean isAttacked() {
        return attacked;
    }

    public void setAttacked(boolean attacked) {
        this.attacked = attacked;
    }

    public EffectTime getEffectTime() {
        return effectTime;
    }

    public void setEffectTime(EffectTime effectTime) {
        this.effectTime = effectTime;
    }

}
