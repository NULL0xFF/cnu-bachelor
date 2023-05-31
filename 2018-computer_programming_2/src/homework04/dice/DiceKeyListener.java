package homework04.dice;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class DiceKeyListener implements KeyListener {

  private JPanel panel;

  public DiceKeyListener(JPanel panel) {
    this.panel = panel;
  }

  @Override
  public void keyPressed(KeyEvent e) {
    System.out.println(e);
    if (e.getKeyCode() == KeyEvent.VK_F5) {
      panel.repaint();
    }
    if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
      System.exit(0);
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }

  @Override
  public void keyTyped(KeyEvent e) {
  }
}
