package angels;

import common.Constants;
import heroes.*;

public class GoodBoy extends Angel {

    public GoodBoy(final int round, final int x, final int y, final String name,
                   final int type) {
        super(round, x, y, name, type);
    }

    @Override
    public void interactWith(final Knight knight) {
        knight.setRaceAmplificationFA(knight.getRaceAmplificationFA() * Constants.RACEMODIFIER14);
        knight.setRaceAmplificationSA(knight.getRaceAmplificationSA() * Constants.RACEMODIFIER14);
        knight.setHp(knight.getHp() + Constants.HPMODIFIER20);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        pyromancer.setRaceAmplificationFA(pyromancer.getRaceAmplificationFA()
                * Constants.RACEMODIFIER15);
        pyromancer.setRaceAmplificationSA(pyromancer.getRaceAmplificationSA()
                * Constants.RACEMODIFIER15);
        pyromancer.setHp(pyromancer.getHp() + Constants.HPMODIFIER30);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        rogue.setRaceAmplificationFA(rogue.getRaceAmplificationFA() * Constants.RACEMODIFIER14);
        rogue.setRaceAmplificationSA(rogue.getRaceAmplificationSA() * Constants.RACEMODIFIER14);
        rogue.setHp(rogue.getHp() + Constants.HPMODIFIER40);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        wizard.setRaceAmplificationFA(wizard.getRaceAmplificationFA() * Constants.RACEMODIFIER13);
        wizard.setRaceAmplificationSA(wizard.getRaceAmplificationSA() * Constants.RACEMODIFIER13);
        wizard.setHp(wizard.getHp() + Constants.HPMODIFIER50);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
