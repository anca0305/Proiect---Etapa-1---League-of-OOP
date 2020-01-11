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

public final class Pyromancer extends Hero {

    public Pyromancer(final Character mainGround, final int x, final int y,
                  final int initialhp, final int hpperlevel, final float bonusDamage,
                  final int id) {
        super(mainGround, x, y, initialhp, hpperlevel, bonusDamage, id);
        this.name = "Pyromancer";
    }

    @Override
    public void calculateRaceAmplificationFor(final Hero h) {
        h.calculateRaceAmplification(this);
    }

    @Override
    public void calculateRaceAmplification(final Knight knight) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION12 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION12 + this.angelModifier
                + this.strategyModifier;
    }

    @Override
    public void calculateRaceAmplification(final Pyromancer pyromancer) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION09 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION09 + this.angelModifier
                + this.strategyModifier;
    }

    @Override
    public void calculateRaceAmplification(final Rogue rogue) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION08 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION08 + this.angelModifier
                + this.strategyModifier;
    }

    @Override
    public void calculateRaceAmplification(final Wizard wizard) {
        this.raceAmplificationFA = Constants.RACEAMPIFICATION105 + this.angelModifier
                + this.strategyModifier;
        this.raceAmplificationSA = Constants.RACEAMPIFICATION105 + this.angelModifier
                + this.strategyModifier;
    }
    /**
     * @param ground Tipul terenului pe care va avea loc lupta
     * @param h Eroul cu care se va lupta
     * @param level Nivelul curent pe care il are eroul
     * Functia va seta killer-ul eroului atacat ca fiind eroul curent - astfel, in cazul in care
     * eroul atacat moare in urma damege-ului primit la runda curenta sau dat de o abilitate ce
     * are efect overtime, eroul curent - atacatorul - va primi xp-ul corespunzator.
     * Vom calcula damage-ul dat de fiecare abilitate si il vom aplica eroului atacat.
     * Urmeaza calcularea damage-ul pe care il va da eroul curent cu efect prelungit. Vom seta
     * pentru eroul atacat valoarea numarului de runde in care urmeaza sa fie sub efectul celei
     * de-a doua abilitati a lui Pyromancer, dar si valoarea cu care va scadea hp-ul lui.
     * Valoarea rundelor in care este imobilizat va fi din nou 0 (anularea efectului unei posibile
     * abilitati cu efect prelungit aplicate anterior).
     */
    @Override
    public void calculateDamage(final Character ground, final Hero h, final int level) {
        h.setKiller(this);
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
        h.receiveDamage(this.damage);
        h.periodicDamage = Constants.INITIALPERIODICDAMAGEP
                + Constants.PERIODICDAMAGEPERLEVELP * level;
        h.noRoundsToReceivePeriodicDamage = Constants.ROUNDSTORECEIVEPERIODICDAMAGEP;
        float toRoundPeriodicDamage = h.periodicDamage;
        toRoundPeriodicDamage *= this.calculateGroundAmplification(ground);
        toRoundPeriodicDamage *= this.raceAmplificationSA;
        h.periodicDamage = Math.round(toRoundPeriodicDamage);
        h.noRoundsCantMove = Constants.DEFAULTVALUE;
    }
    /**
     * @param level Nivelul curent pe care il are eroul
     * Functia va seta valorile damage-ului dat de cele doua abilitati ale eroului de tip
     * Pyromancer.
     */
    @Override
    void setDamageAbilities(final int level) {
        this.damageFirstAbility = Constants.INITIALDAMAGEFAP + Constants.DAMAGEPERLEVELFAP * level;
        this.damageSecondAbility = Constants.INITIALDAMAGESAP
                + Constants.DAMAGEPERLEVELSAP * level;
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
            if (this.getHp() < maxLevelHp / Constants.THREE) {
                this.setHp((int) (this.getHp() * Constants.HPMODIFIER075));
                this.strategyModifier += Constants.STRATEGYMODIFIER07;
            }
        }
        if (this.getHp() < maxLevelHp / Constants.FOUR) {
            this.setHp((int) (this.getHp() * Constants.HPMODIFIER133));
            this.strategyModifier -= Constants.STRATEGYMODIFIER03;
        }
    }
}
