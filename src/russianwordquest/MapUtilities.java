package russianwordquest;

import java.io.*;
import java.util.*;

public class MapUtilities {

    // returns a Map by reading in fileName
    // filename 1st line is super encryption
    // 3nd line is # of cols
    // 2rd line is # of rows
    // next few lines are grid
    // example:
  /* super encryption
     * 5
     * 4
     * GGGGG
     * GGGGG
     * GGGGG
     * GGGGG
     */
    public static Map readMap(String fileName) {
        Tile[][] grid;
        ArrayList<Tile> exits = new ArrayList<Tile>();

        try {

            File read = new File(fileName);
            BufferedReader in = new BufferedReader(new FileReader(read.getAbsolutePath()));
            String take = in.readLine();
            if (!"super encryption".equals(take)) {
                return null;
            }
            int rows = Integer.parseInt(in.readLine());
            int cols = Integer.parseInt(in.readLine());

            grid = new Tile[cols][rows];

            for (int x = 0; x < rows; x++) {
                take = in.readLine();
                for (int y = 0; y < cols; y++) {
                    if (take.charAt(y) == 'G') {
                        grid[y][x] = new Tile(y, x, false, TileType.GRASS);
                    } else if (take.charAt(y) == 'T') {
                        grid[y][x] = new Tile(y, x, true, TileType.TREE);
                    } else if (take.charAt(y) == 'D') {
                        grid[y][x] = new Tile(y, x, false, TileType.DOOR);
                    } else if (take.charAt(y) == 'd') {
                        grid[y][x] = new Tile(y, x, true, TileType.ROOFLEFT);
                    } else if (take.charAt(y) == 'b') {
                        grid[y][x] = new Tile(y, x, true, TileType.ROOFRIGHT);
                    } else if (take.charAt(y) == 'R') {
                        grid[y][x] = new Tile(y, x, true, TileType.ROCK);
                    } else if (take.charAt(y) == '1') {
                        grid[y][x] = new Tile(y, x, true, TileType.NPC1);
                    } else if (take.charAt(y) == '2') {
                        grid[y][x] = new Tile(y, x, true, TileType.NPC2);
                    } else if (take.charAt(y) == '3') {
                        grid[y][x] = new Tile(y, x, true, TileType.NPC3);
                    } else {
                        grid[y][x] = new Tile(y, x, true, TileType.GRASS);
                    }
                }
            }

            take = in.readLine();

            Map map = new Map(rows, cols, grid);
            return map;
        } catch (IOException e) {
            System.out.println(e.toString());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException");
        }
        return null;
    }
}