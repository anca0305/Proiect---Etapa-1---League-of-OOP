package main;

import heroes.Hero;
import heroes.HeroesFactory;

import java.util.ArrayList;

public class Main {

    private Main() {
        // just to trick checkstyle
    }

    public static void main(String[] args) {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        //System.out.println(gameInput.getNrRunde());
        ArrayList<Hero> heroes;
        HeroesFactory hf = new HeroesFactory();
        heroes = hf.createHeroes(gameInput.getHeroes(), gameInput.getHeroesPosition());
        System.out.println(heroes.get(2).getBonusDamage());
    }
}
