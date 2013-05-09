package russianwordquest;
import java.util.*;
import java.io.*;
public class MapUtilities
{
  
  // returns a Map by reading in fileName
  // filename 1st line is super encryption
  // 2nd line is # of rows
  // 3rd line is # of cols
  // next few lines are grid
  // line after the grid is # of exits
  // next few lines are the x and then the y coordinate of the exit.
  // example:
  
  /* super encryption
   * 2
   * 2
   * GG
   * GG
   * 1
   * 0
   * 0
   */
  
  // so the top right corner is where the exit is..
  public static Map readMap (String fileName)
  {
    Tile [] [] grid;
    ArrayList <Tile> exits = new ArrayList <Tile> ();
    
    try
    {
      BufferedReader in = new BufferedReader (new FileReader(fileName));
      String take = in.readLine();
      if (take != "super encryption") return null;
      int rows = Integer.parseInt(in.readLine());
      int cols = Integer.parseInt(in.readLine());
      
      grid = new Tile [cols] [rows];
      
      for (int x = 0; x < rows; x++)
      {
        take = in.readLine();
        for (int y =0; y < cols; y++)
        {
          if (take.charAt(y) == 'G')
          {
            grid[y][x] = new Tile(y,x,false);
          }
          else
            grid[y][x] = new Tile(y,x,true);
        }
      }
      
      take = in.readLine();
      
      for (int x = 0; x < Integer.parseInt(take); x++)
      {
        exits.add(grid[Integer.parseInt(in.readLine())][Integer.parseInt(in.readLine())]);
      }
      
      Map map = new Map (rows,cols,grid,exits);
      return map;
    }
    catch (IOException e)
    {
    }
    catch (NumberFormatException e)
    {
    }
    return null;
  }
}