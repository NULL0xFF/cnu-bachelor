package lab03;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FlowLayoutTest {

  public static void main(String[] args) {
    @SuppressWarnings("unused")
    BorderLayoutFrame f = new BorderLayoutFrame();
  }
}

class FlowLayoutFrame extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public FlowLayoutFrame() {
    setTitle("FlowLayoutTest");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JPanel panel;
    panel = new JPanel();
    panel.setLayout(new FlowLayout(FlowLayout.CENTER));
    panel.add(new JButton("Button1"));
    panel.add(new JButton("Button2"));
    panel.add(new JButton("Button3"));
    panel.add(new JButton("B4"));
    panel.add(new JButton("Long Button5"));
    add(panel);
    pack();
    setVisible(true);
  }
}