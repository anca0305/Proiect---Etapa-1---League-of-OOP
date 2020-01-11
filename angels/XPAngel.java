package angels;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class XPAngel extends Angel {

    public XPAngel(final int round, final int x, final int y, final String name,
                   final int type) {
        super(round, x, y, name, type);
    }
    /**
     * Functie ce aplica modificarile date de XPAngel unui erou de tip Knight.
     */
    @Override
    public void interactWith(final Knight knight) {
        knight.setXp2(knight.getXp() + Constants.XPMODIFIER45);
    }
    /**
     * Functie ce aplica modificarile date de XPAngel unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setXp2(pyromancer.getXp() + Constants.XPMODIFIER50);
    }
    /**
     * Functie ce aplica modificarile date de XPAngel unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setXp2(rogue.getXp() + Constants.XPMODIFIER40);
    }
    /**
     * Functie ce aplica modificarile date de XPAngel unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setXp2(wizard.getXp() + Constants.XPMODIFIER60);
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
