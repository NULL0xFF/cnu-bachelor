package homework10.game.gui;

import homework10.game.object.Enemy;
import homework10.game.object.EnemyAlgorithm;
import homework10.game.object.GameObject;
import homework10.game.object.Player;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

  private static final long serialVersionUID = 1L;

  private static final int DEFAULT_FRAME_WIDTH_SIZE = 600;
  private static final int DEFAULT_FRAME_HEIGHT_SIZE = 600;
  private static final Color DEFAULT_BACKGROUND_COLOR = Color.WHITE;

  private HashMap<String, GameObject> gameObject;
  private int frameWidthSize;
  private int frameHeightSize;

  public GamePanel() {
    this.frameWidthSize = GamePanel.DEFAULT_FRAME_WIDTH_SIZE;
    this.frameHeightSize = GamePanel.DEFAULT_FRAME_HEIGHT_SIZE;
    this.setPreferredSize(
        new Dimension(GamePanel.DEFAULT_FRAME_WIDTH_SIZE, GamePanel.DEFAULT_FRAME_HEIGHT_SIZE));
    this.setBackground(DEFAULT_BACKGROUND_COLOR);
    initial();
  }

  public GamePanel(int frameWidthSize, int frameHeightSize) {
    this.frameWidthSize = frameWidthSize;
    this.frameHeightSize = frameHeightSize;
    this.setPreferredSize(new Dimension(frameWidthSize, frameHeightSize));
    this.setBackground(DEFAULT_BACKGROUND_COLOR);
    initial();
  }

  public GamePanel(int frameWidthSize, int frameHeightSize, Color backGroundColor) {
    this.frameWidthSize = frameWidthSize;
    this.frameHeightSize = frameHeightSize;
    this.setPreferredSize(new Dimension(frameWidthSize, frameHeightSize));
    this.setBackground(backGroundColor);
    initial();
  }

  private void initial() {
    this.gameObject = new HashMap<String, GameObject>();
    this.gameObject.put("player", new Player(frameWidthSize / 2, frameHeightSize / 2));
    this.gameObject.put("enemy", new Enemy());
    Enemy enemy = (Enemy) this.gameObject.get("enemy");
    enemy.setAlgorithm(new EnemyAlgorithm(this));
    Thread t = new Thread(enemy.getAlgorithm());
    t.start();
  }

  public int getFrameWidthSize() {
    return this.frameWidthSize;
  }

  public int getFrameHeightSize() {
    return this.frameHeightSize;
  }

  public GameObject getGameObject(Object key) {
    return this.gameObject.get(key);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawObject(g);
  }

  private void drawObject(Graphics g) {
    Iterator<String> it = this.gameObject.keySet().iterator();
    while (it.hasNext()) {
      String key = (String) it.next();
      this.gameObject.get(key).draw(g);
    }
  }
}
