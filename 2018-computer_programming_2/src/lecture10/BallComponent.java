package lecture10;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JPanel;

/**
 * The component that draws the balls.
 *
 * @author Cay Horstmann
 * @version 1.33 2007-05-17
 */
public class BallComponent extends JPanel {

  private static final long serialVersionUID = 1L;
  Random r = new Random();
  private ArrayList<Ball> balls = new ArrayList<Ball>();

  /**
   * Add a ball to the component.
   *
   * @param b the ball to add
   */
  public void add(Ball b) {
    balls.add(b);
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g); // erase background
    Graphics2D g2 = (Graphics2D) g;
    for (Ball b : balls) {
      g2.fill(b.getShape());
      g2.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
    }
  }
}
