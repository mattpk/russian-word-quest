package russianwordquest;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jonathan2
 */
public final class Paint {
  
  public static JFrame frame;
  Canvas canvas;
  BufferStrategy buffer;
  public static final int DISPLAY_HEIGHT = 480;
  public static final int DISPLAY_WIDTH = 640;
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
    try{
      canvas.createBufferStrategy(2, new BufferCapabilities(new ImageCapabilities(true), new ImageCapabilities(true), null));
    }
    catch(AWTException e)
    {
      
    }
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
  
  public void render(Object object) {
    Graphics2D graphics;
    graphics = (Graphics2D) buffer.getDrawGraphics();
    //  graphics.clearRect(0, 0, DISPLAY_WIDTH, DISPLAY_HEIGHT);
    
    if (object instanceof Tile)
      render (graphics, (Tile)object);
    if (object instanceof Entity)
    {
      render(graphics, (Entity) object);          
      graphics.dispose();
      buffer.show();
    }
    
  }
  
  private void render(Graphics2D graphics, Entity entity) {
    if (entity instanceof Player)
    {
      graphics.drawImage(entity.getImage(),320,256,null);
    }
    else
    {
      graphics.drawImage (entity.getImage(), entity.getX(), entity.getY(), null);
    }
    Toolkit.getDefaultToolkit().sync();
    graphics.finalize();
  }
  
  private void render (Graphics2D graphics, Tile tile)
  {
    graphics.drawImage(tile.getImage(), tile.getX()*32, tile.getY()*32,null);
  }
  
  public void destroy()
  {
    frame.dispose();
  }
}
