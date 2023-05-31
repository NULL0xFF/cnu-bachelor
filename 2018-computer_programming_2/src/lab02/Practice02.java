package lab02;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Practice02 {

  public static void main(String[] args) {
    new MyFrame();
  }

}

class MyFrame extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private JButton button;
  private JLabel label;

  public MyFrame() {
    setTitle("MyFrame");
    setSize(300, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());

    button = new JButton("버튼");
    label = new JLabel("레이블입니다.");

    add(button);
    add(label);

    setVisible(true);
  }
}
