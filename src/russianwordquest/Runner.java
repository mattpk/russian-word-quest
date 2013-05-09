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

    @Override
    public void run() {
        while (RussianWordQuest.isRunning) {
            
            long now = System.nanoTime();
            long updateLength = now - previousLoopTime;
            previousLoopTime = now;
            double delta = updateLength /  ((double)IDEAL_TIME);
            
            lastFpsTime += updateLength;
            fps++;
            
            if (lastFpsTime >= 1000000000)
            {
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            updateEngine(delta);
            
            Instances.player.update();
            image.render();

            try {
                Thread.sleep((previousLoopTime - System.nanoTime() + IDEAL_TIME) / 1000000);
            } catch (InterruptedException e) {
            }
        }
    }

    private void updateEngine(double delta) {
        //time related things must be multiplied by delta
        
        //non time related ignore delta 
    }
}