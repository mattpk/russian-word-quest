
package russianwordquest;

public class Tile
{
  private int x, y;
  
  public Tile()
  {
    x = 0;
    y = 0;
  }
  public Tile(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  public int getX()
  {
    return x;
  }
  public int getY()
  {
    return y;
  }
  
  public boolean equals(Tile loc)
  {
    return (loc.getX() == x && loc.getY() == y);
  }
  
}