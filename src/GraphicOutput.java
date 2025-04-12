import constants.Drawable;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;

public class GraphicOutput extends Frame{


    public GraphicOutput(){
        super("Java AWT Examples");
        prepareGUI();
    }

    private void prepareGUI(){
        setSize(400,400);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g){
        /*Rectangle2D shape = new Rectangle2D.Float();
        shape.setFrame(100,150,200,100);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.blue);
        g2.fill(shape);
        g2.draw(shape);*/
        //TODO Loop over all objects of an interface
    }
}

