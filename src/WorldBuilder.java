import constants.Drawable;
import constants.floorTiles;

import java.awt.*;
import java.util.Random;

public class WorldBuilder implements Drawable {
    floorTiles[][] grid = new floorTiles[100][100];
    private final int seed;
    static final int TILE_SIZE = 10;

    WorldBuilder(int seed) {
        Main.drawables.add(this);
        this.seed = seed;
        Main();
    }

    WorldBuilder() {
        Main.drawables.add(this);
        Random rand = new Random();
        this.seed = rand.nextInt(100000000, 999999999);
        Main();
    }

    private void Main() {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                grid[i][j] = floorTiles.BLANK;
            }
        }
        grid[1][2] = floorTiles.DIRT;
    }

    @Override
    public void draw(Graphics g) {
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(new Color(grid[i][j].color[0], grid[i][j].color[1], grid[i][j].color[2]));
                g2.fillRect(i * TILE_SIZE, j * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
        }
    }
}
