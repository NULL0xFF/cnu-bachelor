package homework05;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class CalculatorActionListener implements ActionListener {

  private String value;
  private JTextField output;

  public CalculatorActionListener(String value, JTextField output) {
    this.value = value;
    this.output = output;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    this.output.setText(String.format("%s%s", this.output.getText(), this.value));
  }
}
