import constants.Drawable;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Drawable> drawables = new ArrayList<>();
    //static ArrayList<RespondsToKeyboard> respondingToKeyboard = new ArrayList<>();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Player player1 = new Player("player1", 100, 200);
                GraphicOutput demo = new GraphicOutput(player1);
                WorldBuilder testWorld = new WorldBuilder();
                demo.createAndShowGUI();
            }
        });
    }
}