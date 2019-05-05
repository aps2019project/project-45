package model;

public class Hero extends Card {
    private String heroClass;
    private String specialPower;

    public String getHeroClass() {
        return heroClass;
    }
    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }
    public String getSpecialPower() {
        return specialPower;
    }
    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }
}
