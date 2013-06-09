package russianwordquest;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jonathan2
 */
public class Player extends AbstractEntity {

    private String imageURL = "resources/images/sprites/wizard_down.png";
    private Image image;
    private int x;
    private int y;
    private boolean up, down, left, right;
    private boolean talked1, talked2, talked3;
    int width;
    int height;

    public Player() {
        ImageIcon icon = new ImageIcon(this.getClass().getResource(getImageURL()));
        image = icon.getImage();
        width = 32;
        height = 32;
    }

    @Override
    public void move(double delta) {

        try {
            Thread.sleep(50);
        } catch (Exception e) {
        };

        int nextTileX = x / 32;
        int nextTileY = y / 32;

        if (left) {
            setImageURL("resources/images/sprites/wizard_left.png");

            nextTileX--;
        }
        if (right) {
            setImageURL("resources/images/sprites/wizard_right.png");

            nextTileX++;
        }
        if (up) {
            setImageURL("resources/images/sprites/wizard_up.png");

            nextTileY--;
        }
        if (down) {
            setImageURL("resources/images/sprites/wizard_down.png");

            nextTileY++;
        }

        if (Runner.overworld.getTile(nextTileX, nextTileY).getType() == TileType.NPC1 && !talked1) {
            System.out.println("ready to talk!");
            Runner.stop();

            NPCDialog npcDialog = new NPCDialog(Paint.frame, false, 1, "вода", "Water");
            npcDialog.setVisible(true);
            talked1 = true;
        }

        if (Runner.overworld.getTile(nextTileX, nextTileY).getType() == TileType.NPC2 && !talked2) {
            
            talked2 = true;
        }

        if (Runner.overworld.getTile(nextTileX, nextTileY).getType() == TileType.NPC3 && !talked3) {
            
            talked3 = true;
        }

        if (Runner.overworld.getTile(nextTileX, nextTileY).getCollision()) {
            return;
        }

        if (left && (this.getX() > 320)) {
            x -= 32;
        }
        if (right && (this.getX() < (Runner.overworld.getCols() * 32) - 320)) {
            x += 32;
        }
        if (up && (this.getY() > 256)) {
            y -= 32;
        }
        if (down && (this.getY() < (Runner.overworld.getRows() * 32) - 256)) {
            y += 32;
        }
        ImageIcon icon = new ImageIcon(this.getClass().getResource(getImageURL()));
        image = icon.getImage();
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