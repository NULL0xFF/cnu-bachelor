package homework04.circle;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleFrame extends JFrame {

  private static final long serialVersionUID = 1L;

  public CircleFrame() {
    setSize(600, 600);
    setTitle("원 그리기");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    JPanel circlePanel = new CirclePanel();
    add(circlePanel);
    setVisible(true);
  }
}