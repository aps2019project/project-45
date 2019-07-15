package model;

import java.util.Random;

public class Item extends Card {
    private Card flagOwner = new Card();
    private boolean usable;



    public void wisdomCrown(String cardID) {
        Card targetCard = battle.getActiveAccount().getActiveCardsOnGround().get(cardID);
        if (targetCard == null)
            targetCard = battle.getInActiveAccount().getActiveCardsOnGround().get(cardID);
        //targetCard.MP++;
    }

    public void namoosShield() {
        battle.getActiveAccount().getHero().setHolyBuff(1, 12);
    }

    /*public void damoolArc() {
        if (battle.getActiveAccount().getHero().heroOrMinionType != HeroOrMinionType.MELEE) {
            //
        }
    }*/

    public void nooshdaroo() {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size() + battle.getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseHealth(1,6);
                return;
            }
            count++;
        }
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseHealth(1,6);
                return;
            }
            count++;
        }
    }

    /*public void towinArrow() {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size() + battle.getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                if (targetCard.heroOrMinionType != HeroOrMinionType.MELEE) {
                    targetCard.setIncreaseAP(1, 2);
                    return;
                }
            }
            count++;
        }
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
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
        if (battle.getInActiveAccount().getHero().heroOrMinionType != HeroOrMinionType.MELEE) {
            battle.getInActiveAccount().getHero().setDecreaseAP(1, 2);
        }
    }*/

    public void elixir(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseHealth(1, 3);
        int number = battle.getActiveAccount().getActiveCardsOnGround().size() + battle.getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 3);
                return;
            }
            count++;
        }
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 3);
                return;
            }
            count++;
        }
    }

    public void majooneRooyinTani() {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setHolyBuff(2, 10);
                return;
            }
            count++;
        }
    }

    public void randomDamage() {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size() + battle.getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 2);
                return;
            }
            count++;
        }
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 2);
                return;
            }
            count++;
        }
    }

    public void bladesOfAgility () {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size() + battle.getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 6);
                return;
            }
            count++;
        }
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setIncreaseAP(1, 6);
                return;
            }
            count++;
        }
    }

    public void kingWisdom(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).MP++;
    }

    public void assessinationDagger() {
        battle.getInActiveAccount().getHero().setDecreaseHealth(1, 1);
    }

    public void poisonousDagger(String cardID) {
        int number = battle.getInActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (count == randomCard) {
                targetCard.setDecreaseHealth(1, 1);
                return;
            }
            count++;
        }
    }

    public void shockHammer(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).setDisarmTurns(1);
    }

    public void soulEater() {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (count == randomCard) {
                targetCard.setIncreaseAP(1, 1);
                return;
            }
            count++;
        }
    }

    public void baptism() { // equals for "ghosl_e_ta'amid"   :)
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
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
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (targetCard.heroOrMinionType == HeroOrMinionType.MELEE) {
                targetCard.setIncreaseAP(1, 5);
            }
        }
    }*/
}
