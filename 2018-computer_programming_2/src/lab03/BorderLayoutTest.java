package lab03;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

public class BorderLayoutTest {

  public static void main(String[] args) {
    @SuppressWarnings("unused")
    BorderLayoutFrame f = new BorderLayoutFrame();
  }
}

class BorderLayoutFrame extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public BorderLayoutFrame() {
    setTitle("BorderLayoutTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BorderLayout());
    add(new JButton("Page Start"), BorderLayout.PAGE_START);
    add(new JButton("Page End"), BorderLayout.PAGE_END);
    add(new JButton("Center"), BorderLayout.CENTER);
    add(new JButton("Line Start"), BorderLayout.LINE_START);
    add(new JButton("Line End"), BorderLayout.LINE_END);
    pack();
    setVisible(true);
  }
}