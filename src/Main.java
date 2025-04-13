import constants.Drawable;

import java.util.ArrayList;

public class Main {
    static ArrayList<Drawable> drawables = new ArrayList<>();

    public static void main(String[] args) {
        WorldBuilder testWorld = new WorldBuilder();
        Player player1 = new Player("player1", 100,200);
        GraphicOutput demo = new GraphicOutput();
    }
}