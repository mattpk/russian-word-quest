package russianwordquest;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.BitSet;
import java.util.Random;
import java.util.Vector;
import javax.media.j3d.Background;

/**
 *
 * @author jonathan2
 */
public class SpriteVector extends Vector {

    private Background background;

    public SpriteVector(Background background) {
        super(50, 10);
        this.background = background;
    }

    /**
     * @return the background
     */
    public Background getBackground() {
        return background;
    }

    /**
     * @param background the background to set
     */
    public void setBackground(Background background) {
        this.background = background;
    }

    Sprite isPointInside(Point pt) {
        // Iterate backward through the sprites, testing each 
        for (int i = (size() - 1); i >= 0; i--) {
            Sprite s = (Sprite) elementAt(i);
            if (s.isPointInside(pt)) {
                return s;
            }
        }
        return null;
    }

    /*public void update() {
        // Iterate through sprites, updating each
        Sprite s, sHit;
        Rectangle lastPos;
        for (int i = 0; i < size();) {
            // Update the sprite
            s = (Sprite) elementAt(i);
            lastPos = new Rectangle(s.getPosition().x, s.getPosition().y,
                    s.getPosition().width, s.getPosition().height);
            BitSet action = s.update();

            // Check for the SA_ADDSPRITE action
            if (action.get(Sprite.SA_ADDSPRITE)) {
                // Add the sprite
                Sprite sToAdd = s.addSprite(action);
                if (sToAdd != null) {
                    int iAdd = add(sToAdd);
                    if (iAdd >= 0 && iAdd <= i) {
                        i++;
                    }
                }
            }

            // Check for the SA_RESTOREPOS action 
            if (action.get(Sprite.SA_RESTOREPOS)) {
                s.setPosition(lastPos);
            }

            // Check for the SA_KILL action
            if (action.get(Sprite.SA_KILL)) {
                removeElementAt(i);
                continue;
            }

            // Test for collision
            int iHit = testCollision(s);
            if (iHit >= 0) {
                if (collision(i, iHit)) {
                    s.setPosition(lastPos);
                }
            }
            i++;
        }
    }*/

    protected boolean collision(int i, int iHit) {
        // Swap velocities (bounce)
        Sprite s = (Sprite) elementAt(i);
        Sprite sHit = (Sprite) elementAt(iHit);
        Point swap = s.getVelocity();
        s.setVelocity(sHit.getVelocity());
        sHit.setVelocity(swap);
        return true;
    }

    protected int testCollision(Sprite test) {
        // Check for collision with other sprites
        Sprite s;
        for (int i = 0; i < size(); i++) {
            s = (Sprite) elementAt(i);
            if (s == test) // don't check itself
            {
                continue;
            }
            if (test.testCollision(s)) {
                return i;
            }
        }
        return -1;
    }
}