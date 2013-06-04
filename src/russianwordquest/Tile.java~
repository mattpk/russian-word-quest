package russianwordquest;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Tile {

    private int x, y;
    private boolean collision;
    private TileType type;
    public static int size = 32;

    public Tile() {
        x = 0;
        y = 0;
        collision = false;
    }

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        collision = false;
    }

    public Tile(int x, int y, boolean collision) {
        this.x = x;
        this.y = y;
        this.collision = collision;
    }

    public Tile(int x, int y, boolean collision, TileType type) {
        this.x = x;
        this.y = y;
        this.collision = collision;
        this.type = type;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getCollision() {
        return collision;
    }

    public boolean equals(Tile loc) {
        return (loc.getX() == x && loc.getY() == y);
    }
}