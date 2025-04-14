import constants.Drawable;

import javax.swing.*;
import java.awt.*;

public class GraphicOutput {
    JFrame mainFrame;
    MainPanel panel;
    Player player;

    public GraphicOutput(Player player) {
        this.player = player;
    }

    public void createAndShowGUI() {
        mainFrame = new JFrame("My World");
        panel = new MainPanel();

        mainFrame.setSize(800, 850);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(panel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public class MainPanel extends JPanel {


        public MainPanel() {

        }

        public Dimension getPreferredSize() {
            return new Dimension(500, 500);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Drawable obj : Main.drawables) {
                System.out.println(obj);//LOG
                obj.draw(g);
            }
        }
    }
}

