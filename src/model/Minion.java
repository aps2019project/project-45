package model;

public class Minion extends Card {
    private Spell specialPower = new Spell();
    private HeroOrMinionType heroOrMinionType;



    public Spell getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(Spell specialPower) {
        this.specialPower = specialPower;
    }

    @Override
    public HeroOrMinionType getHeroOrMinionType() {
        return heroOrMinionType;
    }

    @Override
    public void setHeroOrMinionType(HeroOrMinionType heroOrMinionType) {
        this.heroOrMinionType = heroOrMinionType;
    }
}
