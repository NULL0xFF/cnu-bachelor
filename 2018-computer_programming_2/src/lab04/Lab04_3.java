package lab04;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Lab04_3 extends JFrame implements ActionListener {

  private static final long serialVersionUID = 1L;

  BufferedImage img;
  private int pieces = 4;
  private int totalPieces = pieces * pieces;
  private int[] pieceNumber;

  public Lab04_3() {
    setTitle("Image Draw Test");
    try {
      img = ImageIO.read(new File("res/lab04/img/cat.jpg"));
    } catch (IOException e) {
      System.out.println(e.getMessage());
      System.exit(0);
    }

    pieceNumber = new int[totalPieces];
    for (int i = 0; i < totalPieces; i++) {
      pieceNumber[i] = i;
    }

    add(new CustomPanel03(), BorderLayout.CENTER);
    JButton button = new JButton("DIVIDE");
    button.addActionListener(this);
    add(button, BorderLayout.SOUTH);
    setSize(600, 600);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Lab04_3();
  }

  void divide() {
    Random rand = new Random();
    int ri;
    for (int i = 0; i < totalPieces; i++) {
      ri = rand.nextInt(totalPieces);
      int tmp = pieceNumber[i];
      pieceNumber[i] = pieceNumber[ri];
      pieceNumber[ri] = tmp;
    }
  }

  public void actionPerformed(ActionEvent e) {
    divide();
    repaint();
  }

  class CustomPanel03 extends JPanel {

    private static final long serialVersionUID = 1L;

    public void paintComponent(Graphics g) {
      super.paintComponent(g);
      int pieceWidth = img.getWidth(null) / pieces;
      int pieceHeight = img.getHeight(null) / pieces;
      for (int x = 0; x < pieces; x++) {
        int sx = x * pieceWidth;
        for (int y = 0; y < pieces; y++) {
          int sy = y * pieceHeight;
          int number = pieceNumber[x * pieces + y];
          int dx = (number / pieces) * pieceWidth;
          int dy = (number % pieces) * pieceHeight;
          g.drawImage(img, dx, dy, dx + pieceWidth, dy + pieceHeight, sx, sy, sx + pieceWidth,
              sy + pieceHeight, null);
        }
      }
    }
  }
}
