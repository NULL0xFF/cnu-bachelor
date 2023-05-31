package homework02;

import java.util.Random;

public class MyLinkedList {

  private Node start;

  /**
   * MyLinkedList 생성자
   * <p>
   * 매개변수 s만큼 노드를 추가해서 배열을 생성
   *
   * @param s
   */
  public MyLinkedList(int s) {
    // 예외처리
    if (s <= 0) {
      System.out.print("매개변수의 값은 0 이하가 될 수 없습니다.\n");
      System.exit(1);
    }
    // 변수 선언
    Random random = new Random(); // 랜덤 객체
    Node pointer = this.start = new Node(random.nextInt(s));
    // 배열에 랜덤 값을 가지는 노드 객체를 매개변수 s 만큼 대입
    for (int index = 1; index < s; index++) {
      pointer = pointer.next = new Node(random.nextInt(s));
    }
  }

  /**
   * removemultiples 메소드
   * <p>
   * 매개변수 x의 배수를 배열에서 제거하는 메소드
   *
   * @param x
   */
  public void removemultiples(int x) {
    System.out.printf("removemultiples(%d) 호출\n", x);
    // 예외처리
    if (x == 0) {
      System.out.print("매개변수의 값은 0 이 될 수 없습니다.\n");
      System.exit(2);
    }
    // 배열의 첫번째 값에 대한 처리
    while (start != null) {
      if (start.data % x == 0) {
        start = start.next;
      } else {
        break;
      }
    }
    // 배열이 비어있을 경우에 대한 처리
    if (start == null) {
      return; // 배열이 비어있을 경우 return 으로 종료한다.
    }
    // 배열의 원소들의 값에 대한 처리
    Node pointer = this.start;
    while (pointer.next != null) {
      if (pointer.next.data % x != 0) {
        pointer = pointer.next;
      } else {
        pointer.next = pointer.next.next;
      }
    }
  }

  /**
   * reverse 메소드
   * <p>
   * 배열안 Node 들의 순서를 거꾸로 변경하는 메소드
   */
  public void reverse() {
    System.out.print("reverse() 호출\n");
    if (this.start == null) {
      return;
    }
    Node proNode = new Node(this.start.data);
    Node postNode;
    Node pointer = this.start.next;
    while (pointer != null) {
      postNode = proNode;
      proNode = new Node(pointer.data);
      proNode.next = postNode;
      pointer = pointer.next;
    }
    this.start = proNode;
  }

  public void print() {
    StringBuilder stringBuilder = new StringBuilder("현재 리스트의 구조 : ");
    Node pointer = this.start;
    while (pointer != null) {
      stringBuilder.append(pointer.data);
      if (pointer.next != null) {
        stringBuilder.append(" -> ");
      }
      pointer = pointer.next;
    }
    System.out.printf("%s\n", stringBuilder);
  }

  /**
   * Node 클래스
   */
  private class Node {

    public int data;
    public Node next;

    public Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
