package view.menus;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;
import javafx.scene.Group;
import view.Battle;

import javax.xml.soap.Text;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomCardMenu extends Menu {

    private static final CustomCardMenu CUSTOM_CARD_MENU = new CustomCardMenu();
    private CustomCardMenu() {}
    public static CustomCardMenu getInstance() {return CUSTOM_CARD_MENU;}

    private static Battle battle = Battle.getInstance();
    @Override
    public void help(Stage primaryStage) {

    }

    @Override
    public void open(Stage primaryStage) {
        Group root = (Group) primaryStage.getScene().getRoot();
        primaryStage.getScene().getRoot().setStyle("-fx-font-size: 15");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(15);
        grid.setVgap(15);
        grid.setLayoutX(550);
        grid.setLayoutY(100);

        Button OK = new Button("OK");
        OK.setLayoutX(550);
        OK.setLayoutY(650);
        OK.setStyle("-fx-font-size: 15");

        HBox radioList = new HBox();
        HBox radioList1 = new HBox();
        HBox radioList2 = new HBox();
        radioList.setSpacing(15);
        radioList1.setSpacing(15);
        radioList2.setSpacing(15);

        radioList.setLayoutX(320);
        radioList.setLayoutY(520);
        radioList1.setLayoutX(320);
        radioList1.setLayoutY(560);
        radioList2.setLayoutX(320);
        radioList2.setLayoutY(600);

        Label AP = new Label("AP :");
        Label HP = new Label("HP :");
        Label MP = new Label("MP : ");
        Label attackType = new Label("Attack Type :");
        Label range = new Label("Range :");
        Label specialPower = new Label("Special Power :");
        Label specialPowerActivation = new Label("Special Power Activation :");
        Label specialPowerCooldown = new Label("Special Power Cooldown :");
        Label cost = new Label("Cost :");
        Label buffType = new Label("Buff Type :");
        Label effectValue = new Label("Effect Value :");
        Label delay = new Label("Delay");
        Label last = new Label("Last :");
        Label name = new Label("Name :");
        Label type = new Label("Type :");
        Label target = new Label("Target :");
        Button addbuffs = new Button("Add buffs");
        RadioButton oneEnemy = new RadioButton("One Enemy");
        RadioButton oneRandomEnemy = new RadioButton("One Random Enemy");
        RadioButton oneFriend = new RadioButton("one Friend");
        RadioButton oneRandomFriend = new RadioButton("One Random Friend");
        RadioButton allEnemy = new RadioButton("Whole Enemies");
        RadioButton allFriend = new RadioButton("Whole Friends");
        RadioButton allEnemyInColumn = new RadioButton("Whole Enemies In Column");
        RadioButton enemyHero = new RadioButton("Enemy Hero");
        RadioButton friendHero = new RadioButton("Friend Hero");
        RadioButton twoCrossTwoSquares = new RadioButton("Two Cross Two Squares");
        RadioButton threeCrossThreeSquares = new RadioButton("Three Cross Three Squares");
        RadioButton oneRandomEnemyBesideFriendHero = new RadioButton("One Random Enemy Beside Friend Hero");
        RadioButton allFriendMinionsBesideYou = new RadioButton("All Friend Minions Beside You");

        radioList.getChildren().addAll(oneEnemy, oneRandomEnemy, oneFriend, oneRandomFriend, allEnemy);
        radioList1.getChildren().addAll(twoCrossTwoSquares, allFriend, allEnemyInColumn, enemyHero, friendHero );
        radioList2.getChildren().addAll(threeCrossThreeSquares, oneRandomEnemyBesideFriendHero,
                allFriendMinionsBesideYou);

        TextField nameText = new TextField();
        TextField typeText = new TextField();
        TextField costText = new TextField();
        RadioButton holy = new RadioButton("Holy");
        RadioButton power = new RadioButton("Power");
        RadioButton health = new RadioButton("Health");
        RadioButton poison = new RadioButton("Poison");
        RadioButton weakness = new RadioButton("Weakness");
        RadioButton stun = new RadioButton("Stun");
        RadioButton disarm = new RadioButton("Disarm");
        HBox buffsHbox = new HBox();
        buffsHbox.setSpacing(10);
        buffsHbox.setLayoutX(735);
        buffsHbox.setLayoutY(240);
        buffsHbox.getChildren().addAll(holy, power, health, poison, weakness, stun, disarm);
        TextField effectValueText = new TextField();
        TextField delayText = new TextField("0");
        TextField lastText = new TextField();
        TextField APText = new TextField();
        TextField HPText = new TextField();
        TextField MPText = new TextField();
        RadioButton melee = new RadioButton("Melee");
        RadioButton ranged = new RadioButton("Ranged");
        RadioButton hybrid = new RadioButton("Hybrid");
        HBox attackTypeHbox = new HBox();
        attackTypeHbox.setSpacing(15);
        attackTypeHbox.getChildren().addAll(melee, ranged, hybrid);
        TextField rangeText = new TextField();
        TextField specialPowerText = new TextField();
        RadioButton onAttack = new RadioButton("On Attack");
        RadioButton combo = new RadioButton("Combo");
        RadioButton passive = new RadioButton("Passive");
        RadioButton onDeath = new RadioButton("On Death");
        RadioButton onSpown = new RadioButton("On Spown");
        RadioButton onTurn = new RadioButton("On Turn");
        RadioButton onDefend = new RadioButton("On Defend");
        HBox minionSpecialPowerActivation = new HBox();
        minionSpecialPowerActivation.setSpacing(5);
        minionSpecialPowerActivation.setLayoutX(735);
        minionSpecialPowerActivation.setLayoutY(425);
        minionSpecialPowerActivation.getChildren().addAll(onAttack, combo, passive, onDeath, onSpown, onTurn, onDefend);
        TextField specialPowerCooldownText = new TextField();

        target.setVisible(false);
        addbuffs.setVisible(false);
        radioList.setVisible(false);
        radioList1.setVisible(false);
        radioList2.setVisible(false);
        AP.setVisible(false);
        HP.setVisible(false);
        MP.setVisible(false);
        attackType.setVisible(false);
        range.setVisible(false);
        specialPower.setVisible(false);
        specialPowerActivation.setVisible(false);
        specialPowerCooldown.setVisible(false);
        buffType.setVisible(false);
        buffsHbox.setVisible(false);
        effectValue.setVisible(false);
        delay.setVisible(false);
        last.setVisible(false);
        effectValueText.setVisible(false);
        delayText.setVisible(false);
        lastText.setVisible(false);
        APText.setVisible(false);
        HPText.setVisible(false);
        MPText.setVisible(false);
        attackTypeHbox.setVisible(false);
        rangeText.setVisible(false);
        specialPowerText.setVisible(false);
        specialPowerCooldownText.setVisible(false);
        minionSpecialPowerActivation.setVisible(false);

        grid.add(name, 0, 0);
        grid.add(type, 0, 1);
        grid.add(AP, 0, 2);
        grid.add(HP, 0, 3);
        grid.add(attackType, 0, 4);
        grid.add(range, 0, 5);
        grid.add(specialPower, 0, 6);
        grid.add(specialPowerActivation, 0, 7);
        grid.add(specialPowerCooldown, 0, 7);
        grid.add(addbuffs, 0, 2);
        grid.add(buffType, 0, 3);
        grid.add(effectValue, 0, 4);
        grid.add(delay, 0, 5);
        grid.add(last, 0, 6);
        grid.add(nameText, 1, 0);
        grid.add(typeText, 1, 1);
        grid.add(effectValueText, 1, 4);
        grid.add(delayText, 1, 5);
        grid.add(lastText, 1, 6);
        grid.add(APText, 1, 2);
        grid.add(HPText, 1, 3);
        grid.add(attackTypeHbox, 1, 4);
        grid.add(rangeText, 1, 5);
        grid.add(specialPowerText, 1, 6);
        grid.add(specialPowerCooldownText, 1, 7);
        grid.add(cost, 0, 8);
        grid.add(costText, 1, 8);
        grid.add(MP, 0, 9);
        grid.add(MPText, 1, 9);
        root.getChildren().addAll(grid, radioList, radioList1, radioList2, buffsHbox, minionSpecialPowerActivation, OK);

        primaryStage.setTitle("Custom Card Menu");
        primaryStage.show();

        final Card[] card = new Card[1];
        typeText.setOnKeyPressed(event -> typeText.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().equalsIgnoreCase("spell")) {
                card[0] = new Spell();
                addbuffs.setVisible(true);
                buffType.setVisible(true);
                effectValue.setVisible(true);
                delay.setVisible(true);
                last.setVisible(true);
                buffsHbox.setVisible(true);
                effectValueText.setVisible(true);
                delayText.setVisible(true);
                lastText.setVisible(true);
                radioList.setVisible(true);
                radioList1.setVisible(true);
                radioList2.setVisible(true);
            } else if (change.getControlNewText().equalsIgnoreCase("minion")) {
                card[0] = new Minion();
                AP.setVisible(true);
                HP.setVisible(true);
                attackType.setVisible(true);
                specialPower.setVisible(true);
                specialPowerActivation.setVisible(true);
                APText.setVisible(true);
                HPText.setVisible(true);
                MP.setVisible(true);
                MPText.setVisible(true);
                attackTypeHbox.setVisible(true);
                specialPowerText.setVisible(true);
                minionSpecialPowerActivation.setVisible(true);
            } else if (change.getControlNewText().equalsIgnoreCase("hero")) {
                card[0] = new Hero();
                AP.setVisible(true);
                HP.setVisible(true);
                MP.setVisible(true);
                attackType.setVisible(true);
                specialPower.setVisible(true);
                specialPowerCooldown.setVisible(true);
                APText.setVisible(true);
                HPText.setVisible(true);
                MPText.setVisible(true);
                attackTypeHbox.setVisible(true);
                specialPowerText.setVisible(true);
                specialPowerCooldownText.setVisible(true);
            } else {
                target.setVisible(false);
                addbuffs.setVisible(false);
                radioList.setVisible(false);
                radioList1.setVisible(false);
                radioList2.setVisible(false);
                AP.setVisible(false);
                HP.setVisible(false);
                MP.setVisible(false);
                attackType.setVisible(false);
                range.setVisible(false);
                specialPower.setVisible(false);
                specialPowerActivation.setVisible(false);
                specialPowerCooldown.setVisible(false);
                buffType.setVisible(false);
                effectValue.setVisible(false);
                delay.setVisible(false);
                last.setVisible(false);
                effectValueText.setVisible(false);
                delayText.setVisible(false);
                lastText.setVisible(false);
                APText.setVisible(false);
                HPText.setVisible(false);
                MPText.setVisible(false);
                attackTypeHbox.setVisible(false);
                rangeText.setVisible(false);
                specialPowerText.setVisible(false);
                specialPowerCooldownText.setVisible(false);
                minionSpecialPowerActivation.setVisible(false);
                buffsHbox.setVisible(false);
            }
            return change;
        })));

        final boolean[] rangedOnAction = {false};
        ranged.setOnAction(event -> {
            rangedOnAction[0] = (!rangedOnAction[0]);
            if (rangedOnAction[0]) {
                range.setVisible(true);
                rangeText.setVisible(true);
            } else {
                range.setVisible(false);
                rangeText.setVisible(false);
            }
        });

        addbuffs.setOnAction(event -> {
            Spell spell = (Spell) card[0];
            RadioButton radioButton = null;
            for (Node radio : buffsHbox.getChildren()) {
                RadioButton radioButtonInFor = (RadioButton) radio;
                if (radioButtonInFor.isSelected()) {
                    radioButton = radioButtonInFor;
                    break;
                }
            }
            setSpellFeatures(holy, power, health, poison, weakness, stun, disarm, effectValueText, delayText, lastText,
                    spell);
            holy.setSelected(false);
            poison.setSelected(false);
            power.setSelected(false);
            weakness.setSelected(false);
            stun.setSelected(false);
            disarm.setSelected(false);
            effectValueText.setText("");
            delayText.setText("");
            lastText.setText("");
            setDesc(radioList, holy, power, health, poison, weakness, stun, disarm, spell, radioButton);
            setDesc(radioList1, holy, power, health, poison, weakness, stun, disarm, spell, radioButton);
            setDesc(radioList2, holy, power, health, poison, weakness, stun, disarm, spell, radioButton);
        });

        OK.setOnAction(event -> {
            card[0].setName(nameText.getText());
            card[0].setCost(Integer.parseInt(costText.getText()));
            if (typeText.getText().equalsIgnoreCase("minion")) {
                Minion minion = (Minion) card[0];
                minion.setAP(Integer.parseInt(APText.getText()));
                minion.setHealth(Integer.parseInt(HPText.getText()));
                minion.setMP(Integer.parseInt(MPText.getText()));
                setSpecialPower(specialPowerText, minion);
                setHeroOrMinionType(melee, ranged, hybrid, rangeText, minion);
                setMinionSpecialPowerActivation(onAttack, combo, passive, onDeath, onSpown, onTurn, onDefend,
                        minionSpecialPowerActivation, minion);
                setMinionSpellActivation(onAttack, combo, passive, onDeath, onSpown, onTurn, onDefend, minion);
            } else if (typeText.getText().equalsIgnoreCase("hero")) {
                Hero hero = (Hero) card[0];
                hero.setAP(Integer.parseInt(APText.getText()));
                hero.setHealth(Integer.parseInt(HPText.getText()));
                hero.setMP(Integer.parseInt(MPText.getText()));
                setHeroOrMinionType(melee, ranged, hybrid, rangeText, hero);
                setSpecialPower1(specialPowerText, hero);
                hero.setSpecialPowerCooldown(Integer.parseInt(specialPowerCooldownText.getText()));

            }
            if (ranged.isSelected()) {
                card[0].setRange(Integer.parseInt(rangeText.getText()));
            }
            String cardID = battle.getActiveAccount().getUsername() + "_" + card[0].getName() + "_1";
            card[0].setCardID(cardID);

            ObjectMapper mapper = new ObjectMapper();
            try {
                String json = mapper.writeValueAsString(card[0]);
                BufferedWriter out = new BufferedWriter(new FileWriter("cards.txt", true));
                out.write(json + "\n");
                out.close();
                exit(primaryStage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void setMinionSpellActivation(RadioButton onAttack, RadioButton combo, RadioButton passive,
                                          RadioButton onDeath, RadioButton onSpown, RadioButton onTurn,
                                          RadioButton onDefend, Minion minion) {
        if (onAttack.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_ATTACK);
        } else if (combo.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.COMBO);
        } else if (passive.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.PASSIVE);
        } else if (onDeath.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_DEATH);
        } else if (onSpown.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_SPOWN);
        } else if (onTurn.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_TURN);
        } else if (onDefend.isSelected()) {
            minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_DEFEND);
        }
    }

    private void setSpellFeatures(RadioButton holy, RadioButton power, RadioButton health, RadioButton poison,
                                  RadioButton weakness, RadioButton stun, RadioButton disarm, TextField effectValueText,
                                  TextField delayText, TextField lastText, Spell spell) {
        if (holy.isSelected()) {
            spell.setHolyBuff(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()), Integer.parseInt(effectValueText.getText()));
        } else if (power.isSelected()) {
            spell.setIncreaseAP(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()), Integer.parseInt(effectValueText.getText()));
        } else if (health.isSelected()) {
            spell.setIncreaseHealth(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()), Integer.parseInt(effectValueText.getText()));
        } else if (poison.isSelected()) {
            spell.setDecreaseHealth(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()), Integer.parseInt(effectValueText.getText()));
        } else if (weakness.isSelected()) {
            spell.setDecreaseAP(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()), Integer.parseInt(effectValueText.getText()));
        } else if (stun.isSelected()) {
            spell.setStunTurns(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()));
        } else if (disarm.isSelected()) {
            spell.setDisarmTurns(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()));
        }
    }

    private void setSpecialPower1(TextField specialPowerText, Hero hero) {
        if (Shop.cards.containsKey(specialPowerText.getText())) {
            try {
                Spell spell = (Spell) Shop.cards.get(specialPowerText.getText()).clone();
                hero.setSpecialPower(spell);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setSpecialPower(TextField specialPowerText, Minion minion) {
        if (Shop.cards.containsKey(specialPowerText.getText())) {
            try {
                Spell spell = (Spell) Shop.cards.get(specialPowerText.getText()).clone();
                minion.setSpecialPower(spell);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    private void setMinionSpecialPowerActivation(RadioButton onAttack, RadioButton combo, RadioButton passive,
                                                 RadioButton onDeath, RadioButton onSpown, RadioButton onTurn,
                                                 RadioButton onDefend, HBox minionSpecialPowerActivation, Minion minion)
    {
        for (Node radio : minionSpecialPowerActivation.getChildren()) {
            RadioButton radioButton = (RadioButton) radio;
            if (radioButton.isSelected()) {
                if (onAttack.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_ATTACK);
                } else if (combo.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.COMBO);
                } else if (passive.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.PASSIVE);
                } else if (onDeath.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_DEATH);
                } else if (onSpown.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_SPOWN);
                } else if (onTurn.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_TURN);
                } else if (onDefend.equals(radioButton)) {
                    minion.setMinionSpecialPowerActivation(MinionSpecialPowerActivation.ON_DEFEND);
                }
                break;
            }
        }
    }

    private void setHeroOrMinionType(RadioButton melee, RadioButton ranged, RadioButton hybrid, TextField rangeText,
                                     Card card) {
        if (melee.isSelected()) {
            card.setHeroOrMinionType(HeroOrMinionType.MELEE);
        } else if (ranged.isSelected()) {
            card.setHeroOrMinionType(HeroOrMinionType.RANGED);
            card.setRange(Integer.parseInt(rangeText.getText()));
        } else if (hybrid.isSelected()) {
            card.setHeroOrMinionType(HeroOrMinionType.HYBRID);
        }
    }

    private void setDesc(HBox radioList, RadioButton holy, RadioButton power, RadioButton health, RadioButton poison,
                         RadioButton weakness, RadioButton stun, RadioButton disarm, Spell spell,
                         RadioButton radioButton) {
        for (Node radio : radioList.getChildren()) {
            RadioButton radioButtonInFor = (RadioButton) radio;
            String desc = null;
            int turns;
            int delays;
            if (radioButtonInFor.isSelected()) {
                if (holy.equals(radioButtonInFor)) {
                    int holyTurns = spell.getHolyBuffTurns().get(spell.getHolyBuffTurns().size() - 1);
                    int holyAmount = spell.getHolyBuffAmount().get(spell.getHolyBuffAmount().size() - 1);
                    if (holyTurns == -1) {
                        desc = "Gives " + holyAmount + " holy buffs for ever to " + radioButton.getText() +
                                " permanently";
                    } else if (holyTurns == -10) {
                        desc = "Gives " + holyAmount + " holy buffs for ever to " + radioButton.getText() +
                                " continuousely";
                    } else if (holyTurns > 1000) {
                        turns = holyTurns % 1000;
                        delays = holyTurns / 1000;
                        desc = "Gives " + holyAmount + " holy buffs for " + turns + " turns to " +
                                radioButtonInFor.getText() + " with " + delays + " turns delay";
                    } else {
                        desc = "Gives " + holyAmount + " holy buffs for " + spell.getHolyBuffTurns().get
                                (spell.getHolyBuffTurns().size() - 1) + " turns to " + radioButtonInFor.getText();
                    }
                } else if (power.equals(radioButtonInFor)) {
                    int powerTurns = spell.getIncreaseAPturns().get(spell.getIncreaseAPturns().size() - 1);
                    int powerAmount = spell.getIncreaseAPamount().get(spell.getIncreaseAPamount().size() - 1);
                    if (powerTurns == -1) {
                        desc = "Increases " + powerAmount + " power units for ever to " + radioButton.getText()
                                + " permanently";
                    } else if (powerTurns == -10) {
                        desc = "Increases " + powerAmount + " power units for ever to " + radioButton.getText()
                                + " continuousely";
                    } else if (powerTurns > 1000) {
                        turns = powerTurns % 1000;
                        delays = powerTurns / 1000;
                        desc = "Increases " + powerAmount + " power units for " + turns + " turns to " +
                                radioButtonInFor.getText() + " with " + delays + " turns delay";
                    } else {
                        desc = "Increases " + powerAmount + " power units for " + powerTurns + " turns to " +
                                radioButtonInFor.getText();
                    }
                } else if (health.equals(radioButtonInFor)) {
                    int healthTurns = spell.getIncreaseHealthTurns().get(spell.getIncreaseHealthTurns().size() - 1);
                    int healthAmount = spell.getIncreaseHealthAmount().get(spell.getIncreaseHealthAmount().size() - 1);
                    if (healthTurns == -1) {
                        desc = "Increases " + healthAmount + " health units for ever to " + radioButton.getText()
                                + " permanently";
                    } else if (healthTurns == -10) {
                        desc = "Increases " + healthAmount + " health units for ever to " + radioButton.getText()
                                + " continuousely";
                    } else if (healthTurns > 1000) {
                        turns = healthTurns % 1000;
                        delays = healthTurns / 1000;
                        desc = "Increases " + healthAmount + " health units for " + turns + " turns to " + radioButtonInFor.
                                getText() + " with " + delays + " turns delay";
                    } else {
                        desc = "Increases " + healthAmount + " health units for " + healthTurns + " turns to " +
                                radioButtonInFor.getText();
                    }
                } else if (poison.equals(radioButtonInFor)) {
                    int poisonTurns = spell.getDecreaseHealthTurns().get(spell.getDecreaseHealthTurns().size() - 1);
                    int poisonAmount = spell.getDecreaseHealthAmount().get(spell.getDecreaseHealthAmount().size() - 1);
                    if (poisonTurns == -1) {
                        desc = "Decreases " + poisonAmount + " health units for ever to " + radioButton.getText() +
                                " permanently";
                    } else if (poisonTurns == -10) {
                        desc = "Decreases " + poisonAmount + " health units for ever to " + radioButton.getText() +
                                " continuousely";
                    } else if (poisonTurns > 1000) {
                        turns = poisonTurns % 1000;
                        delays = poisonTurns / 1000;
                        desc = "Decreases " + poisonAmount + " health units for " + turns + " turns to " +
                                radioButtonInFor.getText() + " with " + delays + " turns delay";
                    } else {
                        desc = "Decreases " + poisonAmount + " health units for " + poisonTurns + " turns to " +
                                radioButtonInFor.getText();
                    }
                } else if (weakness.equals(radioButtonInFor)) {
                    int weaknessTurns = spell.getDecreaseAPturns().get(spell.getDecreaseAPturns().size() - 1);
                    int weaknessAmount = spell.getDecreaseAPamount().get(spell.getDecreaseAPamount().size() - 1);
                    if (weaknessTurns == -1) {
                        desc = "Decreases " + weaknessAmount + " power units for ever to " + radioButton.getText() +
                                " permanently";
                    } else if (weaknessTurns == -10) {
                        desc = "Decreases " + weaknessAmount + " power units for ever to " + radioButton.getText() +
                                " continuousely";
                    } else if (weaknessTurns > 1000) {
                        turns = weaknessTurns % 1000;
                        delays = weaknessTurns / 1000;
                        desc = "Decreases " + weaknessAmount + " power units for " + turns + " turns to" +
                                radioButton.getText() + " with " + delays + " turns delay";
                    } else {
                        desc = "Decreases " + weaknessAmount + " power units for " + weaknessTurns + " turns to" +
                                radioButton.getText();
                    }
                } else if (stun.equals(radioButtonInFor)) {
                    int stunTurns = spell.getStunTurns();
                    if (stunTurns == -1) {
                        desc = "Exerts stun buff for ever permanently";
                    } else if (stunTurns == -10) {
                        desc = "Exerts stun buff for ever continuousely";
                    } else if (stunTurns > 1000) {
                        delays = stunTurns / 1000;
                        desc = "Exerts stun buff for " + stunTurns + " turns to" + radioButton.getText() + " with "
                                + delays + " delay";
                    } else {
                        desc = "Exerts stun buff for " + stunTurns + " turns to" + radioButton.getText();
                    }
                } else if (disarm.equals(radioButtonInFor)) {
                    int disarmTurns = spell.getDisarmTurns();
                    if (disarmTurns == -1) {
                        desc = "Exerts disarm buff for ever permanently";
                    } else if (disarmTurns == -10) {
                        desc = "Exerts disarm buff for ever continuousely";
                    } else if (disarmTurns > 1000) {
                        delays = disarmTurns / 1000;
                        desc = "Exerts stun buff for " + disarmTurns + " turns to" + radioButton.getText() + " with "
                                + delays + " delay";
                    } else {
                        desc = "Exerts stun buff for " + disarmTurns + " turns to" + radioButton.getText();
                    }
                }
                spell.getAllDescs().add(desc);
                radioButtonInFor.setSelected(false);
                return;
            }
        }
    }
}
