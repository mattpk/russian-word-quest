package russianwordquest;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RussianWordQuest {

    public static final int DISPLAY_HEIGHT = 480;
    public static final int DISPLAY_WIDTH = 640;
    private final static String NAME = "Russian Word Quest";
    private BufferedImage image = new BufferedImage(DISPLAY_WIDTH, DISPLAY_HEIGHT, BufferedImage.TYPE_INT_RGB);
    private int[] onScreenPixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
    private static GameState state = GameState.INTRO;
    public static final Logger LOGGER = Logger.getLogger(RussianWordQuest.class.getName());
    private static long lastFrame;
    private boolean isRunning = false;

    static {
        try {
            LOGGER.addHandler(new FileHandler("errors.log", true));
        } catch (IOException ex) {
            LOGGER.log(Level.WARNING, ex.toString(), ex);
        }
    }

    public static void main(String[] args) {
        Runner engine = null;
        try {
            engine = new Runner();

            new Thread(engine).start();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.toString(), e);
        } finally {
            if (engine != null) {
            }
        }

    }

    public RussianWordQuest() {
    }
}
