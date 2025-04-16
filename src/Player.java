import constants.Drawable;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Objects;

public class Player implements Drawable {

    //FIXME
    // -reduce movement speed when going diagonally
    private String name;
    private int xPos;
    private int yPos;
    private int size = 10;
    private final int delta;

    private final WorldBuilder world;

    //Ellipse2D character;

    Player(String name, int xPos, int yPos, WorldBuilder World) {
        this.name = name;
        this.xPos = xPos;
        this.yPos = yPos;
        Main.drawables.add(this);
        delta = 2;
        this.world = World;
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
        if (Objects.equals(action, "moveLeft")&& Main.demo.panel.contains(xPos-delta,yPos)) {
            xPos -= delta;
        } else if (Objects.equals(action, "moveRight")&& Main.demo.panel.contains(xPos+delta,yPos)) {
            xPos += delta;
        } else if (Objects.equals(action, "moveUp")&& Main.demo.panel.contains(xPos,yPos-delta)) {
            yPos -= delta;
        } else if (Objects.equals(action, "moveDown")&& Main.demo.panel.contains(xPos,yPos+delta)) {
            yPos += delta;
        }

    }

    public Point getChunkCoordinates() {
        for (WorldBuilder.Chunk[] chunks : world.grid) {
            for (WorldBuilder.Chunk chunk : chunks) {
                Rectangle2D testing;
                testing = new Rectangle2D.Float(chunk.getChunkX() * WorldBuilder.CHUNK_SIZE * WorldBuilder.TILE_SIZE,
                        chunk.getChunkY() * WorldBuilder.CHUNK_SIZE * WorldBuilder.TILE_SIZE,
                        WorldBuilder.CHUNK_SIZE * WorldBuilder.TILE_SIZE,
                        WorldBuilder.CHUNK_SIZE * WorldBuilder.TILE_SIZE);
                if (testing.contains(new Point2D.Float(xPos, yPos))) {
                    return new Point(chunk.getChunkX(), chunk.getChunkY());
                }
            }
        }
        return null;
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
