package angels;

import common.Constants;
import heroes.*;

import java.io.BufferedWriter;
import java.io.IOException;

public abstract class Angel {
    private final String name;
    private final int round;
    private final int x;
    private final int y;
    private final int type;

    public Angel(final int round, final int x, final int y, final String name, final int type) {
        this.round = round;
        this.x = x;
        this.y = y;
        this.name = name;
        this.type = type;
    }

    public abstract void interactWith(Knight knight);

    public abstract void interactWith(Pyromancer pyromancer);

    public abstract void interactWith(Rogue rogue);

    public abstract void interactWith(Wizard wizard);

    public abstract void accept(Hero h);

    public int checkPosition(final Hero h) {
        if (h.getX() == this.getX()) {
            if (h.getY() == this.getY()) {
                return 1;
            }
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public int getRound() {
        return round;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getType() {
        return type;
    }

    public void action(final Hero h, final BufferedWriter writer) throws IOException {
//        for (int noLevels = h.getOldLevel() + 1 ; noLevels <= h.getLevel() ; noLevels++) {
//            System.out.println("Player " + h.getName() + " " + h.getID()
//                    + " reached level " + noLevels);
//            writer.write("Player " + h.getName() + " " + h.getID()
//                    + " reached level " + noLevels);
//        }
        if (this.getType() == Constants.ANGELTYPE1 || this.getType() == Constants.ANGELTYPE3) {
            writer.write(this.getName() + " helped " + h.getName() + " " + h.getID());
            System.out.println(this.getName() + " helped " + h.getName() + " " + h.getID());
        }
        if (this.getType() == Constants.ANGELTYPE2 || this.getType() == Constants.ANGELTYPE4) {
            writer.write(this.getName() + " hit " + h.getName() + " " + h.getID());
            System.out.println(this.getName() + " hit " + h.getName() + " " + h.getID());
        }
        if (this.getType() == Constants.ANGELTYPE3) {
            writer.write("\n" + "Player " + h.getName() + " " + h.getID()
                    + " was brought to life by an angel");
            System.out.println("Player " + h.getName() + " " + h.getID()
                    + " was brought to life by an angel");
        }
        if (this.getType() == Constants.ANGELTYPE4) {
            writer.write("\n" + "Player " + h.getName() + " " + h.getID()
                    + " was killed by an angel");
            System.out.println("Player " + h.getName() + " " + h.getID()
                    + " was killed by an angel");
        }
        writer.write("\n");
    }
}
