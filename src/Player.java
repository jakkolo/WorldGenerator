import constants.Drawable;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Player implements Drawable{

    private String name;
    private int xPos;
    private int yPos;
    private int size = 10;
    private final int delta = 1;
    Ellipse2D character;

    Player(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        Main.drawables.add(this);
    }

    @Override
    public void draw(Graphics g) {
        System.out.println(xPos);
        System.out.println("Repainted");
        Graphics2D g2 = (Graphics2D) g;
        character = new Ellipse2D.Float(xPos- (float) size /2, yPos- (float) size / 2, size, size);
        g2.setColor(Color.RED);
        g2.fill(character);
        g2.draw(character);
    }

    public void up(){
        yPos-= delta;
    }

    public void right(){
        xPos+= delta;
    }

    public void down(){
        yPos+= delta;
    }

    public void left(){
        xPos-= delta;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
