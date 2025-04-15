import constants.Drawable;
import constants.floorTiles;

import java.awt.*;
import java.util.Random;

public class WorldBuilder implements Drawable {
    private static final int RENDER_DISTANCE = 4;
    private static final int TILE_SIZE = 5;
    private static final int CHUNK_SIZE = 16;
    private final int seed;
    Chunk[][] grid = new Chunk[RENDER_DISTANCE * 2 + 1][RENDER_DISTANCE * 2 + 1];

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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = new Chunk(i, j);
                grid[i][j].generateChunk();
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Chunk[] chunks : grid) {
            for (int j = 0; j < grid.length; j++) {
                chunks[j].drawChunk(g2);
            }
        }
    }

    private class Chunk {

        private final floorTiles[][] grid;

        private int chunkX;
        private int chunkY;

        Chunk(int chunkX, int chunkY) {
            this.chunkX = chunkX;
            this.chunkY = chunkY;
            grid = new floorTiles[CHUNK_SIZE][CHUNK_SIZE];

        }

        public void drawChunk(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //System.out.println(getChunkX() + " " + getChunkY());//LOG
            for (int i = 0; i < CHUNK_SIZE; i++) {
                for (int j = 0; j < CHUNK_SIZE; j++) {
                    //System.out.println("i="+i+", j="+j+" "+((chunkX * CHUNK_SIZE*TILE_SIZE) + (i * TILE_SIZE)) + ", " + ((chunkY * CHUNK_SIZE*TILE_SIZE) + (j * TILE_SIZE)));//LOG
                    g2.setColor(new Color(grid[i][j].color[0], grid[i][j].color[1], grid[i][j].color[2]));
                    g2.fillRect((chunkX * CHUNK_SIZE * TILE_SIZE) + (i * TILE_SIZE),
                            (chunkY * CHUNK_SIZE * TILE_SIZE) + (j * TILE_SIZE),
                            TILE_SIZE,
                            TILE_SIZE);
                }
            }
        }

        public void generateChunk() {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid.length; j++) {
                    grid[i][j] = floorTiles.BLANK;
                }
            }
            grid[1][2] = floorTiles.GRASS;
        }

        public int getChunkX() {
            return chunkX;
        }

        public void setChunkX(int chunkX) {
            this.chunkX = chunkX;
        }

        public int getChunkY() {
            return chunkY;
        }

        public void setChunkY(int chunkY) {
            this.chunkY = chunkY;
        }

    }
}
