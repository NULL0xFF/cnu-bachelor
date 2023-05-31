package homework04.circle;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class CirclePanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private Random random = new Random();
  private Circle circle;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (int i = 0; i < 10; i++) {
      randomCircle();
      circle.drawCircle(g);
    }
  }

  public void randomCircle() {
    this.circle = new Circle(random.nextInt(600), random.nextInt(600), random.nextInt(600),
        new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
  }
}
