import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import view.menus.AccountMenu;
import view.menus.CustomCardMenu;
import view.menus.Shop;
import java.io.*;
import java.util.ArrayList;


public class Main extends Application{

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        handleSaves();
        CustomCardMenu.getInstance().openWithButtons(primaryStage);
    }

    private void handleSaves() {
        ArrayList<JSONObject> json = new ArrayList<>();
        JSONObject obj;
        String line;
        try {
            FileReader fileReader = new FileReader("cards.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                json.add(obj);
                Card[] card = new Card[1];
                card[0] = new Card();
                if (obj.containsKey("allDescs")) {
                    card[0] = new Spell();
                    ((Spell)card[0]).setAllDescs((ArrayList<String>) obj.get("allDescs"));
                } else if (obj.containsKey("minionSpecialPowerActivation")) {
                    Minion minion = (Minion) card[0];
                    setObject(obj, minion);
                    minion.setMinionSpecialPowerActivation((MinionSpecialPowerActivation) obj.get
                            ("minionSpecialPowerActivation"));
                } else if (obj.containsKey("specialPowerCooldown")) {
                    Hero hero = (Hero) card[0];
                    setObject1(obj, hero);
                    hero.setSpecialPowerCooldown(Integer.valueOf(obj.get("specialPowerCooldown").toString()));
                } else if (obj.containsKey("usable")) {

                }
                card[0].setName((String) obj.get("name"));
                card[0].setCost(Integer.valueOf(obj.get("cost").toString()));
                if (obj.containsKey("cardId") && obj.get("cardID") != null) {
                    card[0].setCardID((String) obj.get("cardID"));
                }
                Shop.cards.put(card[0].getName(), card[0]);
                ArrayList<String> arrayList = (ArrayList<String>) obj.get("allDescs");
                System.out.println(arrayList.get(0));

            }
            bufferedReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void setObject1(JSONObject obj, Hero hero) {
        hero.setAP(Integer.valueOf(obj.get("AP").toString()));
        hero.setHealth(Integer.valueOf(obj.get("health").toString()));
        hero.setMP(Integer.valueOf(obj.get("MP").toString()));
        hero.setHeroOrMinionType((HeroOrMinionType) obj.get("heroOrMinionType"));
        if (obj.containsKey("range")) {
            hero.setRange(Integer.valueOf(obj.get("range").toString()));
        }
        hero.setSpecialPower((Spell) obj.get("specialPower"));
    }

    private void setObject(JSONObject obj, Minion card) {
        card.setAP(Integer.valueOf(obj.get("AP").toString()));
        card.setHealth(Integer.valueOf(obj.get("health").toString()));
        card.setMP(Integer.valueOf(obj.get("MP").toString()));
        card.setHeroOrMinionType((HeroOrMinionType) obj.get("heroOrMinionType"));
        if (obj.containsKey("range")) {
            card.setRange(Integer.valueOf(obj.get("range").toString()));
        }
        card.setSpecialPower((Spell) obj.get("specialPower"));
    }
}
