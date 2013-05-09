package russianwordquest;

/**
 *
 * @author Matthew Chung
 */
import java.util.*;

public class Map {

    private int rows;
    private int cols;
    private Tile[][] grid;
    private ArrayList<Tile> exits = new ArrayList<Tile>();

    // default size 640 by 480
    public Map() {
        rows = 15;
        cols = 20;
    }

    public Map(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public Map(int rows, int cols, Tile[][] grid, ArrayList<Tile> exits) {
        this.rows = rows;
        this.cols = cols;

        this.grid = new Tile[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                this.grid[x][y] = grid[x][y];
            }
        }

        this.exits = exits;
    }

    public Map(Tile[][] grid, ArrayList<Tile> exits) {
        this.grid = new Tile[grid.length][grid[0].length];
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[0].length; y++) {
                this.grid[x][y] = grid[x][y];
            }
        }
        this.exits = exits;
    }

    public ArrayList<Tile> getExits() {
        return exits;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Tile getTile(int x, int y) {
        return grid[x][y];
    }
}