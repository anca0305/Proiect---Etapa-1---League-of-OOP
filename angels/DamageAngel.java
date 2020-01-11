package angels;

import common.Constants;
import heroes.*;

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
        knight.setRaceAmplificationFA(knight.getRaceAmplificationFA() * Constants.RACEMODIFIER115);
        knight.setRaceAmplificationSA(knight.getRaceAmplificationSA() * Constants.RACEMODIFIER115);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setRaceAmplificationFA(pyromancer.getRaceAmplificationFA()
                * Constants.RACEMODIFIER12);
        pyromancer.setRaceAmplificationSA(pyromancer.getRaceAmplificationSA()
                * Constants.RACEMODIFIER12);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setRaceAmplificationFA(rogue.getRaceAmplificationFA() * Constants.RACEMODIFIER13);
        rogue.setRaceAmplificationSA(rogue.getRaceAmplificationSA() * Constants.RACEMODIFIER13);
    }
    /**
     * Functie ce aplica modificarile date de DamageAngel unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setRaceAmplificationFA(wizard.getRaceAmplificationFA() * Constants.RACEMODIFIER14);
        wizard.setRaceAmplificationSA(wizard.getRaceAmplificationSA() * Constants.RACEMODIFIER14);
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
