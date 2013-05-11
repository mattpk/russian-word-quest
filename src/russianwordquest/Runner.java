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
    
    public Runner(boolean runFlag)
    {
        this.runFlag = runFlag;
    }

    @Override
    public void run() {
        while (runFlag) {

            long now = System.nanoTime();
            long updateLength = now - previousLoopTime;
            previousLoopTime = now;
            double delta = updateLength / ((double) IDEAL_TIME);

            lastFpsTime += updateLength;
            fps++;

            if (lastFpsTime >= 1000000000) {
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            updateEngine(delta);

            RussianWordQuest.player.update();
            //image.render();

            long sleep = (previousLoopTime - System.nanoTime() + IDEAL_TIME) / 1000000;

            if (sleep > 0) {
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                }
            }
        }
    }
    
    public void stop()
    {
        runFlag = false;
    }

    private void updateEngine(double delta) {
        //time related things must be multiplied by delta
        //non time related ignore delta 

        /*for (int i = 0; i < Instances.getEntities().size(); i++) {
         AbstractEntity entity = (AbstractEntity) Instances.getEntities().get(i);
         }*/
        image.render(RussianWordQuest.player);

    }
}