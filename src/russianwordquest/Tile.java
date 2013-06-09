package russianwordquest;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Tile {

    private int x, y;
    private boolean collision;
    private TileType type;
    public static int size = 32;
    private Image image;
    String imageURL;

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

        setTileBG();
    }

    public final void setTileBG() {
        if (getType() == TileType.ROCK) {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("resources/images/rock.PNG"));
            image = icon.getImage();
        }
        if (getType() == TileType.GRASS) {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("resources/images/grass.PNG"));
            image = icon.getImage();
        }
        if (getType() == TileType.NPC1) {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("resources/images/player.png"));
            image = icon.getImage();
        }
        if (getType() == TileType.NPC2) {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("resources/images/player.png"));
            image = icon.getImage();
        }
        if (getType() == TileType.NPC3) {
            ImageIcon icon = new ImageIcon(this.getClass().getResource("resources/images/player.png"));
            image = icon.getImage();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public boolean getCollision() {
        return collision;
    }

    public boolean equals(Tile loc) {
        return (loc.getX() == x && loc.getY() == y);
    }

    public void debug() {
        String imageURL = "resources/images/player.PNG";
        ImageIcon icon = new ImageIcon(this.getClass().getResource(imageURL));
        image = icon.getImage();
    }

    public String toString() {
        if (getType() == TileType.ROOF) {
            return "R";
        }
        return "G";
    }

    /**
     * @return the type
     */
    public TileType getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(TileType type) {
        this.type = type;
    }
}