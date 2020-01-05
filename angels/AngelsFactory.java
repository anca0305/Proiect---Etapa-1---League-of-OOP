package angels;

import common.Constants;

import java.util.ArrayList;

public final class AngelsFactory {

    private AngelsFactory() {
    }

    public static Angel createAngel(final String angelType, final int round, final int x,
                                    final int y, final String name) {
        switch (angelType) {
            case "DamageAngel":
                return new DamageAngel(round, x, y, "DamageAngel", Constants.ANGELTYPE1);
            case "DarkAngel":
                return new DarkAngel(round, x, y, "DarkAngel", Constants.ANGELTYPE2);
            case "Dracula":
                return new Dracula(round, x, y, "Dracula", Constants.ANGELTYPE2);
            case "GoodBoy":
                return new GoodBoy(round, x, y, "GoodBoy", Constants.ANGELTYPE1);
            case "LevelUpAngel":
                return new LevelUpAngel(round, x, y, "LevelUpAngel", Constants.ANGELTYPE1);
            case "LifeGiver":
                return new LifeGiver(round, x, y, "LifeGiver", Constants.ANGELTYPE1);
            case "SmallAngel":
                return new SmallAngel(round, x, y, "SmallAngel", Constants.ANGELTYPE1);
            case "Spawner":
                return new Spawner(round, x, y, "Spawner", Constants.ANGELTYPE3);
            case "TheDoomer":
                return new TheDoomer(round, x, y, "TheDoomer", Constants.ANGELTYPE4);
            case "XPAngel":
                return new XPAngel(round, x, y, "XPAngel", Constants.ANGELTYPE1);

            default:
                return null;
        }
    }

    public static ArrayList<Angel> createAngels(final ArrayList<String> angels,
                                               final Integer[][] angelsPosition) {
        ArrayList<Angel> angelsList = new ArrayList<Angel>();
        int i;
        for (i = 0; i < angels.size(); i++) {
            angelsList.add(createAngel(angels.get(i), angelsPosition[i][0], angelsPosition[i][1],
                    angelsPosition[i][2], null));
        }
        return angelsList;
    }
}
