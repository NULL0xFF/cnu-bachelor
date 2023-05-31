package homework06;

public class DLinkedQueue implements Queue {

  private Node head;
  private Node rear;
  private int size = 0;

  @Override
  public void add(Object object) {
    if (empty()) {
      this.head = new Node(null);
      this.rear = new Node(object);
      this.head.prev = this.head.next = this.rear;
      this.rear.prev = this.rear.next = this.head;
    } else {
      Node newNode = new Node(object);
      this.head.next.prev = newNode;
      newNode.next = this.head.next;
      this.head.next = newNode;
      newNode.prev = this.head;
    }
    this.size++;
  }

  @Override
  public Object first() {
    if (empty()) {
      throw new IllegalStateException("the queue is empty");
    }
    return this.rear.object;
  }

  @Override
  public Object remove() {
    if (empty()) {
      throw new IllegalStateException("queue is empty");
    }
    Object object = this.rear.object;
    this.rear = this.rear.prev;
    this.rear.next = this.head;
    this.head.prev = this.rear;
    this.size--;
    return object;
  }

  @Override
  public int size() {
    return this.size;
  }

  public boolean empty() {
    return (size == 0);
  }

  private class Node {

    Object object;
    Node prev;
    Node next;

    Node(Object object) {
      this.object = object;
    }
  }
}
