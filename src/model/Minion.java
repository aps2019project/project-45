package model;

public class Minion extends Card {
    private HeroOrMinionType heroOrMinionType;
    private Spell specialPower = new Spell();
    private MinionSpecialPowerActivation minionSpecialPowerActivation;
    private int range;


    public HeroOrMinionType getHeroOrMinionType() {
        return heroOrMinionType;
    }

    public void setHeroOrMinionType(HeroOrMinionType heroOrMinionType) {
        this.heroOrMinionType = heroOrMinionType;
    }

    public Spell getSpecialPower() {
        return specialPower;
    }

    public void setSpecialPower(Spell specialPower) {
        this.specialPower = specialPower;
    }

    public MinionSpecialPowerActivation getMinionSpecialPowerActivation() {
        return minionSpecialPowerActivation;
    }

    public void setMinionSpecialPowerActivation(MinionSpecialPowerActivation minionSpecialPowerActivation) {
        this.minionSpecialPowerActivation = minionSpecialPowerActivation;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
