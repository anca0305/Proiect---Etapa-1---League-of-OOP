package angels;

import common.Constants;
import heroes.*;

public class Dracula extends Angel {

    public Dracula(final int round, final int x, final int y, final String name,
                   final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setRaceAmplificationFA(knight.getRaceAmplificationFA() * Constants.RACEMODIFIER08);
        knight.setRaceAmplificationSA(knight.getRaceAmplificationSA() * Constants.RACEMODIFIER08);
        knight.setHp(knight.getHp() - Constants.HPMODIFIER60);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setRaceAmplificationFA(pyromancer.getRaceAmplificationFA()
                * Constants.RACEMODIFIER07);
        pyromancer.setRaceAmplificationSA(pyromancer.getRaceAmplificationSA()
                * Constants.RACEMODIFIER07);
        pyromancer.setHp(pyromancer.getHp() - Constants.HPMODIFIER40);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setRaceAmplificationFA(rogue.getRaceAmplificationFA() * Constants.RACEMODIFIER09);
        rogue.setRaceAmplificationSA(rogue.getRaceAmplificationSA() * Constants.RACEMODIFIER09);
        rogue.setHp(rogue.getHp() - Constants.HPMODIFIER35);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setRaceAmplificationFA(wizard.getRaceAmplificationFA() * Constants.RACEMODIFIER06);
        wizard.setRaceAmplificationSA(wizard.getRaceAmplificationSA() * Constants.RACEMODIFIER06);
        wizard.setHp(wizard.getHp() - Constants.HPMODIFIER20);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
