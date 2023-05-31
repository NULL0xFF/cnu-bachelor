package homework05.v2;

public class SLinkedQueue implements Queue {

  private Node head;
  private Node rear;
  private int size = 0;

  @Override
  public void add(Object object) {
    if (isEmpty()) {
      this.rear = this.head = new Node(object);
    } else {
      this.rear = this.rear.next = new Node(object);
    }
    this.size++;
  }

  @Override
  public Object first() {
    if (isEmpty()) {
      throw new IllegalStateException("the queue is empty");
    }
    return head.object;
  }

  @Override
  public Object remove() {
    if (isEmpty()) {
      throw new IllegalStateException("queue is empty");
    }
    Object object = this.head.object;
    this.head = this.head.next;
    this.size--;
    return object;
  }

  @Override
  public int size() {
    return this.size;
  }

  public boolean isEmpty() {
    return (size == 0);
  }

  private class Node {

    Object object;
    Node next;

    Node(Object object) {
      this.object = object;
    }
  }
}
