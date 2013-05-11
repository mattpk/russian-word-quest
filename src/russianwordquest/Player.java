package russianwordquest;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jonathan2
 */
public class Player extends AbstractEntity {

    private String imageURL = "resources/images/player.png";
    private Image image;
    private int x;
    private int y;
    private boolean up, down, left, right;

    public Player() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(imageURL));
        image = icon.getImage();
    }

    @Override
    public void move() {
        if (left) {
            x--;
        }
        if (right) {
            x++;
        }
        if (up) {
            y--;
        }
        if (down) {
            y++;
        }
    }

    @Override
    public void setLoc(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void destroy() {
    }

    @Override
    public void create() {
    }

    public Image getImage() {
        return image;
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @param up the up to set
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * @param down the down to set
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }
}