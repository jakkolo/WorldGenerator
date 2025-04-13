import constants.Drawable;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GraphicOutput extends JFrame {


    public GraphicOutput(){
        super("My World");
        prepareGUI();
    }

    private void prepareGUI(){
        super.setSize(500,500);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainPanel panel = new MainPanel();
        super.add(panel);
    }

    //TODO Loop over all objects of an interface
    private class MainPanel extends JPanel{

        MainPanel(){

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for(Drawable obj: Main.drawables){
                obj.draw(g);
            }
        }
    }
}

