package angels;

import heroes.*;

public class TheDoomer extends Angel {

    public TheDoomer(final int round, final int x, final int y, final String name,
                     final int type) {
        super(round, x, y, name, type);
    }
    /**
     * Functie ce aplica modificarile date de TheDoomer unui erou de tip Knight.
     */
    @Override
    public void interactWith(final Knight knight) {
        knight.setDead(1);
    }
    /**
     * Functie ce aplica modificarile date de TheDoomer unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setDead(1);
    }
    /**
     * Functie ce aplica modificarile date de TheDoomer unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setDead(1);
    }
    /**
     * Functie ce aplica modificarile date de TheDoomer unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setDead(1);
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
