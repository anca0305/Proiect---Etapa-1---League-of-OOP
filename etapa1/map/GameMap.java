package map;

public class GameMap {
    private static GameMap instance = null;

    private final Character[][] mapByPosition;

    private GameMap(Character[][] map, int rows, int columns) {
        mapByPosition = new Character[0][];

        createMap(map, rows, columns);
    }

    public static GameMap getInstance(Character[][] map, int rows, int columns) {
        if (instance == null) {
            instance = new GameMap(map, rows, columns);
        }

        return instance;
    }

    private void createMap(Character[][] map, int rows, int columns) {
        int x, y;
        for (x = 0; x < rows; x++) {
            for (y = 0; y < columns; y++) {
                mapByPosition[x][y] = map[x][y];
            }
        }
    }

    public Character getMapByPosition(final int x, final int y) {
        return mapByPosition[x][y];
    }

    public Character[][] getAllMap() {
        return mapByPosition;
    }
}
