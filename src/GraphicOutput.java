import constants.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class GraphicOutput {
    JFrame mainFrame;

    public GraphicOutput() {
        mainFrame = new JFrame("My World");
        prepareGUI();
    }

    private void prepareGUI() {
        mainFrame.setSize(800, 800);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel panel = new MainPanel();
        mainFrame.add(panel);
        mainFrame.setVisible(true);
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('k'),doSomething);
        panel.getActionMap().put(doSomething,doSomething);
    }

    Action doSomething = new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("Es funktioniert");
        }
    };

    private class MainPanel extends JPanel {

        MainPanel() {

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Drawable obj : Main.drawables) {
                obj.draw(g);
            }
        }
    }
}

