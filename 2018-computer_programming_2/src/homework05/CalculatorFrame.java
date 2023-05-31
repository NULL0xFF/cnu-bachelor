package homework05;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 계산기 Frame
 *
 * @author JiMyoungHa
 */

public class CalculatorFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private final int borderPadding = 4; // 여백 상수
  private JPanel resultPanel; // I/O 출력 패널
  private JPanel eraseButtonPanel; // 지우기 버튼 패널
  private JPanel insertButtonPanel; // 입력 버튼 패널
  private JTextField resultTextField; // I/O 텍스트
  private JButton eraseButton; // 지우기 버튼
  private JButton[] numberButtons; // 0~9까지의 숫자 버튼
  private JButton[] operatorButtons; // 연산자 버튼

  public CalculatorFrame() {

    /*
     * Frame 초기화
     */
    setTitle("계산기");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));

    /*
     * I/O 출력 패널 생성 및 I/O 텍스트 생성/추가
     */
    resultPanel = new JPanel();
    resultPanel.setBorder(
        BorderFactory.createEmptyBorder(borderPadding, borderPadding, borderPadding / 2,
            borderPadding));
    resultTextField = new JTextField(20);
    resultTextField.setEnabled(false);
//		resultTextField.getDocument().addDocumentListener(new DocumentListener() {
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//			}
//
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//			}
//
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				System.out.println("CHANGED");
//			}
//		});
    resultPanel.add(resultTextField);

    /*
     * 지우기 버튼 패널 생성 및 지우기 버튼 (C) 생성/추가
     */
    eraseButtonPanel = new JPanel();
    eraseButtonPanel.setLayout(new GridLayout(0, 4, borderPadding, borderPadding));
    eraseButtonPanel.setBorder(
        BorderFactory.createEmptyBorder(borderPadding / 2, borderPadding, borderPadding / 2,
            borderPadding));
    eraseButton = new JButton("C");
    eraseButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        resultTextField.setText("");
      }
    });
    eraseButtonPanel.add(eraseButton);

    /*
     * 입력 버튼 패널 생성
     */
    insertButtonPanel = new JPanel();
    insertButtonPanel.setLayout(new GridLayout(0, 4, borderPadding, borderPadding));
    insertButtonPanel.setBorder(
        BorderFactory.createEmptyBorder(borderPadding / 2, borderPadding, borderPadding,
            borderPadding));

    /*
     * 0~9 숫자 버튼 생성
     */
    numberButtons = new JButton[10];
    for (int number = 0; number <= 9; number++) {
      numberButtons[number] = new JButton(String.format("%d", number));
      numberButtons[number]
          .addActionListener(
              new CalculatorActionListener(String.format("%d", number), resultTextField));
    }

    /*
     * 연산자 버튼 생성
     */
    operatorButtons = new JButton[6];
    operatorButtons[0] = new JButton("+");
    operatorButtons[0].addActionListener(new CalculatorActionListener("+", resultTextField));
    operatorButtons[1] = new JButton("-");
    operatorButtons[1].addActionListener(new CalculatorActionListener("-", resultTextField));
    operatorButtons[2] = new JButton("*");
    operatorButtons[2].addActionListener(new CalculatorActionListener("*", resultTextField));
    operatorButtons[3] = new JButton("/");
    operatorButtons[3].addActionListener(new CalculatorActionListener("/", resultTextField));
    operatorButtons[4] = new JButton("=");
    operatorButtons[4].addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        new CalculatorArithmetic(resultTextField.getText()).output();
        ScriptEngineManager sEM = new ScriptEngineManager();
        ScriptEngine sE = sEM.getEngineByName("JavaScript");
        String input = resultTextField.getText();
        try {
          resultTextField.setText(String.valueOf(sE.eval(input)));
        } catch (ScriptException e1) {
          e1.printStackTrace();
          resultTextField.setText("");
        }
      }
    });
    operatorButtons[5] = new JButton("back");
    operatorButtons[5].addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        resultTextField.setText(
            resultTextField.getText().substring(0, resultTextField.getText().length() - 1));
      }
    });

    /*
     * 입력 버튼 패널에 숫자 및 연산자 버튼 추가
     */
    for (

        int number = 7; number <= 9; number++) {
      insertButtonPanel.add(numberButtons[number]);
    }
    insertButtonPanel.add(operatorButtons[3]);
    for (int number = 4; number <= 6; number++) {
      insertButtonPanel.add(numberButtons[number]);
    }
    insertButtonPanel.add(operatorButtons[2]);
    for (int number = 1; number <= 3; number++) {
      insertButtonPanel.add(numberButtons[number]);
    }
    insertButtonPanel.add(operatorButtons[1]);
    insertButtonPanel.add(numberButtons[0]);
    insertButtonPanel.add(operatorButtons[5]);
    insertButtonPanel.add(operatorButtons[4]);
    insertButtonPanel.add(operatorButtons[0]);

    /*
     * I/O 출력, 지우기, 입력 패널을 Frame에 추가
     */
    add(resultPanel);
    add(eraseButtonPanel);
    add(insertButtonPanel);

    /*
     * Frame 설정
     */
    pack();
    setVisible(true);
    setResizable(false);
    setLocationRelativeTo(null);
  }
}