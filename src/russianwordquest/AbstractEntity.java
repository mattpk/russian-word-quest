package russianwordquest;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

/**
 *
 * @author jonathan2
 */
public abstract class AbstractEntity implements Entity {

    private float x;
    private float y;
    private boolean up, down, left, right;
    private String imageURL;

    public Image getImage()
    {   
        Image image = null;
        
        try{
            image = Toolkit.getDefaultToolkit().getImage(getImageURL());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return image;
    }
    
    public void update() {
        move();
    }

    public void move() {
        if (left) {
            x--;
        }
        if (right) {
            x++;
        }
        if (up) {
            y++;
        }
        if (down) {
            y--;
        }
    }
    
    public int getXSize()
    {
        return getImage().getWidth(null);
    }
    
    public int getYSize()
    {
        return getImage().getHeight(null);
    }

    /**
     * @return the x
     */
    public float getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(float y) {
        this.y = y;
    }

    /**
     * @return the up
     */
    public boolean isUp() {
        return up;
    }

    /**
     * @param up the up to set
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * @return the down
     */
    public boolean isDown() {
        return down;
    }

    /**
     * @param down the down to set
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * @return the left
     */
    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public boolean isRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(boolean right) {
        this.right = right;
    }

    /**
     * @return the imageURL
     */
    public String getImageURL() {
        return imageURL;
    }

    /**
     * @param imageURL the imageURL to set
     */
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}