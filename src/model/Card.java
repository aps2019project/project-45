package model;

import view.Battle;

import java.util.ArrayList;
import java.util.Random;

public class Card {
    private Battle battle = Battle.getInstance();

    private String name;
    private int cost;
    private int neededMana;
    private Square square = new Square();
    private Account userAccount;
    private String cardID;
    private String desk;
    private CardType cardType;
    private HeroOrMinionType heroOrMinionType;
    private boolean usableItem;
    private boolean collectible;
    private Card flagOwner;
    private int health;
    private int AP;






    private int disarmTurns;
    private int stunTurns;
    private ArrayList<Integer> increaseAPturns = new ArrayList<>();
    private ArrayList<Integer> increaseAPamount = new ArrayList<>();
    private ArrayList<Integer> decreaseAPturns = new ArrayList<>();
    private ArrayList<Integer> decreaseAPamount = new ArrayList<>();
    private ArrayList<Integer> increaseHealthTurns = new ArrayList<>();
    private ArrayList<Integer> increaseHealthAmount = new ArrayList<>();
    private ArrayList<Integer> decreaseHealthTurns  = new ArrayList<>();
    private ArrayList<Integer> decreaseHealthAmount = new ArrayList<>();
    private boolean attacked;
    private String effectTime;







    public void setDisarmTurns(int disarmTurns){
        if (disarmTurns == -1){
            this.disarmTurns = -1;
            return;
        }
        if (this.disarmTurns < disarmTurns) {
            this.disarmTurns = disarmTurns;
        }
    } //kollan disarm piyade sazi shod
    public void setStunTurns(int stunTurns){
        if (stunTurns == -1) {
            this.stunTurns = -1;
            return;
        }
        if (this.stunTurns < stunTurns){
            this.stunTurns = stunTurns;
        }
    } //kollan stun piyade sazi shod
    public void setIncreaseAP(int increaseAPturns , int increaseAPamount){
        if (increaseAPturns == -1) {
            this.increaseAPturns.add(-1);
            this.increaseAPamount.add(increaseAPamount);
            return;
        }
        this.increaseAPturns.add(increaseAPturns);
        this.increaseAPamount.add(increaseAPamount);
    }
    public void increaseAP(){
        for (Integer integer : increaseAPamount) {
            this.AP += integer;
        }
    }
    public void setDecreaseAP(int decreaseAPturns , int decreaseAPamount){
        if (decreaseAPturns == -1) {
            this.decreaseAPturns.add(-1);
            this.decreaseAPamount.add(decreaseAPamount);
            return;
        }
        this.decreaseAPturns.add(decreaseAPturns);
        this.decreaseAPamount.add(decreaseAPamount);
    }
    public void decreaseAP(){
        for (Integer integer : decreaseAPamount) {
            this.AP -= integer;
        }
    }
    public void setIncreaseHealthTurns(int increaseHealthTurns , int increaseHealthAmount){
        if (increaseHealthTurns == -1) {
            this.increaseHealthTurns.add(-1);
            this.increaseHealthAmount.add(increaseHealthAmount);
            return;
        }
        this.increaseHealthTurns.add(increaseHealthTurns);
        this.increaseHealthAmount.add(increaseHealthAmount);
    }
    public void increaseHealth(){
        for (Integer integer : increaseHealthAmount) {
            this.AP += integer;
        }
    }
    public void setDecreaseHealthTurns(int decreaseHealthTurns , int decreaseHealthAmount){
        if (decreaseHealthTurns == -1) {
            this.decreaseHealthTurns.add(-1);
            this.decreaseHealthAmount.add(decreaseHealthAmount);
            return;
        }
        this.decreaseHealthTurns.add(decreaseHealthTurns);
        this.decreaseHealthAmount.add(decreaseHealthAmount);
    }
    public void decreaseHealth(){
        for (Integer integer : decreaseHealthAmount) {
            this.AP -= integer;
        }
    }
    public void setSquareEffectTurns(int squareEffectTurns , int x , int y){
        battle.getSquare()[x][y].setSquareEffectTurns(squareEffectTurns);
    }
    public void setSquareEffect(String squareEffect , int x , int y) {
        if (squareEffect.equalsIgnoreCase("fiery")){
            battle.getSquare()[x][y].setSquareEffect(SquareEffect.FIERY);
        } else if (squareEffect.equalsIgnoreCase("poisonous")){
            battle.getSquare()[x][y].setSquareEffect(SquareEffect.POISONOUS);
        } else if (squareEffect.equalsIgnoreCase("holy")){
            battle.getSquare()[x][y].setSquareEffect(SquareEffect.HOLY);
        }
    }//it can contain int squareEffectTurns
    public void frustratrBuffs(){
        if (!this.getUserAccount().getUserName().equals(battle.getActiveAccount().getUserName())){
            for (int i = 0; i < increaseAPamount.size(); i++) {
                if (increaseAPamount.get(i) != -1){
                    increaseAPamount.remove(i);
                    increaseAPturns.remove(i);
                }
            }
            for (int i = 0; i < increaseHealthAmount.size(); i++) {
                if (increaseHealthAmount.get(i) != -1) {
                    increaseHealthAmount.remove(i);
                    increaseHealthTurns.remove(i);
                }
            }
        } else {
            for (int i = 0; i < decreaseAPamount.size(); i++) {
                if (decreaseAPamount.get(i) != -1){
                    decreaseAPamount.remove(i);
                    decreaseAPturns.remove(i);
                }
            }
            for (int i = 0; i < decreaseHealthAmount.size(); i++) {
                if (decreaseHealthAmount.get(i) != -1) {
                    decreaseHealthAmount.remove(i);
                    decreaseHealthTurns.remove(i);
                }
            }
        }
    }
    public void handleEffectTime(String time){
        if (true) {

        }
    }
    public void kill(){
        this.setSquare(null);
        this.getUserAccount().getGraveYard().add(this);
        this.getUserAccount().getActiveCardsOnGround().remove(this);
    }






    public Card randomCard(ArrayList<Card> cards){
        Random rand = new Random();
        int random = rand.nextInt(cards.size());
        return cards.get(random);
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

}



/*package model;

import java.util.ArrayList;

public class Card extends Card {
    public static ArrayList<Card> allCards = new ArrayList<>();
    private int health;
    private int AP;

    int disarmBuffTurns = 0;
    int powerBuffTurns = 0;
    int healthBuffTurns = 0;
    int powerWeaknessBuffTurns = 0;
    int healthWeaknessBuffTurns = 0;
    int holyBuffTurns = 0;
    int stunBuffTurns = 0;
    boolean attacked; // should be handled // should be false after anywhere it was true

    int increaseMPturns = 0;
    int increaseAPforRangedAndHybridTurns = 0;


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

}
*/