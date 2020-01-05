package angels;

import common.Constants;
import heroes.*;

public class LifeGiver extends Angel {

    public LifeGiver(final int round, final int x, final int y, final String name,
                     final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setHp(knight.getHp() + Constants.HPMODIFIER100);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() + Constants.HPMODIFIER80);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHp(rogue.getHp() + Constants.HPMODIFIER90);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHp(wizard.getHp() + Constants.HPMODIFIER120);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
