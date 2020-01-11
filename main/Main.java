package main;

import angels.Angel;
import angels.AngelsFactory;
import heroes.Hero;
import heroes.HeroesFactory;
import map.Moves;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

final class Main {

    private Main() {
        // just to trick checkstyle
    }

    public static void main(final String[] args) throws IOException {
        GameInputLoader gameInputLoader = new GameInputLoader(args[0], args[1]);
        GameInput gameInput = gameInputLoader.load();
        BufferedWriter writer = new BufferedWriter(new FileWriter(args[1]));
        ArrayList<Hero> heroes;
        ArrayList<Angel> angels;
        heroes = HeroesFactory.createHeroes(gameInput.getHeroes(), gameInput.getHeroesPosition());
        angels = AngelsFactory.createAngels(gameInput.getAngels(), gameInput.getAngelsPosition());
        int i;
        int j;
        int k;
        int aux;
        Character[][] map;
        map = gameInput.getMap();
        Moves moves = new Moves();
        for (i = 0; i < gameInput.getNoRounds(); i++) {
            if (i != 0) {
                writer.write("\n");
            }
            writer.write("~~ Round " + (i + 1) + " ~~" + "\n");
            moves.moves(i, heroes, gameInput.getMoves());
            for (j = 0; j < heroes.size(); j++) {
                heroes.get(j).setCurrentGround(map[heroes.get(j).getX()][heroes.get(j).getY()]);
                heroes.get(j).setCurrentRound(i);
                heroes.get(j).setChecked(0);
            }
            for (j = 0; j < heroes.size() - 1; j++) {
                for (k = j + 1; k < heroes.size(); k++) {
                    if (heroes.get(j).checkPosition(heroes.get(k))) {
                        if (heroes.get(j).getHp() < 0) {
                            heroes.get(j).setDead(1);
                        }
                        if (heroes.get(k).getHp() < 0) {
                            heroes.get(k).setDead(1);
                        }
                        if (heroes.get(j).getDead() == 0 && heroes.get(k).getDead() == 0) {
                            heroes.get(j).calculateDamage(heroes.get(j).getCurrentGround(),
                                    heroes.get(k), heroes.get(j).getLevel(), gameInput.getMap(),
                                    angels, gameInput.getAngelsPosition());
                            heroes.get(k).calculateDamage(heroes.get(k).getCurrentGround(),
                                    heroes.get(j), heroes.get(k).getLevel(), gameInput.getMap(),
                                    angels, gameInput.getAngelsPosition());
                            if (heroes.get(j).getDead() == 1 || heroes.get(j).getHp() < 0) {
                                heroes.get(j).setDead(1);
                                heroes.get(j).setChecked(1);
                                writer.write("Player " + heroes.get(j).getName() + " "
                                        + heroes.get(j).getID() + " was killed by "
                                        + heroes.get(k).getName() + " " + heroes.get(k).getID()
                                        + "\n");
                                for (int noLevels = heroes.get(k).getOldLevel() + 1;
                                     noLevels <= heroes.get(k).getLevel(); noLevels++) {
                                    writer.write(heroes.get(k).getName() + " "
                                            + heroes.get(k).getID() + " reached level " + noLevels
                                            + "\n");
                                }
                            }
                            if (heroes.get(k).getDead() == 1 || heroes.get(k).getHp() < 0) {
                                    heroes.get(k).setDead(1);
                            }
                            if (heroes.get(j).getDead() == 1) {
                                if (heroes.get(j).getKiller() != null
                                        && heroes.get(j).getKiller().getDead() == 0) {
                                    heroes.get(j).getKiller().setXp(heroes.get(j).getLevel());
                                    heroes.get(j).getKiller().checkLevel();
                                }
                            }
                            if (heroes.get(k).getDead() == 1 || heroes.get(k).getHp() < 0) {
                                heroes.get(k).setDead(1);
                                heroes.get(j).setChecked(1);
                                writer.write("Player " + heroes.get(k).getName() + " "
                                        + heroes.get(k).getID() + " was killed by "
                                        + heroes.get(j).getName() + " " + heroes.get(j).getID()
                                        + "\n");
                                if (heroes.get(k).getKiller() != null
                                        && heroes.get(k).getKiller().getDead() == 0) {
                                    heroes.get(k).getKiller().setXp(heroes.get(k).getLevel());
                                    heroes.get(k).getKiller().checkLevel();
                                    for (int noLevels = heroes.get(j).getOldLevel() + 1;
                                         noLevels <= heroes.get(j).getLevel(); noLevels++) {
                                        writer.write(heroes.get(j).getName() + " "
                                                + heroes.get(j).getID() + " reached level "
                                                + noLevels + "\n");
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (Angel a : angels) {
                if (a.getRound() == i) {
                    writer.write("Angel " + a.getName() + " was spawned at "
                            + a.getX() + " " + a.getY() + "\n");
                    for (Hero h : heroes) {
                        System.out.println(h.getName() + " " + h.getID() + " " + h.toString());
                        if (a.checkPosition(h) == 1) {//&& h.getChecked() == 0) {
                            if (h.getDead() != 1 || (h.getDead() == 1 && a.getType() == 3))
                            h.interactWith(a);
                           // h.setChecked(1);
                            a.action(h, writer);
                        }
                    }
                }
            }
        }
        writer.write("\n");
        writer.write("~~ Results ~~" + "\n");
        for (i = 0; i < heroes.size(); i++) {
            writer.write(gameInput.getHeroes().get(i) + heroes.get(i).toString() + "\n");
        }
        writer.close();
    }
}
