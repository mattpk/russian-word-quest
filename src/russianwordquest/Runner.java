package russianwordquest;

import java.io.*;

/**
 *
 * @author Jonathan Galperin
 */
public class Runner implements Runnable {

    private int fps;
    private long lastFpsTime;
    long previousLoopTime = System.nanoTime();
    final int TARGET_FPS = 60;
    final long IDEAL_TIME = 1000000000 / TARGET_FPS;
    Paint image = new Paint();
    private static volatile boolean runFlag = false;
    public static double delta;
    public static Map overworld;

    public Runner(boolean runFlag) {
        this.runFlag = runFlag;
    }

    @Override
    public void run() {
        if (getGameState() == GameState.MAIN_MENU) {
            MainMenu menu = new MainMenu(Paint.DISPLAY_WIDTH, Paint.DISPLAY_HEIGHT);

            image.frame.getContentPane().removeAll();
            image.frame.add(menu);
            image.frame.getContentPane().repaint();
            image.frame.validate();
            setGameState(GameState.GAME);
        }

        // start FPS section
        if (getGameState() == GameState.GAME) {
            image.frame.getContentPane().removeAll();
            image.destroy();
            image = new Paint();
            loadWorld();
            while (runFlag) {
                if (getGameState() != GameState.PAUSED) {
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
                } else {

                }
            }
        }

    }

    public static void stop() {
        setGameState(GameState.PAUSED);
        System.out.println("Pausing game...");
    }

    public static void start() {
        setGameState(GameState.GAME);
    }

    public GameState getGameState() {
        return RussianWordQuest.getState();
    }

    public static void setGameState(GameState state) {
        RussianWordQuest.setState(state);
    }

    private void updateEngine(double delta) {
        //time related things must be multiplied by delta
        //non time related ignore delta 

        //draws tiles
        Tile[][] viewTiles = new Tile[20][15];

        for (int x = 0; x < 20; x++) {
            for (int y = 0; y < 15; y++) {
                if ((x + (RussianWordQuest.player.getX() - 320) / 32) >= 0 && (x + (RussianWordQuest.player.getX() - 320) / 32) < 40) {
                    if (y + ((RussianWordQuest.player.getY() - 240) / 32) >= 0 && (y + ((RussianWordQuest.player.getY() - 240) / 32) < 30)) {
                        viewTiles[x][y] = overworld.getTile(x + ((RussianWordQuest.player.getX() - 320) / 32), y + ((RussianWordQuest.player.getY() - 240) / 32));
                        viewTiles[x][y].setX(x);
                        viewTiles[x][y].setY(y);
                    }
                }
            }
        }
        //System.out.println(viewTiles[0][0].toString());
        Map view = new Map(15, 20, viewTiles);

        for (int x = 0; x < view.getRows(); x++) {
            for (int y = 0; y < view.getCols(); y++) {
                image.render(view.getTile(y, x));
            }
        }

        // draws entities
        for (int i = 0; i < Instances.getEntities().size(); i++) {
            Entity entity = (Entity) Instances.getEntities().get(i);
            image.render(entity);
        }

    }

    private void loadWorld() {
        System.out.println("loading map");
        try {
            overworld = MapUtilities.readMap("src/russianwordquest/resources/maps/overworld.txt");
            System.out.println("loaded map");
        } catch (Exception e) {
            System.out.println("failed to load map");
        }
    }
}
