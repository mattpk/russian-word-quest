package russianwordquest;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class RussianWordQuest {

    public static final int DISPLAY_HEIGHT = 480;
    public static final int DISPLAY_WIDTH = 640;
    private static GameState state = GameState.INTRO;
    public static boolean isRunning = false;
    public static Player player;
    public static final Logger LOGGER = Logger.getLogger(RussianWordQuest.class.getName());
    public static InGameMenu gameMenu;

    static {
        try {
            LOGGER.addHandler(new FileHandler("errors.log", true));
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.toString(), ex);
        }
    }

    public RussianWordQuest() {
        System.out.println("Started up.");
    }

    public static void main(String[] args) {
        RussianWordQuest game = new RussianWordQuest();
        Runner engine = null;
        try {
            game.initGame();
            game.initEntities();
            engine = new Runner(true);
            new Thread(engine).start();
            isRunning = true;
            System.out.println("Runner called");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (engine != null) {
            }
        }

    }

    public void initGame() {
        Instances.getEntities().clear();
    }

    public void initEntities() {
        player = new Player();
        player.setLoc(100, 100);
        Instances.getEntities().add(player);
        System.out.println("initliazed entities");
    }
}
