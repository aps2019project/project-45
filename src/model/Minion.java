package model;

public class Minion extends Card {
    private HeroOrMinionType heroOrMinionType;
    private Spell specialPower = new Spell();
    private MinionSpecialPowerActivation minionSpecialPowerActivation;

    @Override
    public HeroOrMinionType getHeroOrMinionType() {
        return heroOrMinionType;
    }

    @Override
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
}
