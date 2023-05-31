package homework04;

public class LinkedStackTest {

  public static void main(String[] args) {
    LinkedStack linkedStack = new LinkedStack(args[0]);
    System.out.printf("%s\n", linkedStack);
    linkedStack.pointedParentheses();
  }
}
