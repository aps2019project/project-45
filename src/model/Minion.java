package model;

public class Minion extends Card {
    private HeroOrMinionType heroOrMinionType;

    @Override
    public HeroOrMinionType getHeroOrMinionType() {
        return heroOrMinionType;
    }

    @Override
    public void setHeroOrMinionType(HeroOrMinionType heroOrMinionType) {
        this.heroOrMinionType = heroOrMinionType;
    }
}
