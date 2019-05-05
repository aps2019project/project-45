package model;

public class Minion extends Card {
    private String minionClass;
    private String specialPower;

    public String getMinionClass() {
        return minionClass;
    }
    public void setMinionClass(String minionClass) {
        this.minionClass = minionClass;
    }
    public String getSpecialPower() {
        return specialPower;
    }
    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }
}
