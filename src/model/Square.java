package model;

public class Square {
    private int x;
    private int y;
    private int effectTurns;
    private String effect;
    private Card card;

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
    public int getEffectTurns() {
        return effectTurns;
    }
    public void setEffectTurns(int effectTurns) {
        this.effectTurns = effectTurns;
    }
    public String getEffect() {
        return effect;
    }
    public void setEffect(String effect) {
        this.effect = effect;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
}
