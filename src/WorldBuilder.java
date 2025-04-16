import constants.Drawable;
import constants.floorTiles;
import noise.*;

import java.awt.*;
import java.util.Random;

public class WorldBuilder implements Drawable {
    static final int RENDER_DISTANCE = 3;
    static final int TILE_SIZE = 2;
    static final int CHUNK_SIZE = 16;

    private final long seed;

    Chunk[][] grid = new Chunk[20][20];
    private Random random;
    private FastNoiseLite noise;

    WorldBuilder(int seed) {
        Main.drawables.add(this);
        this.seed = seed;
        Main();
    }

    WorldBuilder() {
        Main.drawables.add(this);
        Random seedGen = new Random();
        this.seed = seedGen.nextInt(1000, 9999);
        Main();
    }

    private void Main() {
        random = new Random(seed);
        noise = new FastNoiseLite((int) seed);
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = generateChunk(i, j);
            }
        }
    }

    private Chunk generateChunk(int chunkX, int chunkY) {
        Chunk chunk = new Chunk(chunkX, chunkY);
        for (int x = 0; x < CHUNK_SIZE; x++) {
            for (int y = 0; y < CHUNK_SIZE; y++) {
                int worldX = chunkX*CHUNK_SIZE+x;
                int worldY = chunkY*CHUNK_SIZE+y;
                float noiseVal = noise.GetNoise(worldX,worldY);
                if (noiseVal < -0.6) {
                    chunk.grid[x][y] = floorTiles.WATER;
                } else if (noiseVal < 0.4) {
                    chunk.grid[x][y] = floorTiles.GRASS;
                } else {
                    chunk.grid[x][y] = floorTiles.DIRT;
                }
            }
        }
        return chunk;
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

    public class Chunk {

        private final floorTiles[][] grid;

        private int chunkX, chunkY;

        Chunk(int chunkX, int chunkY) {
            this.chunkX = chunkX;
            this.chunkY = chunkY;
            grid = new floorTiles[CHUNK_SIZE][CHUNK_SIZE];

        }

        public void drawChunk(Graphics g) {
            Graphics2D g2 = (Graphics2D) g;
            //System.out.println(getChunkX() + " " + getChunkY());//LOG
//            if (isInChunk()) {
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
  //          }
        }

        private boolean isInChunk() {
            return Main.player1.getChunkCoordinates().distance(new Point(chunkX, chunkY)) < RENDER_DISTANCE;
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
