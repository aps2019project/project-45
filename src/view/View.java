package view;

import model.*;

public class View {
    private static final View VIEW = new View();

    private View() {
    }

    public static View getInstance() {
        return VIEW;
    }

    public static void showHeroInformation(Hero hero) {
        System.out.printf("Name : %s - AP : %d - HP : %d - Class : %s - Special Power : %s", hero.getName(), hero.getAP(),
                hero.getHealth(), hero.getHeroClass(), hero.getSpecialPower()); //should be completedباید کامل شود
    }

    public static void showItemInformation(Item item) {
        System.out.printf("Name : %s - Desc : %s", item.getName(), item.getDesc());
    }

    public static void showMinionInformation(Minion minion) {
        System.out.printf("Type : Minion - Name : %s - Class : %s - AP : %d - HP : %d - MP : %d - Special Power : %s",
                minion.getName(), minion.getMinionClass(), minion.getAP(), minion.getHealth(), minion.getMP(),
                minion.getSpecialPower());
    }

    public static void showSpellInformation(Spell spell) {
        System.out.printf("Type : Spell - Name : %s - MP : %d - Desc : %s", spell.getName(), spell.getMP(), spell.getDesc());
    }

    public static void showCardOrItemInformationWithCost(CardOrItem cardOrItem, int i) {
        if (cardOrItem instanceof Hero) {
            System.out.printf("           %d : ", i + 1);
            showHeroInformation((Hero) cardOrItem);
            System.out.printf(" - Cost : %d\n", cardOrItem.getCost());
        } else if (cardOrItem instanceof Item) {
            System.out.printf("           %d : ", i + 1);
            showItemInformation((Item) cardOrItem);
            System.out.printf(" - Cost : %d\n", cardOrItem.getCost());
        } else if (cardOrItem instanceof Minion) {
            System.out.printf("           %d : ", i + 1);
            showMinionInformation((Minion) cardOrItem);
            System.out.printf(" - Cost : %d\n", cardOrItem.getCost());
        } else if (cardOrItem instanceof Spell) {
            System.out.printf("           %d : ", i + 1);
            showSpellInformation((Spell) cardOrItem);
            System.out.printf(" - Cost : %d\n", cardOrItem.getCost());
        }
    }
}
