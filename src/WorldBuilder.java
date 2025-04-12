import constants.Drawable;
import constants.floorTiles;

import java.util.Random;

public class WorldBuilder implements Drawable {
    private int seed;
    floorTiles[][] grid = new floorTiles[100][100];

    WorldBuilder(int seed){
        this.seed = seed;
        Main();
    }

    WorldBuilder(){
        Random rand = new Random();
        this.seed = rand.nextInt(100000000,999999999);
        Main();
    }

    private void Main(){
        for(int i = 0;i<100;i++){
            for(int j = 0; j<100;j++){
                grid[i][j] = floorTiles.BLANK;
            }
        }
    }

    @Override
    public void draw() {

    }
}
