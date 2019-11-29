package heroes;

import java.util.ArrayList;
import java.util.List;

public class HeroesFactory {

        public static Hero createHero(Character heroType, final int x, final int y) {
            switch (heroType) {
                case 'K': return new Knight('L', x, y, 900, 80, 0.15f);
                case 'P': return new Pyromancer('V', x, y, 500, 50, 0.25f);
                case 'R': return new Rogue('W', x, y, 600, 40, 0.15f);
                case 'W': return new Wizard('D', x, y, 400,30, 0.1f);
            }
            throw new IllegalArgumentException("The hero type " + heroType + " is not recognized.");
        }

        public static ArrayList<Hero> createHeroes(List<Character> heroes, Integer[][] heroesPosition) {
            ArrayList<Hero> heroesList = new ArrayList<Hero>();
            int i;
            for (i = 0; i < heroes.size(); i++) {
                heroesList.add(createHero(heroes.get(i), heroesPosition[i][0], heroesPosition[i][1])) ;
            }
            return heroesList;
        }
}
