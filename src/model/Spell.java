package model;

import view.Battle;


public class Spell extends Card {
    public Spell() {

    }

    private Battle battle = Battle.getInstance();

    private String desc;

    public void disarmBuff(String cardID, int disarmTurns) {
        effectedCard(cardID).setDisarmTurns(disarmTurns);
    }

    public void powerBuff(String cardID, int increaseAmount) {
        effectedCard(cardID).setAP(effectedCard(cardID).getAP() + increaseAmount);
    }

    public void powerWeaknessBuff(String cardID, int decreaseAmount) {
        effectedCard(cardID).setMP(effectedCard(cardID).getAP() - decreaseAmount);
    }

    public void healthWeaknessBuff(String cardID, int healthWeaknessAmount) {
        effectedCard(cardID).setHealth(effectedCard(cardID).getHealth() - healthWeaknessAmount);
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

    public void holyBuff(String cardID) {
        if (effectedCard(cardID).isAttacked()) {
            effectedCard(cardID).setHealth(effectedCard(cardID).getHealth() + 1);
        }
    }

    public void stunBuff(String cardID) {

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}