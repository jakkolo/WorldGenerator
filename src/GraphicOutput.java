import constants.Drawable;

import javax.swing.*;
import java.awt.*;

public class GraphicOutput {
    JFrame mainFrame;
    MainPanel panel;
    Player player;
    int xWidth;
    int yWidth;

    public GraphicOutput(Player player, int screenWidthX, int screenWidthY) {
        this.player = player;
        this.xWidth = screenWidthX;
        this.yWidth = screenWidthY;
        player.setxPos(screenWidthX / 2);
        player.setyPos(screenWidthY / 2);
    }

    public void createAndShowGUI() {
        mainFrame = new JFrame("My World");
        panel = new MainPanel();

        mainFrame.setSize(800, 850);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setResizable(false);
        mainFrame.add(panel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    public class MainPanel extends JPanel {


        public MainPanel() {

        }

        public Dimension getPreferredSize() {
            return new Dimension(xWidth, yWidth);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Drawable obj : Main.drawables) {
                //System.out.println(obj);//LOG
                obj.draw(g);
            }
            //TODO
            // - only for showing chunk borders
            for (int x = 0; x < xWidth; x += 32) {
                g.setColor(Color.blue);
                g.drawLine(x, 0, x, yWidth);
            }
            for (int y = 0; y < yWidth; y += 32) {
                g.setColor(Color.blue);
                g.drawLine(0, y, xWidth, y);
            }
        }
    }
}

