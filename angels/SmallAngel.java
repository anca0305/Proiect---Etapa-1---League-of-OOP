package angels;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class SmallAngel extends Angel {

    public SmallAngel(final int round, final int x, final int y, final String name,
                      final int type) {
        super(round, x, y, name, type);
    }
    /**
     * Functie ce aplica modificarile date de SmallAngel unui erou de tip Knight.
     */
    @Override
    public void interactWith(final Knight knight) {
        knight.setAngelModifier(knight.getAngelModifier() + Constants.ANGELMODIFIER1);
        knight.setHp(knight.getHp() + Constants.HPMODIFIER10);
    }
    /**
     * Functie ce aplica modificarile date de SmallAngel unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setAngelModifier(pyromancer.getAngelModifier() + Constants.ANGELMODIFIER15);
        pyromancer.setHp(pyromancer.getHp() + Constants.HPMODIFIER15);
    }
    /**
     * Functie ce aplica modificarile date de SmallAngel unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setAngelModifier(rogue.getAngelModifier() + Constants.ANGELMODIFIER05);
        rogue.setHp(rogue.getHp() + Constants.HPMODIFIER20);
    }
    /**
     * Functie ce aplica modificarile date de SmallAngel unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setAngelModifier(wizard.getAngelModifier() + Constants.ANGELMODIFIER1);
        wizard.setHp(wizard.getHp() + Constants.HPMODIFIER25);
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
