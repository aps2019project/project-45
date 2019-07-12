package model;

import view.Battle;

import java.util.ArrayList;
import java.util.Random;

public class Spell extends Card {
    //handling for checking if the target sociality is valid or not for future
    // so important ha
    private Battle battle = Battle.getInstance();

    private ArrayList<BuffType> buffTypes = new ArrayList<>();
    private ArrayList<Integer> effectValue = new ArrayList<>();
    private ArrayList<Integer> delay = new ArrayList<>();
    private ArrayList<Integer> last = new ArrayList<>();


    public void totalDisarm(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).setDisarmTurns(-1);
    }

    public void dispel(String cardID) {
        Card targetCard;
        targetCard = battle.getActiveAccount().getActiveCardsOnGround().get(cardID);
        if (targetCard != null) {
            targetCard.disarmTurns = 0;
            targetCard.stunTurns = 0;
            for (int i = 0; i < targetCard.decreaseAPturns.size(); i++) {
                if (targetCard.decreaseAPturns.get(i) != -10) {
                    targetCard.decreaseAPturns.remove(i);
                    targetCard.decreaseAPamount.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < targetCard.decreaseHealthTurns.size(); i++) {
                if (targetCard.decreaseHealthTurns.get(i) != -10) {
                    targetCard.decreaseHealthTurns.remove(i);
                    targetCard.decreaseHealthAmount.remove(i);
                    i--;
                }
            }//holy
            return;
        }
        targetCard = battle.getInActiveAccount().getActiveCardsOnGround().get(cardID);
        if (targetCard != null) {
            for (int i = 0; i < targetCard.increaseAPturns.size(); i++) {
                if (targetCard.increaseAPturns.get(i) != -10) {
                    targetCard.increaseAPturns.remove(i);
                    targetCard.increaseAPamount.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < targetCard.increaseHealthTurns.size(); i++) {
                if (targetCard.increaseHealthTurns.get(i) != -10) {
                    targetCard.increaseHealthTurns.remove(i);
                    targetCard.increaseHealthAmount.remove(i);
                    i--;
                }
            }
            for (int i = 0; i < targetCard.holyBuffTurns.size(); i++) {
                if (targetCard.holyBuffTurns.get(i) != -10) {
                    targetCard.holyBuffTurns.remove(i);
                    targetCard.holyBuffAmount.remove(i);
                    i--;
                }
            }

        }
    }

    public void empower(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseAP(1, 2);
    }

    public void fireball(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1, 4);
    }

    public void godStrength(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseAP(1, 4);
    }

    public void hellFire(int x, int y) {
        battle.getSquare()[y - 1][x - 1].
                setEffect(SquareEffect.FIERY, 2);
    }

    public void lightingBolt(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1, 8);
    }

    public void poisonLake(int x, int y) {
        battle.getSquare()[y - 1][x - 1].
                setEffect(SquareEffect.POISONOUS, 1);
    }

    public void madness(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseAP(3, 4);
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).setDisarmTurns(3);
    }

    public void allDisarm() {
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            targetCard.setDisarmTurns(1);
        }
    }

    public void allPoison() {
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            targetCard.setDecreaseHealth(4, 1);
        }
    }

    public void healthWithProfit(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1, 6);
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).setHolyBuff(3, 2);
    }

    public void powerUp(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseAP(1, 6);
    }

    public void allPower() {
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            targetCard.setIncreaseAP(-1, 2);
        }
    }

    public void allAttack(int x) {
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (targetCard.getSquare().getX() == x) {
                targetCard.setDecreaseHealth(1, 6);
            }
        }
    }

    public void weakening(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseAP(1, 4);
    }

    public void sacrifice(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1, 6);
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseAP(1, 8);
    }

    public boolean kingsGuard() {   //boolean / important
        int heroX = battle.getActiveAccount().getHero().getSquare().getX();
        int heroY = battle.getActiveAccount().getHero().getSquare().getY();
        ArrayList<Minion> besideMinions = new ArrayList<>();
        for (int i = heroY - 1; i < heroY + 2; i++) {
            for (int j = heroX - 1; j < heroX + 2; j++) {
                if (i >= 1 && i <= 5 && j >= 1 && j <= 9) {
                    if (battle.getSquare()[i][j].getCard() instanceof Minion) besideMinions.
                            add((Minion) battle.getSquare()[i][j].getCard());
                }
            }
        }
        if (besideMinions.size() == 0) return false;
        Random random = new Random();
        int randomMinion = random.nextInt(besideMinions.size());
        besideMinions.get(randomMinion).kill();
        return true;
    }

    public void shock(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).setStunTurns(2);
    }





    //special powers

    //minions spells
    public void farsSwordsman(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).setStunTurns(1);
    }

    public void turaniSpy(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).setDisarmTurns(1);
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(4, 1);
    }

    public void eagle(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).
                setIncreaseHealth(1, 10);
    }

    public void one_eyed_ogre(String cardID) {
        int cardX = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getX();
        int cardY = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getY();
        for (int i = cardY - 1; i < cardY + 2; i++) {
            for (int j = cardX - 1; j < cardX + 2; j++) {
                if (i == cardY && j == cardX) continue;
                if (i >= 1 && i <= 5 && j >= 1 && j <= 9) {
                    if (battle.getSquare()[i][j].getCard() instanceof Minion) {
                        battle.getSquare()[i][j].getCard().setDecreaseHealth(1, 2);
                    }
                }
            }
        }
    }

    public void poisonousSnake(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(3, 1);
    }

    public void giantSnake(String cardID) {
        int cardX = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getX();
        int cardY = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getY();
        for (int i = cardY - 1; i < cardY + 2; i++) {
            for (int j = cardX - 1; j < cardX + 2; j++) {
                if (i == cardY && j == cardX) continue;
                if (i >= 1 && i <= 5 && j >= 1 && j <= 9) {
                    if (battle.getSquare()[i][j].getCard() instanceof Minion) {
                        battle.getSquare()[i][j].getCard().setHolyBuff(-1, -1);
                    }
                }
            }
        }
        if (cardX - 1 >= 1 && cardY - 1 >= 1) {
            if (battle.getSquare()[cardY - 1 - 1][cardX - 1 - 1].getCard() instanceof Minion) {
                //bacause the number of squares begin from 1 not 0 but first index of arrays begin from 0
                battle.getSquare()[cardY - 1 - 1][cardX - 1 - 1].getCard().
                        setHolyBuff(-1, -1);
            }
        }
        if (cardX - 1 >= 1 && cardY + 1 <= 5) {
            if (battle.getSquare()[cardY + 1 - 1][cardX - 1 - 1].getCard() instanceof Minion) {
                battle.getSquare()[cardY + 1 - 1][cardX - 1 - 1].getCard().
                        setHolyBuff(-1, -1);
            }
        }
        if (cardX + 1 <= 9 && cardY - 1 >= 1) {
            if (battle.getSquare()[cardY - 1 - 1][cardX + 1 - 1].getCard() instanceof Minion) {
                battle.getSquare()[cardY - 1 - 1][cardX + 1 - 1].getCard().
                        setHolyBuff(-1, -1);
            }
        }
        if (cardX + 1 <= 9 && cardY + 1 <= 5) {
            if (battle.getSquare()[cardY + 1 - 1][cardX + 1 - 1].getCard() instanceof Minion) {
                battle.getSquare()[cardY + 1 - 1][cardX + 1 - 1].getCard().
                        setHolyBuff(-1, -1);
            }
        }
    }

    public void whiteWolf(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1001, 6);
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(2001, 4);
    }

    public void leopard(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1001, 8);
    }

    public void wolf(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(1001, 6);
    }

    public void magician(String cardID) {
        int cardX = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getX();
        int cardY = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getY();
        for (int i = cardY - 1; i < cardY + 2; i++) {
            for (int j = cardX - 1; j < cardX + 2; j++) {
                if (i >= 1 && i <= 5 && j >= 1 && j <= 9) {
                    if (battle.getSquare()[i][j].getCard() instanceof Minion) {
                        battle.getSquare()[i][j].getCard().setIncreaseAP(1, 2);
                        battle.getSquare()[i][j].getCard().setDecreaseHealth(1, 1);
                    }
                }
            }
        }
    }

    public void greatestMagician(String cardID) {
        int cardX = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getX();
        int cardY = battle.getActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getY();
        for (int i = cardY - 1; i < cardY + 2; i++) {
            for (int j = cardX - 1; j < cardX + 2; j++) {
                if (i >= 1 && i <= 5 && j >= 1 && j <= 9) {
                    if (battle.getSquare()[i][j].getCard() instanceof Minion) {
                        battle.getSquare()[i][j].getCard().setIncreaseAP(1, 2);
                        battle.getSquare()[i][j].getCard().setHolyBuff(-10, 1);
                    }
                }
            }
        }
    }

    public void jen() {
        for (Card targetCard :  battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (targetCard instanceof Minion) {
                targetCard.setIncreaseAP(-10, 1);
            }
        }
    }

    public void bahman() {
        int size = battle.getInActiveAccount().getActiveMinions().size();
        Random random = new Random();
        int randomMinion = random.nextInt(size);
        int count = 0;
        for (Card randomCard : battle.getInActiveAccount().getActiveMinions().values()) {
            if (randomMinion == count) {
                randomCard.setDecreaseHealth(1, 16);
                break;
            }
            count++;
        }
    }

    public void coolGrandma(String cardID) {
        int cardX = battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getX();
        int cardY = battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).getSquare().getY();
        for (int i = cardY - 1; i < cardY + 2; i++) {
            for (int j = cardX - 1; j < cardX + 2; j++) {
                if (i >= 1 && i <= 5 && j >= 1 && j <= 9) {
                    if (battle.getSquare()[i][j].getCard() instanceof Minion) {
                        battle.getSquare()[i][j].getCard().setStunTurns(1);
                    }
                }
            }
        }
    }

    public void steelMain(String cardID) {
        battle.getActiveAccount().getActiveCardsOnGround().get(cardID).setHolyBuff(1, 12);
    }

    public void siavash() {
        battle.getInActiveAccount().getHero().setDecreaseHealth(1,6);
    }


    //hero spells
    public void whiteOgre(String cardID) {
        battle.getActiveAccount().getHero().setIncreaseAP(1, 4);
    }

    public void seemorgh() {
        for (Card card : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            card.setStunTurns(1);
        }
    }

    public void seven_headed_dragon() {
        int number = battle.getActiveAccount().getActiveCardsOnGround().size() + battle.getInActiveAccount().
                getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setDisarmTurns(1);
                return;
            }
            count++;
        }
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (randomCard == count) {
                targetCard.setDisarmTurns(1);
                return;
            }
            count++;
        }
    }

    public void rakhsh() {
        Random random = new Random();
        int randomCard = random.nextInt(battle.getInActiveAccount().getActiveCardsOnGround().size());
        int count = 0;
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (count == randomCard) {
                targetCard.setStunTurns(1);
                return;
            }
            count++;
        }
    }

    public void zahhak(String cardID) {
        battle.getInActiveAccount().getActiveCardsOnGround().get(cardID).
                setDecreaseHealth(3, 1);
    }

    public void kave(int x, int y) {
        battle.getSquare()[y - 1][x - 1].setEffect(SquareEffect.HOLY, 3);
    }

    public void arash() {
        int cardY = battle.getActiveAccount().getHero().getSquare().getY();
        for (int i = 1; i < 10; i++) {
            if (battle.getSquare()[cardY - 1][i].getCard() != null) {
                battle.getSquare()[cardY - 1][i].getCard().
                        setDecreaseHealth(1, 4);
            }
        }
    }

    public void fable() {
        int number = battle.getInActiveAccount().getActiveCardsOnGround().size();
        Random random = new Random();
        int randomCard = random.nextInt(number);
        int count = 0;
        for (Card targetCard : battle.getInActiveAccount().getActiveCardsOnGround().values()) {
            if (count == randomCard) {
                dispel(targetCard.getCardID());
                return;
            }
            count++;
        }
    }

    public void esfandiyar() {
        battle.getActiveAccount().getHero().setHolyBuff(-10, 3);
    }
}
