import constants.Drawable;

import java.awt.*;
import java.util.Objects;

public class Player implements Drawable {

    private String name;
    private int xPos;
    private int yPos;
    private int size = 10;
    private final int delta;
    //Ellipse2D character;

    Player(String name, int xPos, int yPos) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        Main.drawables.add(this);
        delta = 1;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.fillOval((int) (xPos - (float) size / 2), (int) (yPos - (float) size / 2), size, size);
        /*character = new Ellipse2D.Float(xPos- (float) size /2, yPos- (float) size / 2, size, size);
        g2.setColor(Color.RED);
        g2.fill(character);
        g2.draw(character);*/
    }

    public void move(String action) {
        if (Objects.equals(action, "moveLeft")) {
            xPos -= delta;
        } else if (Objects.equals(action, "moveRight")) {
            xPos += delta;
        } else if (Objects.equals(action, "moveUp")) {
            yPos -= delta;
        } else if (Objects.equals(action, "moveDown")) {
            yPos += delta;
        }

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
