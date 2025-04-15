import constants.Drawable;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Drawable> drawables = new ArrayList<>();
    //static ArrayList<RespondsToKeyboard> respondingToKeyboard = new ArrayList<>();

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            WorldBuilder testWorld = new WorldBuilder();
            Player player1 = new Player("player1", 250, 250);
            GraphicOutput demo = new GraphicOutput(player1, 720, 720);

            demo.createAndShowGUI();
            InputController controlPlayer1 = new InputController(demo.panel, player1, 24);
        });
    }
}