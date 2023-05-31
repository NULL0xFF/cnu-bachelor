package homework10.game.control;

import homework10.game.gui.GamePanel;
import homework10.game.object.Player;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyMapping extends KeyAdapter {

  private static final int SPEED = 15;

  private GamePanel gamePanel;
  private Player player;

  public KeyMapping(GamePanel gamePanel) {
    this.gamePanel = gamePanel;
    player = (Player) gamePanel.getGameObject("player");
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    if (e.getKeyCode() == KeyEvent.VK_UP) {
      if (isBlocked(0, -(SPEED)) == false) {
        player.move(0, -(SPEED));
        gamePanel.repaint();
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
      if (isBlocked(0, SPEED) == false) {
        player.move(0, SPEED);
        gamePanel.repaint();
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_LEFT) {
      if (isBlocked(-(SPEED), 0) == false) {
        player.move(-(SPEED), 0);
        gamePanel.repaint();
      }
    }
    if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
      if (isBlocked(SPEED, 0) == false) {
        player.move(SPEED, 0);
        gamePanel.repaint();
      }
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  private boolean isBlocked(int dx, int dy) {
    boolean dxBlocked =
        this.player.getPosX() + this.player.getWidth() + dx <= this.gamePanel.getFrameWidthSize()
            && this.player.getPosX() + dx >= 0;
    boolean dyBlocked =
        this.player.getPosY() + this.player.getHeight() + dy <= this.gamePanel.getFrameHeightSize()
            && this.player.getPosY() + dy >= 0;

    if (dxBlocked && dyBlocked) {
      return false;
    } else {
      return true;
    }
  }
}
