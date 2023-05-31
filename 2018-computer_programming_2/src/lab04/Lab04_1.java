package lab04;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab04_1 extends JFrame {

  private static final long serialVersionUID = 1L;

  public Lab04_1() {
    setSize(280, 300);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setTitle("����� ��");
    setVisible(true);
    add(new CustomPanel01());
  }

  public static void main(String[] args) {
    new Lab04_1();
  }

}

class CustomPanel01 extends JPanel {

  private static final long serialVersionUID = 1L;

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(Color.YELLOW);
    g.fillOval(20, 30, 200, 200);
    g.setColor(Color.BLACK);
    g.drawArc(60, 80, 50, 50, 180, -180);
    g.drawArc(150, 80, 50, 50, 180, -180);
    g.drawArc(70, 130, 100, 70, 180, 180);
  }
}