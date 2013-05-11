package russianwordquest;

/**
 *
 * @author jonathan2
 */
interface Entity {

    public int getX();

    public int getY();

    public void setX(int x);

    public void setY(int y);

    public void setLoc(int x, int y);

    public void destroy();

    public void create();
}
