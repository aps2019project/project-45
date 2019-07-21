import com.google.gson.Gson;
import javafx.application.Application;
import javafx.stage.Stage;
import model.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import view.menus.AccountMenu;
import view.menus.Shop;
import java.io.*;

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
            int num = 1;
            while ((line = bufferedReader.readLine()) != null) {
                obj = (JSONObject) new JSONParser().parse(line);
                if (obj.containsKey("allDescs")) {
                    Spell spell = new Gson().fromJson(line, Spell.class);
                    setSpellImage(num % 5, spell);
                    Shop.spells.put(spell.getName(), spell);
                    Shop.cards.put(spell.getName(), spell);
                } else if (obj.containsKey("minionSpecialPowerActivation")) {
                    Minion minion = new Gson().fromJson(line, Minion.class);
                    setMinionImage(num % 5, minion);
                    Shop.minions.put(minion.getName(), minion);
                    Shop.cards.put(minion.getName(), minion);
                } else if (obj.containsKey("specialPowerCooldown")) {
                    Hero hero = new Gson().fromJson(line, Hero.class);
                    setHeroImage(num % 5, hero);
                    Shop.heroes.put(hero.getName(), hero);
                    Shop.cards.put(hero.getName(), hero);
                } else if (obj.containsKey("number")) {
                    Item item = new Item();
                    if (Integer.parseInt((String)obj.get("cost")) == 0) item.setCollectible(true);
                    else item.setCost(Integer.parseInt((String)obj.get("cost")));
                    item.setNumber(Integer.parseInt((String)obj.get("number")));
                    item.setDesc((String) obj.get("effect"));
                    item.setName((String) obj.get("name"));
                    if (!item.isCollectible()) setItemImage(num % 5, item);
                    Shop.items.put(item.getName(), item);
                    Shop.cards.put(item.getName(), item);
                }
                num++;
            }
            bufferedReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private void setSpellImage(int num, Card card) {
        switch (num) {
            case 0:
                card.setImageName("boss_andromeda_portrait_hex@2x.png");
                break;
            case 1:
                card.setImageName("boss_archonis_portrait_hex@2x.png");
                break;
            case 2:
                card.setImageName("boss_boreal_juggernaut_portrait_image_hex@2x.png");
                break;
            case 3:
                card.setImageName("boss_crystal_portrait_hex@2x.png");
                break;
            case 4:
                card.setImageName("boss_wolfpunch_portrait_hex@2x.png");
                break;
        }
    }

    private void setHeroImage(int num, Card card) {
        switch (num) {
            case 0:
                card.setImageName("f1_altgeneraltier2_breathing.gif");
                break;
            case 1:
                card.setImageName("f3_zirixfestive_breathing.gif");
                break;
            case 2:
                card.setImageName("f5_ragnoramk2_breathing.gif");
                break;
            case 3:
                card.setImageName("f5_tier2general_breathing.gif");
                break;
            case 4:
                card.setImageName("f6_ilenamk2_breathing.gif");
                break;
        }
    }

    private void setMinionImage(int num, Card card) {
        switch (num) {
            case 0:
                card.setImageName("boss_decepticlechassis_breathing.gif");
                break;
            case 1:
                card.setImageName("boss_protector_breathing.gif");
                break;
            case 2:
                card.setImageName("boss_taskmaster_breathing.gif");
                break;
            case 3:
                card.setImageName("f1_general_skinroguelegacy_breathing.gif");
                break;
            case 4:
                card.setImageName("f4_maehvmk2_breathing.gif");
                break;
        }
    }

    private void setItemImage(int num, Card card) {
        switch (num) {
            case 0:
                card.setImageName("boss_christmas_portrait_hex@2x.png");
                break;
            case 1:
                card.setImageName("boss_shinkage_zendo_portrait_image_hex@2x.png");
                break;
            case 2:
                card.setImageName("boss_skurge_portrait_hex@2x.png");
                break;
            case 3:
                card.setImageName("boss_solfist_portrait_hex@2x.png");
                break;
            case 4:
                card.setImageName("boss_wujin_portrait_hex@2x.png");
                break;
        }
    }
}
