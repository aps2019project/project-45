package model;

import view.Battle;


public class Spell extends Card {
    public Spell() {

    }

    private Battle battle = Battle.getInstance();


    public void setDisarmBuffTurns(String cardID, int disarmTurns) {
        if (disarmTurns > effectedCard(cardID).disarmTurns) {
            effectedCard(cardID).disarmTurns = disarmTurns;
        }
    }

    public void setStunBuffTurns(String cardID , int stunBuffTurns) {
        if (stunBuffTurns > effectedCard(cardID).stunBuffTurns)  {
            effectedCard(cardID).stunBuffTurns = stunBuffTurns;
        }
    }

    public void setPowerBuffTurns(String cardId , int powerBuffTurns) {
        effectedCard(cardId).powerBuffTurns += powerBuffTurns;
    }

    public void powerBuff(String cardID, int increaseAmount) {
        effectedCard(cardID).setAP(effectedCard(cardID).getAP() + increaseAmount);
    }

    public void setHealthBuffTurns(String cardID , int healthBuffTurns){
        effectedCard(cardID).healthBuffTurns += healthBuffTurns;
    }

    public void healthBuff(String cardID , int increaseAmount) {
        effectedCard(cardID).setHealth(effectedCard(cardID).getHealth() + increaseAmount);
    }

    public void setPowerWeaknessBuffTurns(String cardID , int powerWeaknessBuffTurns){
        effectedCard(cardID).powerWeaknessBuffTurns += powerWeaknessBuffTurns;

    }

    public void powerWeaknessBuff(String cardID, int decreaseAmount) {
        effectedCard(cardID).setMP(effectedCard(cardID).getAP() - decreaseAmount);
    }

    public void setHealthWeaknessBuffTurns (String cardID , int healthWeaknessBuffTurns){
        effectedCard(cardID).healthWeaknessBuffTurns += healthWeaknessBuffTurns;
    }

    public void healthWeaknessBuff(String cardID, int healthWeaknessAmount) {
        effectedCard(cardID).setHealth(effectedCard(cardID).getHealth() - healthWeaknessAmount);
    }

    public void setHolyBuffTurns(String cardID , int holyBuffTurns){
        effectedCard(cardID).holyBuffTurns += holyBuffTurns;
    }

    public void holyBuff(String cardID) {
        if (effectedCard(cardID).attacked) {
            effectedCard(cardID).setHealth(effectedCard(cardID).getHealth() + 1);
        }
    }

    public void kill(String cardID){
        effectedCard(cardID).getUserAccount().getGraveYard().add(effectedCard(cardID));
        effectedCard(cardID).getSquare().setCard(null);
    }

    public void squareEffect(int x, int y, String squareEffect, int squareEffectTurns, int squaresNum) {
        battle.getSquare()[x][y].setEffectTurns(squareEffectTurns);
        battle.getSquare()[x][y].setEffect(squareEffect);
        switch (squaresNum) {
            case 4:
                for (int i = x; i < x + 2; i++) {
                    for (int j = y; j < y + 2; j++) {
                        battle.getSquare()[i][j].setEffect(squareEffect);
                    }
                }
                break;
            case 9:
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        battle.getSquare()[i][j].setEffect(squareEffect);
                    }
                }
                break;

        }
    }

    //almozakhrafat
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

}