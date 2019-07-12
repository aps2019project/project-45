package view.menus;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.BuffType;
import model.Spell;
import javafx.scene.Group;

import javax.xml.soap.Text;
import java.util.ArrayList;
import java.util.Arrays;

public class CustomCardMenu extends Menu {

    private static final CustomCardMenu CUSTOM_CARD_MENU = new CustomCardMenu();
    private CustomCardMenu() {}
    public static CustomCardMenu getInstance() {return CUSTOM_CARD_MENU;}


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

        HBox checkList = new HBox();
        HBox checkList1 = new HBox();
        HBox checkList2 = new HBox();
        checkList.setSpacing(15);
        checkList1.setSpacing(15);
        checkList2.setSpacing(15);

        checkList.setLayoutX(320);
        checkList.setLayoutY(520);
        checkList1.setLayoutX(320);
        checkList1.setLayoutY(560);
        checkList2.setLayoutX(320);
        checkList2.setLayoutY(600);

        Label AP = new Label("AP :");
        Label HP = new Label("HP :");
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
        Button addbuffsHbox = new Button("Add buffs");
        CheckBox oneEnemy = new CheckBox("One Enemy");
        CheckBox oneRandomEnemy = new CheckBox("One Random Enemy");
        CheckBox oneFriend = new CheckBox("one Friend");
        CheckBox oneRandomFriend = new CheckBox("One Random Friend");
        CheckBox allEnemy = new CheckBox("Whole Enemies");
        CheckBox allFriend = new CheckBox("Whole Friends");
        CheckBox allEnemyInColumn = new CheckBox("Whole Enemies In Column");
        CheckBox enemyHero = new CheckBox("Enemy Hero");
        CheckBox friendHero = new CheckBox("Friend Hero");
        CheckBox twoCrossTwoSquares = new CheckBox("Two Cross Two Squares");
        CheckBox threeCrossThreeSquares = new CheckBox("Three Cross Three Squares");
        CheckBox oneRandomEnemyBesideFriendHero = new CheckBox("One Random Enemy Beside Friend Hero");
        CheckBox allFriendMinionsBesideYou = new CheckBox("All Friend Minions Beside You");

        checkList.getChildren().addAll(oneEnemy, oneRandomEnemy, oneFriend, oneRandomFriend, allEnemy);
        checkList1.getChildren().addAll(twoCrossTwoSquares, allFriend, allEnemyInColumn, enemyHero, friendHero );
        checkList2.getChildren().addAll(threeCrossThreeSquares, oneRandomEnemyBesideFriendHero,
                allFriendMinionsBesideYou);

        TextField nameText = new TextField();
        TextField typeText = new TextField();
        TextField costText = new TextField();
        RadioButton holy = new RadioButton("Holy");
        RadioButton power = new RadioButton("Power");
        RadioButton poison = new RadioButton("Poison");
        RadioButton weakness = new RadioButton("Weakness");
        RadioButton stun = new RadioButton("Stun");
        RadioButton disarm = new RadioButton("Disarm");
        HBox buffsHbox = new HBox();
        buffsHbox.setSpacing(10);
        buffsHbox.setLayoutX(735);
        buffsHbox.setLayoutY(240);
        buffsHbox.getChildren().addAll(holy, power, poison, weakness, stun, disarm);
        TextField effectValueText = new TextField();
        TextField delayText = new TextField();
        TextField lastText = new TextField();
        TextField APText = new TextField();
        TextField HPText = new TextField();
        RadioButton melee = new RadioButton("Melee");
        RadioButton ranged = new RadioButton("Ranged");
        RadioButton hybrid = new RadioButton("Hybrid");
        HBox attackTypeHbox = new HBox();
        attackTypeHbox.setSpacing(15);
        attackTypeHbox.getChildren().addAll(melee, ranged, hybrid);
        TextField rangeText = new TextField();
        TextField specialPowerText = new TextField();
        TextField specialPowerActivationText = new TextField();
        TextField specialPowerCooldownText = new TextField();

        target.setVisible(false);
        addbuffsHbox.setVisible(false);
        checkList.setVisible(false);
        checkList1.setVisible(false);
        checkList2.setVisible(false);
        AP.setVisible(false);
        HP.setVisible(false);
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
        attackTypeHbox.setVisible(false);
        rangeText.setVisible(false);
        specialPowerText.setVisible(false);
        specialPowerActivationText.setVisible(false);
        specialPowerCooldownText.setVisible(false);

        grid.add(name, 0, 0);
        grid.add(type, 0, 1);
        grid.add(AP, 0, 2);
        grid.add(HP, 0, 3);
        grid.add(attackType, 0, 4);
        grid.add(range, 0, 5);
        grid.add(specialPower, 0, 6);
        grid.add(specialPowerActivation, 0, 7);
        grid.add(specialPowerCooldown, 0, 7);
        grid.add(addbuffsHbox, 0, 2);
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
        grid.add(specialPowerActivationText, 1, 7);
        grid.add(specialPowerCooldownText, 1, 7);
        grid.add(cost, 0, 8);
        grid.add(costText, 1, 8);
        root.getChildren().addAll(checkList, checkList1, checkList2, buffsHbox);
        root.getChildren().addAll(grid);

        primaryStage.show();

        typeText.setOnKeyPressed(event -> typeText.setTextFormatter(new TextFormatter<>(change -> {
            if (change.getControlNewText().equalsIgnoreCase("spell")) {
                addbuffsHbox.setVisible(true);
                buffType.setVisible(true);
                effectValue.setVisible(true);
                delay.setVisible(true);
                last.setVisible(true);
                buffsHbox.setVisible(true);
                effectValueText.setVisible(true);
                delayText.setVisible(true);
                lastText.setVisible(true);
                checkList.setVisible(true);
                checkList1.setVisible(true);
                checkList2.setVisible(true);
            } else if (change.getControlNewText().equalsIgnoreCase("minion")) {
                AP.setVisible(true);
                HP.setVisible(true);
                attackType.setVisible(true);
                specialPower.setVisible(true);
                specialPowerActivation.setVisible(true);
                APText.setVisible(true);
                HPText.setVisible(true);
                attackTypeHbox.setVisible(true);
                specialPowerText.setVisible(true);
                specialPowerActivationText.setVisible(true);
            } else if (change.getControlNewText().equalsIgnoreCase("hero")) {
                AP.setVisible(true);
                HP.setVisible(true);
                attackType.setVisible(true);
                specialPower.setVisible(true);
                specialPowerCooldown.setVisible(true);
                APText.setVisible(true);
                HPText.setVisible(true);
                attackTypeHbox.setVisible(true);
                specialPowerText.setVisible(true);
                specialPowerCooldownText.setVisible(true);
            } else {
                target.setVisible(false);
                addbuffsHbox.setVisible(false);
                checkList.setVisible(false);
                checkList1.setVisible(false);
                checkList2.setVisible(false);
                AP.setVisible(false);
                HP.setVisible(false);
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
                attackTypeHbox.setVisible(false);
                rangeText.setVisible(false);
                specialPowerText.setVisible(false);
                specialPowerActivationText.setVisible(false);
                specialPowerCooldownText.setVisible(false);
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

        addbuffsHbox.setOnAction(event -> {
            if (holy.isSelected()) {

            }
            holy.setSelected(false);
            poison.setSelected(false);
            power.setSelected(false);
            weakness.setSelected(false);
            stun.setSelected(false);
            disarm.setSelected(false);
            effectValueText.setText("");
            delayText.setText("");
            lastText.setText("");
        });
    }



    private void createSpell() {
        String cardID = "spell_1";
        String name = "Ali";
        String desc = "bemir baba";
        ArrayList<BuffType> buffTypes = (ArrayList<BuffType>) Arrays.asList(BuffType.DISARM);
        ArrayList<Integer> effectValue = (ArrayList<Integer>) Arrays.asList(10);
        ArrayList<Integer> delay = (ArrayList<Integer>) Arrays.asList(10);
        ArrayList<Integer> last = (ArrayList<Integer>) Arrays.asList(10);


        Spell spell = new Spell(cardID, name, desc, buffTypes, effectValue, delay, last, 10);

        Gson gson = new Gson();
        String string = gson.toJson(spell);
        System.out.println(string);
    }
}
