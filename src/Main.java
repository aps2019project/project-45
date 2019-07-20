import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.sun.xml.internal.ws.util.QNameMap;
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
import java.util.*;


public class Main extends Application{

    private static int spellNum = 1;
    private static int minionNum = 1;
    private static int heroNum = 1;
    private static int itemNum = 1;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        handleSaves();
        AccountMenu.getInstance().openWithButtons(primaryStage);
    }

    private void handleSaves() {
        JSONObject obj;
        String line;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("cards.txt"));
            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                if (obj.containsKey("allDescs")) {
                    Spell spell = new Gson().fromJson(line, Spell.class);
                    Shop.spells.put(spell.getName(), spell);
                    Shop.cards.put(spell.getName(), spell);
                } else if (obj.containsKey("minionSpecialPowerActivation")) {
                    Minion minion = new Gson().fromJson(line, Minion.class);
                    Shop.minions.put(minion.getName(), minion);
                    Shop.cards.put(minion.getName(), minion);
                } else if (obj.containsKey("specialPowerCooldown")) {
                    Hero hero = new Gson().fromJson(line, Hero.class);
                    Shop.heroes.put(hero.getName(), hero);
                    Shop.cards.put(hero.getName(), hero);
                } else if (obj.containsKey("number")) {

                }
            }
            bufferedReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }
}
