package homework04;

public class LinkedStack implements Stack {

  private int size;
  private Node start;

  public LinkedStack(String inputString) {
    while (inputString.length() != 0) {
      this.push(inputString.charAt(0));
      inputString = inputString.substring(1);
    }
  }

  public void pointedParentheses() {
    LinkedStack parenthesesStack = new LinkedStack("");
    Node pointer = this.start;
    for (int loop = 0; loop < this.size; loop++) {
      if (pointer.getData() == (Object) '(') {
        parenthesesStack.push(loop);
      } else if (pointer.getData() == (Object) ')') {
        try {
          int pointed = (int) parenthesesStack.pop();
          System.out.printf("%d, %d\n", pointed, loop);
        } catch (IllegalStateException e) {
          System.out.print("괄호쓰기가 틀림\n");
          return;
        }
      }
      pointer = pointer.getNext();
    }
    if (!parenthesesStack.isEmpty()) {
      System.out.print("괄호쓰기가 틀림\n");
    } else {
      System.out.print("괄호쓰기가 맞음\n");
    }
  }

  public boolean isEmpty() {
    return (this.size == 0);
  }

  @Override
  public Object peek() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    Node pointer = this.start;
    if (pointer.getNext() == null) {
      return pointer.getData();
    }
    while (pointer.getNext() != null) {
      pointer = pointer.getNext();
    }
    return pointer.getData();
  }

  @Override
  public Object pop() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    Node pointer = this.start;
    Node copointer = pointer;
    if (pointer.getNext() == null) {
      copointer = this.start;
      this.start = null;
      size--;
      return copointer.getData();
    }
    while (pointer.getNext() != null) {
      copointer = pointer;
      pointer = pointer.getNext();
    }
    copointer.setNext(null);
    size--;
    return pointer.getData();
  }

  @Override
  public void push(Object obj) {
    if (isEmpty()) {
      this.start = new Node(obj);
      size++;
      return;
    }
    Node pointer = this.start;
    while (pointer.getNext() != null) {
      pointer = pointer.getNext();
    }
    pointer.setNext(new Node(obj));
    size++;
  }

  @Override
  public int size() {
    return this.size;
  }

  @Override
  public String toString() {
    StringBuilder stringBuilder = new StringBuilder("저장된 값 : ");
    Node pointer = this.start;
    while (pointer != (null)) {
      stringBuilder.append(pointer.getData());
      pointer = pointer.getNext();
    }
    return stringBuilder.toString();
  }
}
