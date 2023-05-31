package homework03;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InterestCalculator {

  public static void main(String[] args) {
    new InterestCalculatorFrame();
  }

}

class InterestCalculatorFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private final int panelPadding = 2;
  private JPanel mainPanel;
  private JPanel principalPanel;
  private JLabel principalLabel;
  private JTextField principalTextField;
  private JPanel interestRatePanel;
  private JLabel interestRateLabel;
  private JTextField interestRateTextField;
  private JPanel conversionPanel;
  private JButton conversionButton;
  private JPanel convertedInterestPanel;
  private JTextField convertedInterestTextField;

  public InterestCalculatorFrame() {
    setTitle("이자 계산기");
    setSize(360, (124 + (panelPadding * 8)));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mainPanel = new JPanel();
    mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

    principalPanel = new JPanel();
    principalPanel.setLayout(new BorderLayout());
    principalLabel = new JLabel("원금을 입력하시오.");
    principalTextField = new JTextField(8);
    principalTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
    principalPanel.add(principalLabel, BorderLayout.WEST);
    principalPanel.add(principalTextField, BorderLayout.EAST);

    mainPanel.add(principalPanel);

    interestRatePanel = new JPanel();
    interestRatePanel.setLayout(new BorderLayout());
    interestRateLabel = new JLabel("이율을 입력하시오.");
    interestRateTextField = new JTextField(8);
    interestRateTextField.setAlignmentX(Component.RIGHT_ALIGNMENT);
    interestRatePanel.add(interestRateLabel, BorderLayout.WEST);
    interestRatePanel.add(interestRateTextField, BorderLayout.EAST);

    mainPanel.add(interestRatePanel);

    conversionPanel = new JPanel();
    conversionButton = new JButton("변환");
    conversionButton.setAlignmentX(Component.CENTER_ALIGNMENT);
    conversionPanel.add(conversionButton);

    mainPanel.add(conversionPanel);

    convertedInterestPanel = new JPanel();
    convertedInterestPanel.setLayout(new BorderLayout());
    convertedInterestTextField = new JTextField(30);
    convertedInterestPanel.add(convertedInterestTextField);

    mainPanel.add(convertedInterestPanel);

    add(mainPanel);

    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
  }
}