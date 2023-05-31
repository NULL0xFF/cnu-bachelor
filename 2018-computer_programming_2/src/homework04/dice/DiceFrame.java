package homework04.dice;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiceFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private final int X_SIZE = 600;
  private final int Y_SIZE = 600;

  public DiceFrame() {
    setSize(X_SIZE, Y_SIZE);
    setTitle("주사위 던지기 프로그램");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    JPanel dicePanel = new DicePanel(X_SIZE, Y_SIZE);
    addKeyListener(new DiceKeyListener(dicePanel));
    add(dicePanel);
    setVisible(true);
  }
}
