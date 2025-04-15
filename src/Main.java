import constants.Drawable;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Drawable> drawables = new ArrayList<>();
    //static ArrayList<RespondsToKeyboard> respondingToKeyboard = new ArrayList<>();
    static Player player1;

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            WorldBuilder myWorld = new WorldBuilder();
            player1 = new Player("player1", 250, 250, myWorld);
            GraphicOutput demo = new GraphicOutput(player1, 640, 640);

            demo.createAndShowGUI();
            InputController controlPlayer1 = new InputController(demo.panel, player1, 24);
        });
    }
}