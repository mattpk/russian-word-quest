package russianwordquest;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author jonathan2
 */
public class EventHandler extends KeyAdapter {

    public EventHandler() {
        System.out.println("EventHandler Initialized");
    }

    public void keyPressed(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                RussianWordQuest.player.setUp(true);
                break;
            case KeyEvent.VK_DOWN:
                RussianWordQuest.player.setDown(true);
                break;
            case KeyEvent.VK_LEFT:
                RussianWordQuest.player.setLeft(true);
                break;
            case KeyEvent.VK_RIGHT:
                RussianWordQuest.player.setRight(true);
                break;
        }
    }

    public void keyReleased(KeyEvent key) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_UP:
                RussianWordQuest.player.setUp(false);
                System.out.println(" Released UP!");
                break;
            case KeyEvent.VK_DOWN:
                System.out.println(" Released DOWN!");
                RussianWordQuest.player.setDown(false);
                break;
            case KeyEvent.VK_LEFT:
                System.out.println(" Released LEFT!");
                RussianWordQuest.player.setLeft(false);
                break;
            case KeyEvent.VK_RIGHT:
                System.out.println(" Released RIGHT!");
                RussianWordQuest.player.setRight(false);
                break;
        }
    }

    public void keyTyped(KeyEvent key) {
    }
}
