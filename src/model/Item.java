package model;

import view.Battle;

public class Item extends CardOrItem {
    private Battle battle = Battle.getInstance();
    private boolean Collectable;
    private boolean Usable;
    private Card flagOwner;

    public void setIncreaseMPturns(String cardID , int increaseMPturns) {
        effectedCard(cardID).increaseMPturns += increaseMPturns;
    }

    public void increaseMP(String cardID , int increaseAmount){
        effectedCard(cardID).setMP(effectedCard(cardID).getAP() + increaseAmount);
    }

    public void setHolyBuffTurns(String cardID , int holyBuffTurns){
        effectedCard(cardID).holyBuffTurns += holyBuffTurns;
    }





    private Card effectedCard(String cardID) {
        for (CardOrItem cardOrItem : battle.getInActiveAccount().getSelectedDeck()) {
            if (cardOrItem.getCardID().equals(cardID)) {
                return (Card) cardOrItem;
            }
        }
        for (CardOrItem cardOrItem : battle.getActiveAccount().getSelectedDeck()) {
            if (cardOrItem.getCardID().equals(cardID)) {
                return (Card) cardOrItem;
            }
        }
        return null;
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
    public Card getFlagOwner() {
        return flagOwner;
    }
    public void setFlagOwner(Card flagOwner) {
        this.flagOwner = flagOwner;
    }
}
