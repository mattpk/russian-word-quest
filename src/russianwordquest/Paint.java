package russianwordquest;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jonathan2
 */
public final class Paint {
    
    JFrame frame;
    Canvas canvas;
    BufferStrategy buffer;
    private final int DISPLAY_HEIGHT = 480;
    private final int DISPLAY_WIDTH = 640;
    private final String NAME = "Russian Word Quest";
    
    Paint() {
        frame = new JFrame(NAME);
        JPanel panel = (JPanel) frame.getContentPane();
        
        panel.setPreferredSize(new Dimension(DISPLAY_WIDTH, DISPLAY_HEIGHT));
        panel.setLayout(null);
        
        canvas = new Canvas();
        canvas.setBounds(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
        canvas.setIgnoreRepaint(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        
        frame.setResizable(false);
        frame.setVisible(true);
        
        panel.add(canvas);
        canvas.createBufferStrategy(2);
        buffer = canvas.getBufferStrategy();
        
        canvas.requestFocus();
        
        canvas.setBackground(Color.black);
        canvas.addKeyListener(new EventHandler());
        
        BufferedImage blankCursorImg =
                new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
        Cursor blankCursor = Toolkit.getDefaultToolkit().
                createCustomCursor(blankCursorImg, new Point(0, 0), null);
        canvas.setCursor(blankCursor);
        
    }
    
    public void render(AbstractEntity entity) {
        Graphics2D graphics;
        graphics = (Graphics2D) buffer.getDrawGraphics();
        graphics.clearRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
        render(graphics, entity);
        
        graphics.dispose();
        buffer.show();
    }
    
    private void render(Graphics2D graphics, AbstractEntity entity) {
        graphics.drawImage(entity.getImage(), entity.getX(), entity.getY(), null);
        Toolkit.getDefaultToolkit().sync();
        graphics.finalize();
    }
}
