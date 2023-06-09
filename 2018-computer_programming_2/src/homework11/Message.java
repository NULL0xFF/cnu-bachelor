package homework11;

import java.io.Serializable;

public class Message implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer A;
  private Integer B;
  private Integer Result;

  public Message(Integer firstNumber, Integer secondNumber) {
    this.A = firstNumber;
    this.B = secondNumber;
  }

  public Integer getA() {
    return A;
  }

  public Integer getB() {
    return B;
  }

  public void setResult(Integer X) {
    Result = X;
  }
}