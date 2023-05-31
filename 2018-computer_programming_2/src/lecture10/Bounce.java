package lecture10;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Shows an animated bouncing ball.
 *
 * @author Cay Horstmann
 * @version 1.33 2007-05-17
 */
public class Bounce {

  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        JFrame frame = new BounceFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
      }
    });
  }
}

/**
 * The frame with ball component and buttons.
 */
class BounceFrame extends JFrame {

  public static final int DEFAULT_WIDTH = 450;
  public static final int DEFAULT_HEIGHT = 350;
  public static final int STEPS = 1000000000;
  public static final int DELAY = 2;
  private static final long serialVersionUID = 1L;
  private BallComponent comp;
  /**
   * Constructs the frame with the component for showing the bouncing ball and Start and Close
   * buttons
   */

  public BounceFrame() {
    setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    setTitle("Bounce");

    comp = new BallComponent();
    add(comp, BorderLayout.CENTER);
    JPanel buttonPanel = new JPanel();
    addButton(buttonPanel, "Start", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        addBall();
      }
    });

    addButton(buttonPanel, "Make", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        Timer t = new Timer();
        t.schedule(new BallAdder(), 0, 100);
      }
    });

    addButton(buttonPanel, "Close", new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        System.exit(0);
      }
    });

    add(buttonPanel, BorderLayout.SOUTH);
  }

  /**
   * Adds a button to a container.
   *
   * @param c        the container
   * @param title    the button title
   * @param listener the action listener for the button
   */
  public void addButton(Container c, String title, ActionListener listener) {
    JButton button = new JButton(title);
    c.add(button);
    button.addActionListener(listener);
  }

  /**
   * Adds a bouncing ball to the panel and makes it bounce 1,000 times.
   */
  public void addBall() {
    Ball ball = new Ball();
    comp.add(ball);
    Runnable r = new BallRunnable(ball, comp);
    Thread t = new Thread(r);
    t.start();
  }

  class BallRunnable implements Runnable {

    private Ball ball;
    private BallComponent comp;

    public BallRunnable(Ball inputBall, BallComponent inputComp) {
      this.ball = inputBall;
      this.comp = inputComp;
    }

    @Override
    public void run() {
      try {
        for (int i = 1; i <= STEPS; i++) {
          ball.move(comp.getBounds());
          comp.repaint();
          Thread.sleep(DELAY);
        }
      } catch (InterruptedException exception) {
      }
    }
  }

  class BallAdder extends TimerTask {

    @Override
    public void run() {
      addBall();
    }
  }
}