package homework04;

public class Node {

  private Object data;
  private Node next;

  public Node(Object obj) {
    this.data = obj;
    this.next = null;
  }

  public Object getData() {
    return this.data;
  }

  public void setData(Object inputObj) {
    this.data = inputObj;
  }

  public Node getNext() {
    return this.next;
  }

  public void setNext(Node nextNode) {
    this.next = nextNode;
  }
}
