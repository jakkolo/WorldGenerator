package constants;

public enum floorTiles{
    DIRT(97,74,11),
    GRASS(28, 120, 5),
    WATER(3, 6, 163),
    BLANK();

    public final int[] color = new int[3];

    floorTiles() {
        this(0, 0, 0);
    }

    floorTiles(int red, int green, int blue){
        color[0]=red;
        color[1]=green;
        color[2]=blue;
    }
}
