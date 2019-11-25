package com.etapa1.heroes;

public class Knight extends Hero {

    public Knight(Character mainGround, int x, int y,
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
