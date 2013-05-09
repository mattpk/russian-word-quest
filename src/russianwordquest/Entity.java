package russianwordquest;

/**
 *
 * @author jonathan2
 */
interface Entity {

    public float getX();

    public float getY();

    public void setX(float x);

    public void setY(float y);

    public void setLoc(float x, float y);

    public void setUp();

    public void destroy();

    public void create();
}
