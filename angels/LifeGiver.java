package angels;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LifeGiver extends Angel {

    public LifeGiver(final int round, final int x, final int y, final String name,
                     final int type) {
        super(round, x, y, name, type);
    }
    /**
     * Functie ce aplica modificarile date de LifeGiver unui erou de tip Knight.
     */
    @Override
    public void interactWith(final Knight knight) {
        int maxLevelHp = knight.getInitialhp() + knight.getLevel() * knight.getHpperlevel();
        if ((knight.getHp() + Constants.HPMODIFIER100) <= maxLevelHp) {
            knight.setHp(knight.getHp() + Constants.HPMODIFIER100);
        } else {
            knight.setHp(maxLevelHp);
        }
    }
    /**
     * Functie ce aplica modificarile date de LifeGiver unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        int maxLevelHp = pyromancer.getInitialhp()
                + pyromancer.getLevel() * pyromancer.getHpperlevel();
        if ((pyromancer.getHp() + Constants.HPMODIFIER80) <= maxLevelHp) {
            pyromancer.setHp(pyromancer.getHp() + Constants.HPMODIFIER80);
        } else {
            pyromancer.setHp(maxLevelHp);
        }
    }
    /**
     * Functie ce aplica modificarile date de LifeGiver unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        int maxLevelHp = rogue.getInitialhp() + rogue.getLevel() * rogue.getHpperlevel();
        if ((rogue.getHp() + Constants.HPMODIFIER90) <= maxLevelHp) {
            rogue.setHp(rogue.getHp() + Constants.HPMODIFIER90);
        } else {
            rogue.setHp(maxLevelHp);
        }
    }
    /**
     * Functie ce aplica modificarile date de LifeGiver unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        int maxLevelHp = wizard.getInitialhp() + wizard.getLevel() * wizard.getHpperlevel();
        if ((wizard.getHp() + Constants.HPMODIFIER120) <= maxLevelHp) {
            wizard.setHp(wizard.getHp() + Constants.HPMODIFIER120);
        } else {
            wizard.setHp(maxLevelHp);
        }
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
