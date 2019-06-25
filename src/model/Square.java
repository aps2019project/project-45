package model;

public class Square {
    private int x;
    private int y;
    private Card card;

    private SquareEffect effect;
    private int effectTurns;

    public void fieryEffect(Card effectedCard){
        effectedCard.setHealth(effectedCard.getHealth() - 2);
    }

    public void poisinousEffect(Card effectedCard){
        effectedCard.setHealth(effectedCard.getHealth() - 1);
    }

    public void holyEffect(Card effectedCard){
        if (effectedCard.isAttacked()) {
            effectedCard.setHealth(effectedCard.getHealth() + 1);
        }
    }

    public void setEffect(SquareEffect squareEffect, int effectTurns) {
        this.effect = squareEffect;
        this.effectTurns = effectTurns;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public SquareEffect getEffect() {
        return effect;
    }

    public int getEffectTurns() {
        return effectTurns;
    }
}
