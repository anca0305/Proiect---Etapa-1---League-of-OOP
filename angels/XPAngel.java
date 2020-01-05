package angels;

import common.Constants;
import heroes.*;

public class XPAngel extends Angel {

    public XPAngel(final int round, final int x, final int y, final String name,
                   final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setXp2(knight.getXp() + Constants.XPMODIFIER45);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setXp2(pyromancer.getXp() + Constants.XPMODIFIER50);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setXp2(rogue.getXp() + Constants.XPMODIFIER40);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setXp2(wizard.getXp() + Constants.XPMODIFIER60);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
