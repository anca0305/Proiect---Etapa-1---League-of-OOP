package angels;

import common.Constants;
import heroes.*;

public class Spawner extends Angel {

    public Spawner(final int round, final int x, final int y, final String name,
                   final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        if (knight.getDead() == 1) {
            knight.setDead(0);
            knight.setHp(Constants.HPMODIFIER200);
        }
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        if (pyromancer.getDead() == 1) {
            pyromancer.setDead(0);
            pyromancer.setHp(Constants.HPMODIFIER150);
        }
    }

    @Override
    public void interactWith(final Rogue rogue) {
        if (rogue.getDead() == 1) {
            rogue.setDead(0);
            rogue.setHp(Constants.HPMODIFIER180);
        }
    }

    @Override
    public void interactWith(final Wizard wizard) {
        if (wizard.getDead() == 1) {
            wizard.setDead(0);
            wizard.setHp(Constants.HPMODIFIER120);
        }
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
