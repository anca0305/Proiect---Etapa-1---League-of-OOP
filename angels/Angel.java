package angels;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

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
    /**
     * Verificarea suprapunerii pozitiei unui inger cu un erou.
     */
    public int checkPosition(final Hero h) {
        if (h.getX() == this.getX()) {
            if (h.getY() == this.getY()) {
                return 1;
            }
        }
        return 0;
    }
    /**
     * Getter pentru numele ingerului.
     */
    public String getName() {
        return name;
    }
    /**
     * Getter pentru runda in care apare ingerul.
     */
    public int getRound() {
        return round;
    }
    /**
     * Getter pentru prima coordonata a pozitiei ingerului.
     */
    public int getX() {
        return x;
    }
    /**
     * Getter pentru pentru cea de-a doua coordonata a pozitiei ingerului.
     */
    public int getY() {
        return y;
    }
    /**
     * Getter pentru tipul ingerului.
     */
    public int getType() {
        return type;
    }
    /**
     * Functie de afisare. Aici se va folosi tipul ingerului pentru a determina actiunea
     * pe care acesta o executa asupra unui erou.
     */
    public void action(final Hero h, final BufferedWriter writer) throws IOException {
        if (this.getType() == Constants.ANGELTYPE1 || this.getType() == Constants.ANGELTYPE3) {
            writer.write(this.getName() + " helped " + h.getName() + " " + h.getID());
        }
        if (this.getType() == Constants.ANGELTYPE2 || this.getType() == Constants.ANGELTYPE4) {
            writer.write(this.getName() + " hit " + h.getName() + " " + h.getID());
        }
        if (this.getType() == Constants.ANGELTYPE3) {
            writer.write("\n" + "Player " + h.getName() + " " + h.getID()
                    + " was brought to life by an angel");
        }
        if (this.getType() == Constants.ANGELTYPE4) {
            writer.write("\n" + "Player " + h.getName() + " " + h.getID()
                    + " was killed by an angel");
        }
        writer.write("\n");
        if (this.getType() == Constants.ANGELTYPE1 || this.getType() == Constants.ANGELTYPE2) {
            for (int i = h.getOldLevel() + 1; i <= h.getLevel(); i++) {
                writer.write(h.getName() + " " + h.getID() + " reached level " + i + "\n");
            }
            h.setOldLevel(h.getLevel());
        }
    }

}
