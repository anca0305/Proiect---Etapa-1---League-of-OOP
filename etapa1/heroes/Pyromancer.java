package heroes;

public class Pyromancer extends Hero {

    public Pyromancer(Character mainGround, int x, int y,
                      int initialhp, int hpperlevel, float bonusDamage) {
        super(mainGround, x, y, initialhp, hpperlevel, bonusDamage);
    }

    @Override
    public void calculateDamage(int level, Character ground, Hero h) {

    }

    @Override
    public void hitHero(Hero h) {

    }

}
