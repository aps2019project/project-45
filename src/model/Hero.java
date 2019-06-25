package model;

public class Hero extends Card {
    private String heroClass;
    //private String specialPower;
    private Spell specialPower = new Spell();

    public String getHeroClass() {
        return heroClass;
    }

    public void setHeroClass(String heroClass) {
        this.heroClass = heroClass;
    }

    public Spell getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(Spell specialPower) {
        this.specialPower = specialPower;
    }

    /*public String getSpecialPower() {
        return specialPower;
    }
    public void setSpecialPower(String specialPower) {
        this.specialPower = specialPower;
    }*/
}
