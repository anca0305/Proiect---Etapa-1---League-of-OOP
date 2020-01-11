package heroes;

import common.Constants;

import java.util.ArrayList;
import java.util.List;

public final class HeroesFactory {

    private HeroesFactory() {
    }

    public static Hero createHero(final Character heroType, final int x, final int y,
                                  final int i, final String name) {
        switch (heroType) {
            case 'K':
                return new Knight('L', x, y, Constants.INITIALHPK,
                        Constants.HPPERLEVELK, Constants.BONUSDAMAGEK, i, "Knight");
            case 'P':
                return new Pyromancer('V', x, y, Constants.INITIALHPP,
                        Constants.HPPERLEVELP, Constants.BONUSDAMAGEP, i, "Pyromancer");
            case 'R':
                return new Rogue('W', x, y, Constants.INITIALHPR,
                        Constants.HPPERLEVELR, Constants.BONUSDAMAGER, i, "Rogue");
            case 'W':
                return new Wizard('D', x, y, Constants.INITIALHPW,
                        Constants.HPPERLEVELW, Constants.BONUSDAMAGEW, i, "Wizard");
            default:
                return null;
        }
    }

    public static ArrayList<Hero> createHeroes(final List<Character> heroes,
                                               final Integer[][] heroesPosition) {
        ArrayList<Hero> heroesList = new ArrayList<Hero>();
        int i;
        for (i = 0; i < heroes.size(); i++) {
            heroesList.add(createHero(heroes.get(i), heroesPosition[i][0],
                    heroesPosition[i][1], i, null));
        }
        return heroesList;
    }
}
