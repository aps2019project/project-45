package model;

import view.Battle;

import java.util.Random;

public class Item extends Card {
    private Card flagOwner = new Card();
    private boolean usable;



    public void wisdomCrown(String cardID) {
        Card targetCard = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().get(cardID);
        if (targetCard == null)
            targetCard = Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().get(cardID);
        //targetCard.MP++;
    }

    public void namoosShield() {
        Battle.getInstance().getActiveAccount().getHero().setHolyBuff(1, 12);
    }

    /*public void damoolArc() {
        if (Battle.getInstance().getActiveAccount().getHero().heroOrMinionType != HeroOrMinionType.MELEE) {
            //
        }
    }*/

    public void nooshdaroo() {
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size() + Battle.getInstance().getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseHealth(1,6);
                return;
            }
            count++;
        }
        for (Card targetCard : Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseHealth(1,6);
                return;
            }
            count++;
        }
    }

    /*public void towinArrow() {
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size() + Battle.getInstance().getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                if (targetCard.heroOrMinionType != HeroOrMinionType.MELEE) {
                    targetCard.setIncreaseAP(1, 2);
                    return;
                }
            }
            count++;
        }
        for (Card targetCard : Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                if (targetCard.heroOrMinionType != HeroOrMinionType.MELEE) {
                    targetCard.setIncreaseAP(1, 2);
                    return;
                }
            }
            count++;
        }
    }*/

    /*public void simorghFeather() {
        if (Battle.getInstance().getInActiveAccount().getHero().heroOrMinionType != HeroOrMinionType.MELEE) {
            Battle.getInstance().getInActiveAccount().getHero().setDecreaseAP(1, 2);
        }
    }*/

    public void elixir(String cardID) {
        Battle.getInstance().getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseHealth(1, 3);
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size() + Battle.getInstance().getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 3);
                return;
            }
            count++;
        }
        for (Card targetCard : Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 3);
                return;
            }
            count++;
        }
    }

    public void majooneRooyinTani() {
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setHolyBuff(2, 10);
                return;
            }
            count++;
        }
    }

    public void randomDamage() {
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size() + Battle.getInstance().getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 2);
                return;
            }
            count++;
        }
        for (Card targetCard : Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 2);
                return;
            }
            count++;
        }
    }

    public void bladesOfAgility () {
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size() + Battle.getInstance().getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 6);
                return;
            }
            count++;
        }
        for (Card targetCard : Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 6);
                return;
            }
            count++;
        }
    }

    public void kingWisdom(String cardID) {
        Battle.getInstance().getActiveAccount().getActiveCardsOnGround().get(cardID).MP++;
    }

    public void assessinationDagger() {
        Battle.getInstance().getInActiveAccount().getHero().setDecreaseHealth(1, 1);
    }

    public void poisonousDagger(String cardID) {
        int number = Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().values()) {
            if (count == randomCard) {
                targetCard.setDecreaseHealth(1, 1);
                return;
            }
            count++;
        }
    }

    public void shockHammer(String cardID) {
        Battle.getInstance().getInActiveAccount().getActiveCardsOnGround().get(cardID).setDisarmTurns(1);
    }

    public void soulEater() {
        int number = Battle.getInstance().getActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (count == randomCard) {
                targetCard.setIncreaseAP(1, 1);
                return;
            }
            count++;
        }
    }

    public void baptism() { // equals for "ghosl_e_ta'amid"   :)
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (targetCard instanceof Minion) {
                targetCard.setHolyBuff(2, 1);
            }
        }
    }

    public Card getFlagOwner() {
        return flagOwner;
    }

    public void setFlagOwner(Card flagOwner) {
        this.flagOwner = flagOwner;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    /*public void chineseSword() {
        for (Card targetCard : Battle.getInstance().getActiveAccount().getActiveCardsOnGround().values()) {
            if (targetCard.heroOrMinionType == HeroOrMinionType.MELEE) {
                targetCard.setIncreaseAP(1, 5);
            }
        }
    }*/
}
