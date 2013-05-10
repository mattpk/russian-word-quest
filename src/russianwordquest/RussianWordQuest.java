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

    static {
        try {
            LOGGER.addHandler(new FileHandler("errors.log", true));
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.toString(), ex);
        }
    }

    public RussianWordQuest() {
        System.out.println("initliazed entities");
        initEntities();
    }

    public static void main(String[] args) {
        RussianWordQuest game = new RussianWordQuest();
        Runner engine = null;
        try {
            engine = new Runner();
            new Thread(engine).start();
            isRunning = true;
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

    public static void initEntities() {
        player = new Player();
        Instances.getEntities().add(player);
    }
}
