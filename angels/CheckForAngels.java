package angels;

import heroes.Hero;

import java.util.ArrayList;

public class CheckForAngels {
    private final Character[][] map;
    private final ArrayList<Angel> angels;
    private final Integer[][] angelsPosition;

    public CheckForAngels(final Character[][] map, final ArrayList<Angel> angels,
                          final Integer[][] angelsPosition) {
        this.map = map;
        this.angels = angels;
        this.angelsPosition = angelsPosition;
    }

    public void check(final Hero h) {
        for (Angel a : angels) {
            if (a.getRound() == h.getCurrentRound()) {
                if (a.checkPosition(h) == 1 && a.getType() <= 2) {
                    h.interactWith(a);
                    h.setChecked(1);
                }
            }
        }
    }
}
