package angels;

import common.Constants;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import heroes.Rogue;
import heroes.Wizard;

public class LevelUpAngel extends Angel {

    public LevelUpAngel(final int round, final int x, final int y, final String name,
                        final int type) {
        super(round, x, y, name, type);
    }
    /**
     * Functie ce ofera XP cat are nevoie eroul pentru a avansa la nivelul urmator.
     */
    public void levelUp(final Hero h) {
        h.setXp2(Constants.MINHPFORLEVEL1 + (h.getLevel() * Constants.HPLEVELUP));
        h.setHp(h.getInitialhp() + h.getHpperlevel() * (h.getLevel() + 1));
        h.setOldLevel(h.getLevel());
        h.setLevel(h.getLevel() + 1);
    }
    /**
     * Functie ce aplica modificarile date de LevelUpAngel unui erou de tip Knight.
     */
    @Override
    public void interactWith(final Knight knight) {
        this.levelUp(knight);
        knight.setAngelModifier(knight.getAngelModifier() + Constants.ANGELMODIFIER1);
    }
    /**
     * Functie ce aplica modificarile date de LevelUpAngel unui erou de tip Pyromancer.
     */
    @Override
    public void interactWith(final Pyromancer pyromancer) {
        this.levelUp(pyromancer);
        pyromancer.setAngelModifier(pyromancer.getAngelModifier() + Constants.ANGELMODIFIER2);
    }
    /**
     * Functie ce aplica modificarile date de LevelUpAngel unui erou de tip Rogue.
     */
    @Override
    public void interactWith(final Rogue rogue) {
        this.levelUp(rogue);
        rogue.setAngelModifier(rogue.getAngelModifier() + Constants.ANGELMODIFIER15);
    }
    /**
     * Functie ce aplica modificarile date de LevelUpAngel unui erou de tip Wizard.
     */
    @Override
    public void interactWith(final Wizard wizard) {
        this.levelUp(wizard);
        wizard.setAngelModifier(wizard.getAngelModifier() + Constants.ANGELMODIFIER25);
    }
    /**
     * Functie folosita pentru a creea legatura folosita de catre tehnica double dispatch.
     */
    @Override
    public void accept(final Hero h) {
        h.accept(this);
    }
}
