package russianwordquest;

/**
 *
 * @author jonathan2
 */
public class Runner implements Runnable {

    Paint image = new Paint();

    @Override
    public void run() {
        while (true) {
            Instances.player.update();
            image.render();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}