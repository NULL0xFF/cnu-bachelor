package homework02;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HotelBooking {

  public static void main(String[] args) {
    new BookingFrame();
  }

}

class BookingFrame extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private JButton[] numberButtons;
  private JLabel descriptionLabel;
  private JPanel panel1;
  private JPanel panel2;
  private JPanel panel3;
  private int numberOfPersons;

  public BookingFrame() {
    setTitle("호텔 예약 애플리케이션");
    setSize(500, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();

    numberButtons = new JButton[5];
    for (numberOfPersons = 1; numberOfPersons <= numberButtons.length; numberOfPersons++) {
      numberButtons[numberOfPersons - 1] = new JButton(String.format("%d명", numberOfPersons));
      panel2.add(numberButtons[numberOfPersons - 1]);
    }

    numberButtons[0].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new BookingMessageFrame(1);
      }
    });

    numberButtons[1].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new BookingMessageFrame(2);
      }
    });

    numberButtons[2].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new BookingMessageFrame(3);
      }
    });

    numberButtons[3].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new BookingMessageFrame(4);
      }
    });

    numberButtons[4].addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        new BookingMessageFrame(5);
      }
    });

    descriptionLabel = new JLabel("자바 호텔에 오신 것을 환영합니다. 숙박인원을 선택하세요.");

    panel1.add(descriptionLabel);

    panel3.add(panel1);
    panel3.add(panel2);

    add(panel3);

    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
  }
}

class BookingMessageFrame extends JFrame {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private JButton confirmButton;
  private JLabel resultLabel;
  private JPanel panel1;
  private JPanel panel2;
  private JPanel panel3;

  public BookingMessageFrame(int numberOfPersons) {
    setTitle("호텔 예약 완료");
    setSize(300, 100);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    confirmButton = new JButton("확인");
    confirmButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });

    resultLabel = new JLabel(String.format("%d명이 예약되었습니다.", numberOfPersons));

    panel1 = new JPanel();
    panel2 = new JPanel();
    panel3 = new JPanel();

    panel1.add(resultLabel);
    panel2.add(confirmButton);
    panel3.add(panel1);
    panel3.add(panel2);

    add(panel3);

    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
  }
}