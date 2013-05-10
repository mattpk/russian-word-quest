package russianwordquest;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.BitSet;

/**
 *
 * @author jonathan2
 */
public class Sprite {

    public static final int SA_KILL = 0,
            SA_RESTOREPOS = 1,
            SA_ADDSPRITE = 2;
    public static final int BA_STOP = 0,
            BA_WRAP = 1,
            BA_BOUncE = 2,
            BA_DIE = 3;
    protected Component component;
    protected Image[] image;
    protected int frame,
            frameInc,
            frameDelay,
            frameTrigger;
    private Rectangle position;
    private Rectangle collision;
    protected int zOrder;
    protected Point velocity;
    protected Rectangle bounds;
    protected int boundsAction;
    protected boolean hidden = false;

    public Sprite(Component comp, Image img, Point pos, Point vel, int z, int ba) {
        component = comp;
        image = new Image[1];
        image[0] = img;
        setPosition(new Rectangle(pos.x, pos.y, img.getWidth(comp),
                img.getHeight(comp)));
        setVelocity(vel);
        frame = 0;
        frameInc = 0;
        frameDelay = frameTrigger = 0;
        zOrder = z;
        bounds = new Rectangle(0, 0, comp.size().width, comp.size().height);
        boundsAction = ba;
    }

    public Sprite(Component comp, Image[] img, int f, int fi, int fd, Point pos, Point vel, int z, int ba) {

        component = comp;
        image = img;
        setPosition(new Rectangle(pos.x, pos.y, img[f].getWidth(comp),
                img[f].getHeight(comp)));
        setVelocity(vel);
        frame = f;
        frameInc = fi;
        frameDelay = frameTrigger = fd;
        zOrder = z;
        bounds = new Rectangle(0, 0, comp.size().width, comp.size().height);
        boundsAction = ba;
    }

    protected void incFrame() {
        if ((frameDelay > 0) && (--frameTrigger <= 0)) {
            //reset frame trigger 
            frameTrigger = frameDelay;


            //increment 
            frame += frameInc;
            if (frame >= image.length) {
                frame = 0;
            } else if (frame < 0) {
                frame = 0;
            }
        }
    }

    public void setPosition(Rectangle position) {
        this.position = position;
        setCollision();
    }

    public void setPosition(Point pos) {
        getPosition().move(pos.x, pos.y);
        setCollision();
    }

    /**
     * @return the position
     */
    public Rectangle getPosition() {
        return position;
    }

    public void setVelocity(Point velocity) {
        this.velocity = velocity;
    }

    public Point getVelocity() {
        return velocity;
    }

    public void setCollision() {
        collision = getPosition();
    }

    public boolean isPointInside(Point pt) {
        return getPosition().inside(pt.x, pt.y);
    }

    public BitSet update() {
        BitSet action = new BitSet();

        incFrame();

        Point pos = new Point(getPosition().x, getPosition().y);
        pos.translate(velocity.x, velocity.y);

        // Stop (default)

        if (pos.x < bounds.x
                || pos.x > (bounds.x + bounds.width - getPosition().width)) {
            pos.x = Math.max(bounds.x, Math.min(pos.x,
                    bounds.x + bounds.width - getPosition().width));
            setVelocity(new Point(0, 0));
        }
        if (pos.y < bounds.y
                || pos.y > (bounds.y + bounds.height - getPosition().height)) {
            pos.y = Math.max(bounds.y, Math.min(pos.y,
                    bounds.y + bounds.height - getPosition().height));
            setVelocity(new Point(0, 0));
        }

        setPosition(pos);

        return action;
    }

    public Sprite addSprite(BitSet action) {
        return null;
    }

    public void draw(Graphics g) {
        if (!hidden) {
            g.drawImage(image[frame], getPosition().x, getPosition().y, component);
        }
    }

    public boolean testCollision(Sprite testSprite) {
        if (testSprite != this) {
            return getCollision().intersects(testSprite.getCollision());
        } else {
            return false;
        }
    }

    /**
     * @return the collision
     */
    public Rectangle getCollision() {
        return collision;
    }
}