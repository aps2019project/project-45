package model;

public class Hero extends Card {
    private String heroClass;
    private Spell specialPower = new Spell();
    private int specialPowerCooldown;
    private HeroOrMinionType heroOrMinionType;
    private int range;





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

    public int getSpecialPowerCooldown() {
        return specialPowerCooldown;
    }

    public void setSpecialPowerCooldown(int specialPowerCooldown) {
        this.specialPowerCooldown = specialPowerCooldown;
    }

    public HeroOrMinionType getHeroOrMinionType() {
        return heroOrMinionType;
    }

    public void setHeroOrMinionType(HeroOrMinionType heroOrMinionType) {
        this.heroOrMinionType = heroOrMinionType;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
