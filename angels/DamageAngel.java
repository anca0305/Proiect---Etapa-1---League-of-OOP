package angels;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class DamageAngel extends Angel {

    public DamageAngel(final int round, final int x, final int y, final String name,
                       final int type) {
        super(round, x, y, name, type);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Knight.
     */
    @Override
    public void interactWith(final Knight knight) {
        knight.setAngelModifier(knight.getAngelModifier() + Constants.ANGELMODIFIER15);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setAngelModifier(pyromancer.getAngelModifier() + Constants.ANGELMODIFIER2);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setAngelModifier(rogue.getAngelModifier() + Constants.ANGELMODIFIER3);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setAngelModifier(wizard.getAngelModifier() + Constants.ANGELMODIFIER4);
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
