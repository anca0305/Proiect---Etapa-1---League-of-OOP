package angels;

import common.Constants;
import heroes.*;

public class LevelUpAngel extends Angel {

    public LevelUpAngel(final int round, final int x, final int y, final String name,
                        final int type) {
        super(round, x, y, name, type);
    }

    public void levelUp(final Hero h) {
        h.setXp2(Constants.MINHPFORLEVEL1 + (h.getLevel() + 1) * Constants.HPLEVELUP);
        h.setHp(h.getInitialhp() + h.getHpperlevel() * (h.getLevel() + 1));
        h.setOldLevel(h.getLevel());
        h.setLevel(h.getLevel() + 1);
    }

    @Override
    public void interactWith(final Knight knight) {
        this.levelUp(knight);
        knight.setRaceAmplificationFA(knight.getRaceAmplificationFA() * Constants.RACEMODIFIER11);
        knight.setRaceAmplificationSA(knight.getRaceAmplificationSA() * Constants.RACEMODIFIER11);
    }

    @Override
    public void interactWith(final Pyromancer pyromancer) {
        this.levelUp(pyromancer);
        pyromancer.setRaceAmplificationFA(pyromancer.getRaceAmplificationFA()
                * Constants.RACEMODIFIER12);
        pyromancer.setRaceAmplificationSA(pyromancer.getRaceAmplificationSA()
                * Constants.RACEMODIFIER12);
    }

    @Override
    public void interactWith(final Rogue rogue) {
        this.levelUp(rogue);
        rogue.setRaceAmplificationFA(rogue.getRaceAmplificationFA() * Constants.RACEMODIFIER115);
        rogue.setRaceAmplificationSA(rogue.getRaceAmplificationSA() * Constants.RACEMODIFIER115);
    }

    @Override
    public void interactWith(final Wizard wizard) {
        this.levelUp(wizard);
        wizard.setRaceAmplificationFA(wizard.getRaceAmplificationFA() * Constants.RACEMODIFIER125);
        wizard.setRaceAmplificationSA(wizard.getRaceAmplificationSA() * Constants.RACEMODIFIER125);
    }

    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
