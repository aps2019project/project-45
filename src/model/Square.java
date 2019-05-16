package model;

public class Square {
    private int x;
    private int y;
    private Card card;




    private SquareEffect squareEffect;
    private int squareEffectTurns;



    public void setSquareEffect(SquareEffect squareEffect) {
        this.squareEffect = squareEffect;
    }
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
    public void setSquareEffectTurns(int squareEffectTurns) {
        this.squareEffectTurns = squareEffectTurns;
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
}
