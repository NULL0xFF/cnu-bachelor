package homework04.dice;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Dice {

  private int X, Y;
  private int size;
  private Random random = new Random();
  private int diceNumber;

  public Dice(int x, int y, int size) {
    this.diceNumber = random.nextInt(6) + 1;
    this.X = x;
    this.Y = y;
    this.size = size;
  }

  public void drawDice(Graphics g) {
    switch (diceNumber) {
      case 1:
        createOne(g);
        break;
      case 2:
        createTwo(g);
        break;
      case 3:
        createThree(g);
        break;
      case 4:
        createFour(g);
        break;
      case 5:
        createFive(g);
        break;
      case 6:
        createSix(g);
        break;
      default:
        System.exit(0);
    }
  }

  private void createOne(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(X, Y, size, size, 40, 40);
    g.setColor(Color.BLACK);
    g.fillOval((int) (X + (size * (7.0 / 16.0))), (int) (Y + (size * (7.0 / 16.0))), size / 8,
        size / 8);
  }

  private void createTwo(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(X, Y, size, size, 40, 40);
    g.setColor(Color.BLACK);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
  }

  private void createThree(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(X, Y, size, size, 40, 40);
    g.setColor(Color.BLACK);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (7.0 / 16.0))), (int) (Y + (size * (7.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
  }

  private void createFour(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(X, Y, size, size, 40, 40);
    g.setColor(Color.BLACK);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
  }

  private void createFive(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(X, Y, size, size, 40, 40);
    g.setColor(Color.BLACK);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (7.0 / 16.0))), (int) (Y + (size * (7.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
  }

  private void createSix(Graphics g) {
    g.setColor(Color.WHITE);
    g.fillRoundRect(X, Y, size, size, 40, 40);
    g.setColor(Color.BLACK);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (3.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (7.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (7.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (3.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
    g.fillOval((int) (X + (size * (11.0 / 16.0))), (int) (Y + (size * (11.0 / 16.0))), size / 8,
        size / 8);
  }

  public int getX() {
    return X;
  }

  public int getY() {
    return Y;
  }
}
