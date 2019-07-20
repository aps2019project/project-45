package view.menus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.*;
import javafx.scene.Group;
import view.Battle;

import java.io.*;

public class CustomCardMenu extends PlayMenu {

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
        grid.setLayoutX(500);
        grid.setLayoutY(50);

        Button OK = new Button("OK");
        OK.setLayoutX(500);
        OK.setLayoutY(650);
        OK.setStyle("-fx-font-size: 15");

        HBox radioList = new HBox();
        HBox radioList2 = new HBox();
        radioList.setSpacing(10);
        radioList2.setSpacing(10);

        radioList.setLayoutX(150);
        radioList.setLayoutY(520);
        radioList2.setLayoutX(150);
        radioList2.setLayoutY(570);

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
        Label description = new Label("-1 indicates permanence and -10 indicates continuous");
        Label description1 = new Label("-1 indicates killing!");
        Label target = new Label("Target :");
        Label in = new Label("In :");
        Button addbuffs = new Button("Add buffs");
        RadioButton oneEnemy = new RadioButton("One Enemy");
        RadioButton oneFriend = new RadioButton("One Friend");
        RadioButton oneEnemyMinion = new RadioButton("One Enemy Minion");
        RadioButton oneFriendMinion = new RadioButton("One Friend Minion");
        RadioButton wholeEnemyMinions = new RadioButton("Whole Enemy Minions");
        RadioButton wholeFriendMinons = new RadioButton("Whole Friend Minions");
        RadioButton allEnemy = new RadioButton("Whole Enemies");
        RadioButton allFriend = new RadioButton("Whole Friends");
        RadioButton enemyHero = new RadioButton("Enemy Hero");
        RadioButton friendHero = new RadioButton("Friend Hero");
        RadioButton allFriendMinions = new RadioButton("All Friend Minions");
        RadioButton oneSquare = new RadioButton("One Square");
        RadioButton column = new RadioButton("One Column");
        RadioButton row = new RadioButton("One Row");
        RadioButton twoCrossTwoSquares = new RadioButton("Two Cross Two Squares");
        RadioButton threeCrossThreeSquares = new RadioButton("Three Cross Three Squares");
        RadioButton besideFriendHero = new RadioButton("Beside Friend Hero");
        RadioButton besideYou = new RadioButton("Beside You");
        RadioButton wholeGround = new RadioButton("Whole Ground");
        RadioButton with2housesDistance = new RadioButton("Houses With 2 Distance");

        description.setLayoutX(960);
        description.setLayoutY(320);
        description1.setLayoutX(960);
        description1.setLayoutY(225);
        description.setStyle("-fx-text-fill: blue");
        description1.setStyle("-fx-text-fill: blue");
        target.setLayoutX(50);
        target.setLayoutY(520);
        in.setLayoutX(50);
        in.setLayoutY(570);
        target.setStyle("-fx-background-color: #6bfdff; -fx-border-color: #535252");
        in.setStyle("-fx-background-color: #6bfdff; -fx-border-color: #535252");

        radioList.getChildren().addAll(oneEnemy, oneFriend, oneEnemyMinion, oneFriendMinion,wholeEnemyMinions,
                wholeFriendMinons,  allEnemy, allFriend, enemyHero, friendHero);
        radioList2.getChildren().addAll(oneSquare, twoCrossTwoSquares, threeCrossThreeSquares, column, row,
                besideFriendHero, allFriendMinions, besideYou, wholeGround, with2housesDistance);
        radioList.setStyle("-fx-font-size: 12");
        radioList2.setStyle("-fx-font-size: 12");

        TextField nameText = new TextField();
        TextField costText = new TextField();
        RadioButton holy = new RadioButton("Holy");
        RadioButton power = new RadioButton("Power");
        RadioButton health = new RadioButton("Health");
        RadioButton poison = new RadioButton("Poison/Strike");
        RadioButton weakness = new RadioButton("Weakness");
        RadioButton stun = new RadioButton("Stun");
        RadioButton disarm = new RadioButton("Disarm");
        RadioButton fiery = new RadioButton("Fiery");
        HBox buffsHbox = new HBox();
        buffsHbox.setSpacing(10);
        buffsHbox.setLayoutX(685);
        buffsHbox.setLayoutY(190);
        buffsHbox.getChildren().addAll(holy, power, health, poison, weakness, stun, disarm, fiery);
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
        minionSpecialPowerActivation.setLayoutX(685);
        minionSpecialPowerActivation.setLayoutY(370);
        minionSpecialPowerActivation.getChildren().addAll(onAttack, combo, passive, onDeath, onSpown, onTurn, onDefend);
        TextField specialPowerCooldownText = new TextField();
        RadioButton spellRadioButton = new RadioButton("Spell");
        RadioButton minionRadioButton = new RadioButton("Minion");
        RadioButton heroRadioButton = new RadioButton("Hero");
        HBox typeHbox = new HBox();
        typeHbox.setSpacing(15);
        typeHbox.setLayoutX(685);
        typeHbox.setLayoutY(95);
        typeHbox.getChildren().addAll(spellRadioButton, minionRadioButton, heroRadioButton);

        setVisibleFalse(radioList, radioList2, AP, HP, MP, attackType, range, specialPower,
                specialPowerActivation, specialPowerCooldown, buffType, effectValue, delay, last, addbuffs,
                buffsHbox, effectValueText, delayText, lastText, APText, HPText, MPText, attackTypeHbox, rangeText,
                specialPowerText, minionSpecialPowerActivation, specialPowerCooldownText, target, in, description,
                description1);
        gridAdding(grid, AP, HP, MP, attackType, range, specialPower, specialPowerActivation, specialPowerCooldown,
                cost, buffType, effectValue, delay, last, name, type, addbuffs, nameText, costText,
                effectValueText, delayText, lastText, APText, HPText, MPText, attackTypeHbox, rangeText,
                specialPowerText, specialPowerCooldownText, typeHbox);
        root.getChildren().addAll(grid, target, in, description, description1, radioList, radioList2, buffsHbox, typeHbox,
                minionSpecialPowerActivation, OK);

        primaryStage.setTitle("Custom Card Menu");
        primaryStage.show();

        Spell spell = new Spell();
        Hero hero = new Hero();
        Minion minion = new Minion();
        poison.setOnMouseClicked(event -> {
            if (poison.isSelected()) {
                description1.setVisible(true);
            } else {
                description1.setVisible(false);
            }
        });

        spellRadioButton.setOnMouseClicked(event -> {
            setVisibleFalse(radioList, radioList2, AP, HP, MP, attackType, range, specialPower,
                    specialPowerActivation, specialPowerCooldown, buffType, effectValue, delay, last,
                    addbuffs, buffsHbox, effectValueText, delayText, lastText, APText, HPText, MPText,
                    attackTypeHbox, rangeText, specialPowerText, minionSpecialPowerActivation,
                    specialPowerCooldownText, target, in, description, description1);
            minionRadioButton.setSelected(false);
            heroRadioButton.setSelected(false);
            setSpellVisibleTrue(radioList, radioList2, MP, buffType, effectValue, delay, last,
                    addbuffs, buffsHbox, effectValueText, delayText, lastText, MPText, target, in, description);
        });
        minionRadioButton.setOnMouseClicked(event -> {
            setVisibleFalse(radioList, radioList2, AP, HP, MP, attackType, range, specialPower,
                    specialPowerActivation, specialPowerCooldown, buffType, effectValue, delay, last,
                    addbuffs, buffsHbox, effectValueText, delayText, lastText, APText, HPText, MPText,
                    attackTypeHbox, rangeText, specialPowerText, minionSpecialPowerActivation,
                    specialPowerCooldownText, target, in, description, description1);
            spellRadioButton.setSelected(false);
            heroRadioButton.setSelected(false);
            setMinionVisibleTrue(AP, HP, MP, attackType, specialPower, specialPowerActivation, APText,
                    HPText, MPText, attackTypeHbox, specialPowerText, minionSpecialPowerActivation);
        });
        heroRadioButton.setOnMouseClicked(event -> {
            setVisibleFalse(radioList, radioList2, AP, HP, MP, attackType, range, specialPower,
                    specialPowerActivation, specialPowerCooldown, buffType, effectValue, delay, last,
                    addbuffs, buffsHbox, effectValueText, delayText, lastText, APText, HPText, MPText,
                    attackTypeHbox, rangeText, specialPowerText, minionSpecialPowerActivation,
                    specialPowerCooldownText, target, in, description, description1);
            spellRadioButton.setSelected(false);
            minionRadioButton.setSelected(false);
            setHeroVisibleTrue(AP, HP, MP, attackType, specialPower, APText, HPText, MPText, attackTypeHbox,
                    specialPowerText, specialPowerCooldown, specialPowerCooldownText);
        });


        ranged.setOnAction(event -> {
            if (!range.isVisible()) {
                range.setVisible(true);
                rangeText.setVisible(true);
            } else {
                range.setVisible(false);
                rangeText.setVisible(false);
            }
        });
        hybrid.setOnAction(event -> {
            if (!range.isVisible()) {
                range.setVisible(true);
                rangeText.setVisible(true);
            } else {
                range.setVisible(false);
                rangeText.setVisible(false);
            }
        });

        addbuffs.setOnAction(event -> {
            RadioButton radioButton = null;
            for (Node radio : buffsHbox.getChildren()) {
                RadioButton radioButtonInFor = (RadioButton) radio;
                if (radioButtonInFor.isSelected()) {
                    radioButton = radioButtonInFor;
                    break;
                }
            }
            setSpellFeatures(holy, power, health, poison, weakness, stun, disarm, fiery, effectValueText, delayText,
                    lastText, spell, radioList);
            setDesc(radioList, holy, power, health, poison, weakness, stun, disarm, fiery, spell, radioButton);
            for (Node radio : radioList2.getChildren()) {
                RadioButton radioButtonInFor = (RadioButton) radio;
                if (radioButtonInFor.isSelected()) {
                    int size_1 = spell.getAllDescs().size() - 1;
                    spell.getAllDescs().set(size_1, spell.getAllDescs().get(size_1) + " in " + radioButtonInFor.
                            getText());
                    radioButtonInFor.setSelected(false);
                }
            }
            holy.setSelected(false);
            poison.setSelected(false);
            power.setSelected(false);
            weakness.setSelected(false);
            stun.setSelected(false);
            disarm.setSelected(false);
            fiery.setSelected(false);
            effectValueText.setText("");
            delayText.setText("0");
            lastText.setText("");
        });

        OK.setOnAction(event -> {
            String json = "";
            BufferedWriter out = null;
            ObjectMapper mapper = new ObjectMapper();
            try {
                out = new BufferedWriter(new FileWriter("cards.txt", true));
                if (spellRadioButton.isSelected()) {
                    spell.setName(nameText.getText());
                    spell.setCardID(battle.getActiveAccount().getUsername() + "_" + spell.getName() + "_1");
                    spell.setCost(Integer.parseInt(costText.getText()));
                    spell.setMP(Integer.parseInt(MPText.getText()));
                    Shop.cards.put(spell.getName(), spell);
                    json = mapper.writeValueAsString(spell);
                } else if (minionRadioButton.isSelected()) {
                    setMinionOrHeroSomeFeatures(nameText, costText, APText, HPText, MPText, spell, minion);
                    setSpecialPower(specialPowerText, minion);
                    setHeroOrMinionType(melee, ranged, hybrid, rangeText, minion);
                    setMinionSpecialPowerActivation(onAttack, combo, passive, onDeath, onSpown, onTurn, onDefend,
                            minionSpecialPowerActivation, minion);
                    if (ranged.isSelected()) {
                        minion.setRange(Integer.parseInt(rangeText.getText()));
                    }
                    setMinionSpellActivation(onAttack, combo, passive, onDeath, onSpown, onTurn, onDefend, minion);
                    json = mapper.writeValueAsString(minion);
                } else if (heroRadioButton.isSelected()) {
                    setMinionOrHeroSomeFeatures(nameText, costText, APText, HPText, MPText, spell, hero);
                    setHeroOrMinionType(melee, ranged, hybrid, rangeText, hero);
                    setSpecialPower1(specialPowerText, hero);
                    hero.setSpecialPowerCooldown(Integer.parseInt(specialPowerCooldownText.getText()));
                    if (ranged.isSelected()) {
                        hero.setRange(Integer.parseInt(rangeText.getText()));
                    }
                    json = mapper.writeValueAsString(hero);
                }
                out.write(json + "\n");
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            exit(primaryStage);
        });
    }

    private void setMinionOrHeroSomeFeatures(TextField nameText, TextField costText, TextField APText, TextField HPText,
                                             TextField MPText, Spell spell, Card minion) {
        minion.setName(nameText.getText());
        spell.setCardID(battle.getActiveAccount().getUsername() + "_" + minion.getName() + "_1");
        minion.setCost(Integer.parseInt(costText.getText()));
        minion.setAP(Integer.parseInt(APText.getText()));
        minion.setHealth(Integer.parseInt(HPText.getText()));
        minion.setMP(Integer.parseInt(MPText.getText()));
    }

    private void gridAdding(GridPane grid, Label AP, Label HP, Label MP, Label attackType, Label range, Label
            specialPower, Label specialPowerActivation, Label specialPowerCooldown, Label cost, Label buffType, Label
            effectValue, Label delay, Label last, Label name, Label type, Button addbuffs, TextField nameText,
                            TextField costText, TextField effectValueText, TextField delayText,
                            TextField lastText, TextField APText, TextField HPText, TextField MPText, HBox
                                    attackTypeHbox, TextField rangeText, TextField specialPowerText, TextField
                                    specialPowerCooldownText, HBox typeHbox) {
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
        grid.add(typeHbox, 1, 1);
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
    }

    private void setDesc(HBox radioList, RadioButton holy, RadioButton power, RadioButton health, RadioButton poison,
                         RadioButton weakness, RadioButton stun, RadioButton disarm, RadioButton fiery, Spell spell,
                         RadioButton radioButton) {
        String desc = "";
        for (Node radio : radioList.getChildren()) {
            RadioButton radioButtonInFor = (RadioButton) radio;
            int turns;
            int delays;
            if (radioButtonInFor.isSelected()) {
                if (holy.equals(radioButton)) {
                    int holyTurns = spell.getHolyBuffTurns().get(spell.getHolyBuffTurns().size() - 1);
                    int holyAmount = spell.getHolyBuffAmount().get(spell.getHolyBuffAmount().size() - 1);
                    if (holyTurns == -1) {
                        desc = "Gives " + holyAmount + " holy buffs for ever to " + radioButtonInFor.getText() +
                                " permanently";
                    } else if (holyTurns == -10) {
                        desc = "Gives " + holyAmount + " holy buffs for ever to " + radioButtonInFor.getText() +
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
                } else if (power.equals(radioButton)) {
                    int powerTurns = spell.getIncreaseAPturns().get(spell.getIncreaseAPturns().size() - 1);
                    int powerAmount = spell.getIncreaseAPamount().get(spell.getIncreaseAPamount().size() - 1);
                    if (powerTurns == -1) {
                        desc = "Increases " + powerAmount + " power units for ever to " + radioButtonInFor.getText()
                                + " permanently";
                    } else if (powerTurns == -10) {
                        desc = "Increases " + powerAmount + " power units for ever to " + radioButtonInFor.getText()
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
                } else if (health.equals(radioButton)) {
                    int healthTurns = spell.getIncreaseHealthTurns().get(spell.getIncreaseHealthTurns().size() - 1);
                    int healthAmount = spell.getIncreaseHealthAmount().get(spell.getIncreaseHealthAmount().size() - 1);
                    if (healthTurns == -1) {
                        desc = "Increases " + healthAmount + " health units for ever to " + radioButtonInFor.getText()
                                + " permanently";
                    } else if (healthTurns == -10) {
                        desc = "Increases " + healthAmount + " health units for ever to " + radioButtonInFor.getText()
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
                } else if (poison.equals(radioButton)) {
                    int poisonTurns = spell.getDecreaseHealthTurns().get(spell.getDecreaseHealthTurns().size() - 1);
                    int poisonAmount = spell.getDecreaseHealthAmount().get(spell.getDecreaseHealthAmount().size() - 1);
                    if (poisonTurns == -1) {
                        desc = "Decreases " + poisonAmount + " health units for ever to " + radioButtonInFor.getText() +
                                " permanently";
                    } else if (poisonTurns == -10) {
                        desc = "Decreases " + poisonAmount + " health units for ever to " + radioButtonInFor.getText() +
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
                } else if (weakness.equals(radioButton)) {
                    int weaknessTurns = spell.getDecreaseAPturns().get(spell.getDecreaseAPturns().size() - 1);
                    int weaknessAmount = spell.getDecreaseAPamount().get(spell.getDecreaseAPamount().size() - 1);
                    if (weaknessTurns == -1) {
                        desc = "Decreases " + weaknessAmount + " power units for ever to " + radioButtonInFor.getText() +
                                " permanently";
                    } else if (weaknessTurns == -10) {
                        desc = "Decreases " + weaknessAmount + " power units for ever to " + radioButtonInFor.getText() +
                                " continuousely";
                    } else if (weaknessTurns > 1000) {
                        turns = weaknessTurns % 1000;
                        delays = weaknessTurns / 1000;
                        desc = "Decreases " + weaknessAmount + " power units for " + turns + " turns to" +
                                radioButtonInFor.getText() + " with " + delays + " turns delay";
                    } else {
                        desc = "Decreases " + weaknessAmount + " power units for " + weaknessTurns + " turns to" +
                                radioButton.getText();
                    }
                } else if (stun.equals(radioButton)) {
                    int stunTurns = spell.getStunTurns();
                    if (stunTurns == -1) {
                        desc = "Exerts stun buff for ever permanently";
                    } else if (stunTurns == -10) {
                        desc = "Exerts stun buff for ever continuousely";
                    } else if (stunTurns > 1000) {
                        delays = stunTurns / 1000;
                        desc = "Exerts stun buff for " + stunTurns + " turns to " + radioButtonInFor.getText() + " with "
                                + delays + " delay";
                    } else {
                        desc = "Exerts stun buff for " + stunTurns + " turns to " + radioButtonInFor.getText();
                    }
                } else if (disarm.equals(radioButton)) {
                    int disarmTurns = spell.getDisarmTurns();
                    if (disarmTurns == -1) {
                        desc = "Exerts disarm buff for ever permanently";
                    } else if (disarmTurns == -10) {
                        desc = "Exerts disarm buff for ever continuousely";
                    } else if (disarmTurns > 1000) {
                        delays = disarmTurns / 1000;
                        desc = "Exerts disarm buff for " + disarmTurns + " turns to " + radioButtonInFor.getText() + " with "
                                + delays + " delay";
                    } else {
                        desc = "Exerts disarm buff for " + disarmTurns + " turns to " + radioButtonInFor.getText();
                    }
                }
                spell.getAllDescs().add(desc);
                radioButtonInFor.setSelected(false);
                return;
            }
        }
        if (holy.isSelected()) {
            int holyTurns = spell.getHolyBuffTurns().get(spell.getHolyBuffTurns().size() - 1);
            if (holyTurns == -1) {
                desc = "Exerts holy effect for ever";
            } else if (holyTurns > 1000) {
                int delay = holyTurns / 1000;
                int turn = holyTurns % 1000;
                desc = "Exerts holy effect with" + delay + " turns delay for " + turn + " turns";
            } else {
                desc = "Exerts holy effect for " + holyTurns + " turns";
            }
            spell.getAllDescs().add(desc);
        } else if (poison.isSelected()) {
            setPoisonOrFieryHouseEffect(spell, "Exerts poison effect for ever", "Exerts poison effect with ",
                    "Exerts poison effect for ");
        } else if (fiery.isSelected()) {
            setPoisonOrFieryHouseEffect(spell, "Exerts fiery effect for ever", "Exerts fiery effect with ",
                    "Exerts fiery effect for ");
        }
    }

    private void setPoisonOrFieryHouseEffect(Spell spell, String s, String s2, String s3) {
        String desc;
        int poisonTurns = spell.getDecreaseHealthTurns().get(spell.getDecreaseHealthTurns().size() - 1);
        if (poisonTurns == -1) {
            desc = s;
        } else if (poisonTurns > 1000) {
            int delay = poisonTurns / 1000;
            int turn = poisonTurns % 1000;
            desc = s2 + delay + " turns delay for " + turn + " turns";
        } else {
            desc = s3 + poisonTurns + " turns";
        }
        spell.getAllDescs().add(desc);
    }

    private void setVisibleFalse(HBox radioList, HBox radioList2, Label AP, Label HP, Label MP,
                                 Label attackType, Label range, Label specialPower, Label specialPowerActivation,
                                 Label specialPowerCooldown, Label buffType, Label effectValue, Label delay, Label
                                         last, Button addbuffs, HBox buffsHbox, TextField effectValueText,
                                 TextField delayText, TextField lastText, TextField APText, TextField HPText, TextField
                                         MPText, HBox attackTypeHbox, TextField rangeText, TextField specialPowerText,
                                 HBox minionSpecialPowerActivation, TextField specialPowerCooldownText, Label target,
                                 Label in, Label description, Label description1) {
        target.setVisible(false);
        addbuffs.setVisible(false);
        radioList.setVisible(false);
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
        target.setVisible(false);
        in.setVisible(false);
        description.setVisible(false);
        description1.setVisible(false);
    }

    private void setMinionVisibleTrue(Label AP, Label HP, Label MP, Label attackType, Label specialPower, Label
            specialPowerActivation, TextField APText, TextField HPText, TextField MPText, HBox attackTypeHbox,
                                             TextField specialPowerText, HBox minionSpecialPowerActivation) {
        AP.setVisible(true);
        HP.setVisible(true);
        MP.setVisible(true);
        attackType.setVisible(true);
        specialPower.setVisible(true);
        specialPowerActivation.setVisible(true);
        APText.setVisible(true);
        HPText.setVisible(true);
        MPText.setVisible(true);
        attackTypeHbox.setVisible(true);
        specialPowerText.setVisible(true);
        minionSpecialPowerActivation.setVisible(true);
    }

    private void setHeroVisibleTrue(Label AP, Label HP, Label MP, Label attackType, Label specialPower,
                                    TextField APText, TextField HPText, TextField MPText, HBox attackTypeHbox,
                                    TextField specialPowerText, Label specialPowerCooldown, TextField
                                            specialPowerCooldownText) {
        AP.setVisible(true);
        HP.setVisible(true);
        MP.setVisible(true);
        attackType.setVisible(true);
        specialPower.setVisible(true);
        APText.setVisible(true);
        HPText.setVisible(true);
        MPText.setVisible(true);
        attackTypeHbox.setVisible(true);
        specialPowerText.setVisible(true);
        specialPowerCooldown.setVisible(true);
        specialPowerCooldownText.setVisible(true);
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
                                  RadioButton weakness, RadioButton stun, RadioButton disarm, RadioButton fiery,
                                  TextField effectValueText, TextField delayText, TextField lastText, Spell spell,
                                  HBox radioList) {
        if (holy.isSelected()) {
            if (!isaBoolean(radioList)) {
                if (Integer.parseInt(lastText.getText()) != -1) {
                    spell.setHolyBuff(1000 * Integer.parseInt(delayText.getText()) +
                            Integer.parseInt(lastText.getText()), 1);
                } else {
                    spell.setHolyBuff(-1, 1);
                }
                return;
            }
            spell.setHolyBuff(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()), Integer.parseInt(effectValueText.getText()));
        } else if (power.isSelected()) {
            spell.setIncreaseAP(1000 * Integer.parseInt(delayText.getText()) +
                    Integer.parseInt(lastText.getText()), Integer.parseInt(effectValueText.getText()));
        } else if (health.isSelected()) {
            spell.setIncreaseHealth(1000 * Integer.parseInt(delayText.getText()) +
                    Integer.parseInt(lastText.getText()), Integer.parseInt(effectValueText.getText()));
        } else if (poison.isSelected()) {
            if (!isaBoolean(radioList)) {
                if (Integer.parseInt(lastText.getText()) != -1) {
                    spell.setDecreaseHealth(1000 * Integer.parseInt(delayText.getText()) +
                            Integer.parseInt(lastText.getText()), 1);
                }
                else {
                    spell.setDecreaseHealth(-1, 1);
                }
            } else {
                if (lastText.getText().equals("")) { //kill
                    spell.setDecreaseHealth(1, -1);
                } else {
                    spell.setDecreaseHealth(1000 * Integer.parseInt(delayText.getText()) +
                            Integer.parseInt(lastText.getText()), Integer.parseInt(effectValueText.getText()));
                }
            }
        } else if (weakness.isSelected()) {
            spell.setDecreaseAP(1000 * Integer.parseInt(delayText.getText()) +
                    Integer.parseInt(lastText.getText()), Integer.parseInt(effectValueText.getText()));
        } else if (stun.isSelected()) {
            spell.setStunTurns(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()));
        } else if (disarm.isSelected()) {
            spell.setDisarmTurns(1000 * Integer.parseInt(delayText.getText()) + Integer.parseInt(lastText
                    .getText()));
        } else if (fiery.isSelected()) {
            if (Integer.parseInt(lastText.getText()) != -1) {
                spell.setDecreaseHealth(1000 * Integer.parseInt(delayText.getText()) +
                        Integer.parseInt(lastText.getText()), 2);
            } else {
                spell.setDecreaseHealth(-1, 2);
            }
        }
    }

    private boolean isaBoolean(HBox radioList) {
        return ((RadioButton)radioList.getChildren().get(0)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(1)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(2)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(3)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(4)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(5)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(6)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(7)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(8)).isSelected() ||
                ((RadioButton)radioList.getChildren().get(9)).isSelected();
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

    private void setSpecialPower(TextField specialPowerText, Card card) {
        if (Shop.cards.containsKey(specialPowerText.getText())) {
            try {
                Spell spell = (Spell) Shop.cards.get(specialPowerText.getText()).clone();
                if (card instanceof Minion) ((Minion)card).setSpecialPower(spell);
                else ((Hero)card).setSpecialPower(spell);
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
        Hero hero;
        Minion minion;
        if (card instanceof Hero) {
            hero = (Hero) card;
            setHeroType(melee, ranged, hybrid, rangeText, hero);
        } else {
            minion = (Minion) card;
            setMinionType(melee, ranged, hybrid, rangeText, minion);
        }
    }

    private void setHeroType(RadioButton melee, RadioButton ranged, RadioButton hybrid, TextField rangeText, Hero hero) {
        if (melee.isSelected()) {
            hero.setHeroOrMinionType(HeroOrMinionType.MELEE);
        } else if (ranged.isSelected()) {
            hero.setHeroOrMinionType(HeroOrMinionType.RANGED);
            hero.setRange(Integer.parseInt(rangeText.getText()));
        } else if (hybrid.isSelected()) {
            hero.setHeroOrMinionType(HeroOrMinionType.HYBRID);
        }
    }

    private void setMinionType(RadioButton melee, RadioButton ranged, RadioButton hybrid, TextField rangeText, Minion
            minion) {
        if (melee.isSelected()) {
            minion.setHeroOrMinionType(HeroOrMinionType.MELEE);
        } else if (ranged.isSelected()) {
            minion.setHeroOrMinionType(HeroOrMinionType.RANGED);
            minion.setRange(Integer.parseInt(rangeText.getText()));
        } else if (hybrid.isSelected()) {
            minion.setHeroOrMinionType(HeroOrMinionType.HYBRID);
        }
    }

    private void setSpellVisibleTrue(HBox radioList, HBox radioList2, Label MP, Label buffType,
                                     Label effectValue, Label delay, Label last, Button addbuffs, HBox buffsHbox,
                                     TextField effectValueText, TextField delayText, TextField lastText, TextField
                                             MPText, Label target, Label in, Label description) {
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
        radioList2.setVisible(true);
        MP.setVisible(true);
        MPText.setVisible(true);
        target.setVisible(true);
        in.setVisible(true);
        description.setVisible(true);
    }

}
