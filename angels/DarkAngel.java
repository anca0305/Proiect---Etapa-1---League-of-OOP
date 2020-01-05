package angels;

import common.Constants;
import heroes.*;

public class DarkAngel extends Angel {

    public DarkAngel(final int round, final int x, final int y, final String name,
                     final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setHp(knight.getHp() - Constants.HPMODIFIER40);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setHp(pyromancer.getHp() - Constants.HPMODIFIER30);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setHp(rogue.getHp() - Constants.HPMODIFIER10);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setHp(wizard.getHp() - Constants.HPMODIFIER20);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
