package russianwordquest;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author jonathan2
 */
public class MainMenu extends JPanel {

    private int height;
    private int width;

    public MainMenu(int width, int height) {
        this.width = width;
        this.height = height;
        System.out.println("main menu initialized");
        super.setVisible(true);
        super.setSize(width, height);
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString("Main Menu", 290, 50);
    }
}