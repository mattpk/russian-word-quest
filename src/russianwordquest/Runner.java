package russianwordquest;

/**
 *
 * @author jonathan2
 */
public class Runner implements Runnable {

    private int fps;
    private long lastFpsTime;
    long previousLoopTime = System.nanoTime();
    final int TARGET_FPS = 60;
    final long IDEAL_TIME = 1000000000 / TARGET_FPS;
    Paint image = new Paint();
    private boolean runFlag = false;
    public static double delta;
    
    Map overworld;

    public Runner(boolean runFlag) {
        this.runFlag = runFlag;
    }

    @Override
    public void run() {
        if (getGameState() == GameState.MAIN_MENU) {
            MainMenu menu = new MainMenu(Paint.DISPLAY_WIDTH, Paint.DISPLAY_HEIGHT);
            
            Paint.frame.getContentPane().removeAll();
            Paint.frame.add(menu);
            Paint.frame.getContentPane().repaint();
            Paint.frame.validate();
            overworld = MapUtilities.readMap("russianwordquest/resources/maps/overworld.txt");
            System.out.println("loaded map");
            System.out.println(overworld.getCols());
            
            setGameState(GameState.GAME);
        }

        // start FPS section
        if (getGameState() == GameState.GAME) {
            Paint.frame.getContentPane().removeAll();
            image = new Paint();
            while (runFlag) {
                long now = System.nanoTime();
                long updateLength = now - previousLoopTime;
                previousLoopTime = now;
                delta = updateLength / ((double) IDEAL_TIME);

                lastFpsTime += updateLength;
                fps++;

                if (lastFpsTime >= 1000000000) {
                    System.out.println("(FPS: " + fps + ")");
                    lastFpsTime = 0;
                    fps = 0;
                }

                updateEngine(delta);

                RussianWordQuest.player.update(delta);

                long sleep = (previousLoopTime - System.nanoTime() + IDEAL_TIME) / 1000000;

                if (sleep > 0) {
                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException e) {
                    }
                }
            }
        }

    }

    public void stop() {
        runFlag = false;
    }

    public GameState getGameState() {
        return RussianWordQuest.getState();
    }

    public void setGameState(GameState state) {
        RussianWordQuest.setState(state);
    }

    private void updateEngine(double delta) {
        //time related things must be multiplied by delta
        //non time related ignore delta 
      //draws tiles
      Tile[][] viewTiles = new Tile[20][15];
      
      for (int x = 0; x < 20; x++)
      {
        for (int y = 0; y < 15; y++)
        {
          viewTiles[x][y] = overworld.getTile(x+((RussianWordQuest.player.getX()-320)/32),y+((RussianWordQuest.player.getY()-240)/32));
          viewTiles[x][y].setX(x);
          viewTiles[x][y].setY(y);
        }
      }
      System.out.println(viewTiles[0][0].toString());
      Map view = new Map(15,20,viewTiles);
      
      for (int x = 0; x < view.getRows(); x++)
      {
        for (int y = 0; y < view.getCols(); y++)
        {
          image.render(view.getTile(y,x));
        }
      }
      
      // draws entities
        for (int i = 0; i < Instances.getEntities().size(); i++) {
            AbstractEntity entity = (AbstractEntity) Instances.getEntities().get(i);
            image.render(entity);
        }
        
        
    }
}