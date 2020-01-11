package heroes;

import angels.Angel;
import angels.DamageAngel;
import angels.DarkAngel;
import angels.Dracula;
import angels.GoodBoy;
import angels.LevelUpAngel;
import angels.LifeGiver;
import angels.SmallAngel;
import angels.Spawner;
import angels.TheDoomer;
import angels.XPAngel;
import common.Constants;

public final class Wizard extends Hero {

    public Wizard(final Character mainGround, final int x, final int y,
                  final int initialhp, final int hpperlevel, final float bonusDamage,
                  final int id) {
        super(mainGround, x, y, initialhp, hpperlevel, bonusDamage, id);
        this.name = "Wizard";
    }

    @Override
    public void calculateRaceAmplificationFor(final Hero h) {
        h.calculateRaceAmplification(this);
    }

    @Override
    public void calculateRaceAmplification(final Knight knight) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION12 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION14 + this.angelModifier
                + this.strategyModifier;
    }

    @Override
    public void calculateRaceAmplification(final Pyromancer pyromancer) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION09 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION13 + this.angelModifier
                + this.strategyModifier;
    }

    @Override
    public void calculateRaceAmplification(final Rogue rogue) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION08 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION12 + this.angelModifier
                + this.strategyModifier;
    }

    @Override
    public void calculateRaceAmplification(final Wizard wizard) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION105 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.DEFAULTRACEAMPIFICATION;
    }
    /**
     * @param ground Tipul terenului pe care va avea loc lupta
     * @param h Eroul cu care se va lupta
     * @param level Nivelul curent pe care il are eroul
     * Functia va seta killer-ul eroului atacat ca fiind eroul curent - astfel, in cazul in care
     * eroul atacat moare in urma damege-ului primit la runda curenta sau dat de o abilitate ce
     * are efect overtime, eroul curent - atacatorul - va primi xp-ul corespunzator.
     * Vom calcula damage-ul dat de fiecare abilitate si il vom aplica eroului atacat.
     */
    @Override
    public void calculateDamage(final Character ground, final Hero h, final int level) {
        h.setKiller(this);
        float procent = Constants.DEFAULTPROCENTAGEFAW
                + Constants.PROCENTAGEPERLEVELFAW * this.getLevel();
        float aux;
        h.calculateRaceAmplificationFor(this);
        procent *= this.raceAmplificationFA;
        procent *= this.calculateGroundAmplification(ground);
        float min = h.getInitialhp() + h.getLevel() * h.getHpperlevel();
        min *= Constants.AMPLIFICATIONW;
        if (min > h.getHp()) {
            min = h.getHp();
        }
        aux = procent * min;
        procent = Constants.DEFAULTPROCENTAGESAW
                + Constants.PROCENTAGEPERLEVELSAW * this.getLevel();
        if (procent > Constants.MAXPROCENTAGESAW) {
            procent = Constants.MAXPROCENTAGESAW;
        }
        procent *= this.raceAmplificationSA;
        if (procent == Constants.DEFAULTRACEAMPIFICATION) {
            h.receiveDamage(Math.round(aux));
            return;
        }
        h.calculateDamage(ground, this, level);
        this.setHp(this.getHp() + h.damage);
        procent *= this.calculateGroundAmplification(ground);
        procent *= (Math.round(h.damageFirstAbility * h.calculateGroundAmplification(ground))
                + Math.round(h.damageSecondAbility * h.calculateGroundAmplification(ground)));
        aux = Math.round(aux);
        aux += procent;
        this.damage = Math.round(aux);
        h.receiveDamage(this.damage);
    }
    /**
     * @param level Nivelul curent pe care il are eroul
     * Functia va seta valorile damage-ului dat de cele doua abilitati ale eroului de tip Wizard.
     * Acestea vor avea initial valoarea 0, intrucat ele sunt calculate in functie de damage-ul dat
     * de oponent, de hp-ul lui initial si cel curent, de terenul pe care se desfasoara lupta, de
     * eroul cu care se lupta etc.
     */
    @Override
    void setDamageAbilities(final int level) {
        this.damageFirstAbility = Constants.DEFAULTVALUE;
        this.damageSecondAbility = Constants.DEFAULTVALUE;
    }

    @Override
    public void accept(final DamageAngel damageAngel) {
        damageAngel.interactWith(this);
    }

    @Override
    public void accept(final DarkAngel darkAngel) {
        darkAngel.interactWith(this);
    }

    @Override
    public void accept(final Dracula dracula) {
        dracula.interactWith(this);
    }

    @Override
    public void accept(final GoodBoy goodBoy) {
        goodBoy.interactWith(this);
    }

    @Override
    public void accept(final LevelUpAngel levelUpAngel) {
        levelUpAngel.interactWith(this);
    }

    @Override
    public void accept(final LifeGiver lifeGiver) {
        lifeGiver.interactWith(this);
    }

    @Override
    public void accept(final SmallAngel smallAngel) {
        smallAngel.interactWith(this);
    }

    @Override
    public void accept(final Spawner spawner) {
        spawner.interactWith(this);
    }

    @Override
    public void accept(final TheDoomer theDoomer) {
        theDoomer.interactWith(this);
    }

    @Override
    public void accept(final XPAngel xpAngel) {
        xpAngel.interactWith(this);
    }

    @Override
    public void interactWith(final Angel a) {
        a.accept(this);
    }

    @Override
    public void strategy() {
        float maxLevelHp = this.getInitialhp() + this.getLevel() * this.getHpperlevel();
        if (maxLevelHp / Constants.FOUR < this.getHp()) {
            if (this.getHp() < maxLevelHp / Constants.TWO) {
                this.setHp((int) (this.getHp() * Constants.HPMODIFIER09));
                this.strategyModifier += Constants.STRATEGYMODIFIER06;
            }
        }
        if (this.getHp() < maxLevelHp / Constants.FOUR) {
            this.setHp((int) (this.getHp() * Constants.HPMODIFIER12));
            this.strategyModifier -= Constants.STRATEGYMODIFIER02;
        }
    }
}
