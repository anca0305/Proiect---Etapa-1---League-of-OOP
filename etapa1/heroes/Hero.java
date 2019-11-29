package heroes;

public abstract class Hero {
    private final Character mainGround;
    private Character ground;
    private int x;
    private int y;
    private int hp;
    private final int initialhp;
    private final int hpperlevel;
    private final float bonusDamage;
    private int xp = 0;
    private int level = 0;
    private int damage;

    public Hero(Character mainGround, final int x, final int y,
                final int initialhp, final int hpperlevel, final float bonusDamage) {
        this.mainGround = mainGround;
        this.x = x;
        this.y = y;
        this.initialhp = initialhp;
        this.hpperlevel = hpperlevel;
        this.bonusDamage = bonusDamage;
    }

    public void checkLevel(int newxp) {
        int newLevel;
        newLevel = (newxp-250)/50;
        if (this.level!=newLevel) {
            this.hp = this.initialhp;
            this.level = newLevel;
        }
    }

    public void setXp(int levelLoser) {
        int max;
        int aux;
        aux = 200 - (this.level - levelLoser) * 40;
        if (aux > 0) {
            this.xp += aux;
        }
    }

    public void resetPosition(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public float getBonusDamage() {
        return bonusDamage;
    }

    public boolean checkPosition(Hero h) {
        if (this.x == h.getX()) {
            if (this.y == h.getY()) {
                return true;
            }
        }
        return false;
    }

    public abstract void calculateDamage(final int level, Character ground, Hero h);

    public abstract void hitHero(Hero h);

    public void receiveHit(final int decreasehp) {
        this.hp -= decreasehp;
    }

}
