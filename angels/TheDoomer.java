package angels;

import heroes.*;

public class TheDoomer extends Angel {

    public TheDoomer(final int round, final int x, final int y, final String name,
                     final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setDead(1);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setDead(1);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setDead(1);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setDead(1);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
