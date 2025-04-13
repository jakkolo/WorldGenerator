import constants.Drawable;

import java.util.ArrayList;

public class Main {
    static ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    public static void main(String[] args) {
        WorldBuilder testWorld = new WorldBuilder();
        GraphicOutput demo = new GraphicOutput();
        demo.setVisible(true);
    }
}