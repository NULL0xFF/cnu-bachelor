package homework02;

public class LinkedListTest {

  public static void main(String[] args) {
    MyLinkedList myLinkedList = new MyLinkedList(10);
    myLinkedList.print();
    myLinkedList.print();
    myLinkedList.removemultiples(3);
    myLinkedList.print();
    myLinkedList.print();
    myLinkedList.reverse();
    myLinkedList.print();
  }
}
