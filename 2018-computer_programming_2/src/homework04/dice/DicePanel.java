package homework04.dice;

import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DicePanel extends JPanel {

  private static final long serialVersionUID = 1L;
  private final int DICE_SIZE = 100;

  private int frame_x_size, frame_y_size;
  private Random random = new Random();
  private Dice firstDice;
  private Dice secondDice;

  public DicePanel(int size_x, int size_y) {
    this.frame_x_size = size_x;
    this.frame_y_size = size_y;
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    randomDice();
    firstDice.drawDice(g);
    secondDice.drawDice(g);
  }

  public void randomDice() {
    int fX, fY, sX, sY;
    boolean FLAG = false;
    do {
      fX = random.nextInt(frame_x_size - DICE_SIZE);
      fY = random.nextInt(frame_y_size - DICE_SIZE);
      sX = random.nextInt(frame_x_size - DICE_SIZE);
      sY = random.nextInt(frame_y_size - DICE_SIZE);
      System.out.printf("!! FIRST DICE \t%d, %d\n", fX, fY);
      System.out.printf("!! SECOND DICE \t%d, %d\n\n", sX, sY);
      if (FLAG == true) {
        break;
      }
    } while (((sX > fX - DICE_SIZE) && (sX < fX + DICE_SIZE)) && ((sY > fY - DICE_SIZE) && (sY
        < fY + DICE_SIZE)));
    this.firstDice = new Dice(fX, fY, DICE_SIZE);
    this.secondDice = new Dice(sX, sY, DICE_SIZE);
  }
}
