package homework04.circle;

import java.awt.Color;
import java.awt.Graphics;

public class Circle {

  private int radius;
  private int centerX, centerY;
  private Color color;

  public Circle(int radius, int centerX, int centerY, Color color) {
    this.radius = radius;
    this.centerX = centerX;
    this.centerY = centerY;
    this.color = color;
  }

  public void drawCircle(Graphics g) {
    g.setColor(this.color);
    g.fillOval(this.centerX - radius, this.centerY - radius, radius, radius);
  }
}
