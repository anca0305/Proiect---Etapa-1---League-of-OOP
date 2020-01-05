package angels;

import common.Constants;
import heroes.*;

public class SmallAngel extends Angel {

    public SmallAngel(final int round, final int x, final int y, final String name,
                      final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setRaceAmplificationFA(knight.getRaceAmplificationFA() * Constants.RACEMODIFIER11);
        knight.setRaceAmplificationSA(knight.getRaceAmplificationSA() * Constants.RACEMODIFIER11);
        knight.setHp(knight.getHp() + Constants.HPMODIFIER10);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setRaceAmplificationFA(pyromancer.getRaceAmplificationFA()
                * Constants.RACEMODIFIER115);
        pyromancer.setRaceAmplificationSA(pyromancer.getRaceAmplificationSA()
                * Constants.RACEMODIFIER115);
        pyromancer.setHp(pyromancer.getHp() + Constants.HPMODIFIER15);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setRaceAmplificationFA(rogue.getRaceAmplificationFA() * Constants.RACEMODIFIER105);
        rogue.setRaceAmplificationSA(rogue.getRaceAmplificationSA() * Constants.RACEMODIFIER105);
        rogue.setHp(rogue.getHp() + Constants.HPMODIFIER20);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setRaceAmplificationFA(wizard.getRaceAmplificationFA() * Constants.RACEMODIFIER11);
        wizard.setRaceAmplificationSA(wizard.getRaceAmplificationSA() * Constants.RACEMODIFIER11);
        wizard.setHp(wizard.getHp() + Constants.HPMODIFIER25);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
