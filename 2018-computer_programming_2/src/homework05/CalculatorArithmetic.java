package homework05;

public class CalculatorArithmetic {

  private String expression;
  private String expressionWithoutNumber;
  private String[] numberArray;
  private String[] operationArray;

  public CalculatorArithmetic(String expression) {
    this.expression = expression;
  }

  public double output() {
    double output = 0;

    splitExpression2Number();
    splitExpression2Operation();

//		System.out.println(expressionWithoutNumber);
//
//		for (int i = 0; i < numberArray.length; i++) {
//			System.out.println(numberArray[i]);
//		}
//		for (int i = 0; i < operationArray.length; i++) {
//			System.out.println(operationArray[i]);
//		}

    for (int i = 0; i < operationArray.length; i++) {
      if (operation)
    }

    return output;
  }

  private void splitExpression2Number() {
    numberArray = this.expression.split("[+*-/]");
  }

  private void splitExpression2Operation() {
    expressionWithoutNumber = this.expression.replaceAll("[\\d]", "");
    operationArray = this.expressionWithoutNumber.split("(?!^)");
  }
}
