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

public final class Knight extends Hero {

    public Knight(final Character mainGround, final int x, final int y,
                  final int initialhp, final int hpperlevel, final float bonusDamage,
                  final int id) {
        super(mainGround, x, y, initialhp, hpperlevel, bonusDamage, id);
        this.name = "Knight";
    }

    @Override
    public void calculateRaceAmplificationFor(final Hero h) {
        h.calculateRaceAmplification(this);
    }

    public void calculateRaceAmplification(final Knight knight) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION10;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION12 + this.angelModifier
                + this.strategyModifier;
    }

    public void calculateRaceAmplification(final Pyromancer pyromancer) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION11 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION09 + this.angelModifier
                + this.strategyModifier;
    }

    public void calculateRaceAmplification(final Rogue rogue) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION115 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION08 + this.angelModifier
                + this.strategyModifier;
    }

    public void calculateRaceAmplification(final Wizard wizard) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION08 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION105 + this.angelModifier
                + this.strategyModifier;
    }
    /**
     * @param h Eroul pentru care vom verifica daca are hp-ul suficient de mare incat sa nu fie
     * executat.
     * Functia verifica acest hp si returneaza true daca eroul urmeaza sa fie executat si false,
     * altel, dar nu inainte de a-i seta valoarea campului ce retine daca eroul este sau nu in
     * viata la 1, adica eroul este acum mort.
     */
    public boolean execute(final Hero h) {
        float minHp;
        minHp = Constants.PROCENTAGEFAK + h.getLevel() / Constants.TEN;
        if (minHp > Constants.MAXPROCENTAGEHP) {
            minHp = Constants.MAXPROCENTAGEHP;
        }
        minHp *= (h.getInitialhp() + h.getLevel() * h.getHpperlevel());
        if (h.getHp() < minHp) {
            h.setDead(1);
            //h.setXp(0);
            return true;
        }
        return false;
    }

    /**
     * @param ground Tipul terenului pe care va avea loc lupta
     * @param h Eroul cu care se va lupta
     * @param level Nivelul curent pe care il are eroul
     * Functia va seta killer-ul eroului atacat ca fiind eroul curent - astfel, in cazul in care
     * eroul atacat moare in urma damege-ului primit la runda curenta sau dat de o abilitate ce
     * are efect overtime, eroul curent - atacatorul - va primi xp-ul corespunzator.
     * Daca eroul va muri in urma primei abilitati a lui Knight - execute (eroul atacat are hp-ul
     * mai mic decat limita inferioara, deci va fi omorat direct), functia se va opri.
     * In caz contrar, vom calcula damage-ul dat de fiecare abilitate si vom seta valoarea numarului
     * de runde de incapacitate de miscare ale oponentului la 1, iar cele doua valori ce au legatura
     * cu damage-ul overtime la 0 (anularea efectului unei posibile abilitati cu efect prelungit
     * aplicate anterior).
     * La sfarsit, eroul atacat primeste damage-ul anterior calculat.
     */
    @Override
    public void calculateDamage(final Character ground, final Hero h, final int level) {
        h.setKiller(this);
        if (execute(h)) {
            return;
        }
        this.setDamageAbilities(level);
        float toRoundDamageFA = this.damageFirstAbility;
        toRoundDamageFA *= this.calculateGroundAmplification(ground);
        h.calculateRaceAmplificationFor(this);
        toRoundDamageFA *= this.raceAmplificationFA;
        float toRoundDamageSA = this.damageSecondAbility;
        toRoundDamageSA *= this.calculateGroundAmplification(ground);
        toRoundDamageSA *= this.raceAmplificationSA;
        toRoundDamageFA = Math.round(toRoundDamageFA);
        toRoundDamageFA += toRoundDamageSA;
        this.damage = Math.round(toRoundDamageFA);
        h.noRoundsCantMove = 1;
        h.periodicDamage = Constants.DEFAULTVALUE;
        h.noRoundsToReceivePeriodicDamage = Constants.DEFAULTVALUE;
        h.receiveDamage(this.damage);
    }
    /**
     * @param level Nivelul curent pe care il are eroul
     * Functia va seta valorile damage-ului dat de cele doua abilitati ale eroului de tip Knight.
     */
    @Override
    void setDamageAbilities(final int level) {
        this.damageFirstAbility = Constants.INITIALDAMAGEFAK + Constants.DAMAGEPERLEVELFAK * level;
        this.damageSecondAbility = Constants.INITIALDAMAGESAK
                + Constants.DAMAGEPERLEVELSAK * level;
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
        if (maxLevelHp / Constants.THREE < this.getHp()) {
            if (this.getHp() < maxLevelHp / Constants.TWO) {
                this.setHp((int) (this.getHp() * Constants.HPMODIFIER08));
                this.strategyModifier += Constants.STRATEGYMODIFIER05;
            }
        }
        if (this.getHp() < maxLevelHp / Constants.THREE) {
            this.setHp((int) (this.getHp() * Constants.HPMODIFIER125));
            this.strategyModifier -= Constants.STRATEGYMODIFIER02;
        }
    }
}
