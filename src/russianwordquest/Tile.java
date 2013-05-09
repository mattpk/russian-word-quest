
package russianwordquest;

public class Tile
{
  private int x, y;
  private boolean collision;
  
  public Tile()
  {
    x = 0;
    y = 0;
    collision = false;
  }
  public Tile(int x, int y)
  {
    this.x = x;
    this.y = y;
    collision = false;
  }
    public Tile(int x, int y, boolean collision)
  {
    this.x = x;
    this.y = y;
    this.collision = collision;
  }
  
  public int getX()
  {
    return x;
  }
  public int getY()
  {
    return y;
  }
  public boolean getCollision()
  {
    return collision;
  }
  
  public boolean equals(Tile loc)
  {
    return (loc.getX() == x && loc.getY() == y);
  }
  
}