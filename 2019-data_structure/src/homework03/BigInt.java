package homework03;

public class BigInt {

  private final Node start;

  public BigInt(int n) {
    if (n < 0) {
      throw new IllegalArgumentException(n + " <0");
    }
    this.start = new Node(n % 10);
    Node p = this.start;
    n /= 10;
    while (n > 0) {
      p = p.next = new Node(n % 10);
      n /= 10;
    }
  }

  public BigInt(String s) {
    if (s.length() == 0) {
      throw new IllegalArgumentException("empty string");
    }
    this.start = new Node(digit(s, s.length() - 1));
    Node p = this.start;
    for (int i = s.length() - 2; i >= 0; i--) {
      p = p.next = new Node(digit(s, i));
    }
  }

  /**
   * @param y
   * @return
   */
  public int compareMe(BigInt y) {
    // 변수 선언
    Node xPointer = this.start; // 자신을 참조
    Node yPointer = y.start; // 매개변수를 참조
    int result = 0; // 출력값
    // 포인터가 null이 될 경우는 숫자가 없을 때이다.
    // 그렇기 때문에 두 포인터 중 하나라도 null이 될 때
    // 나머지 포인터의 참조의 값이 크거나
    // 두 포인터 모두 null일 경우를 처리해야 한다.
    while (xPointer != null && yPointer != null) {
      if (xPointer.data > yPointer.data) {
        result = 1;
      } else if (xPointer.data < yPointer.data) {
        result = -1;
      } else if (result == 0) {
        result = 0;
      }
      // next로 포인터 이동
      xPointer = xPointer.next;
      yPointer = yPointer.next;
    }
    if (xPointer == null && yPointer != null) {
      result = -1;
    } else if (xPointer != null && yPointer == null) {
      result = 1;
    }
    return result;
  }

  /**
   * @param k
   * @return
   */
  public BigInt multiple(int k) {
    // 변수 선언 및 초기화
    Node pointer = this.start;
    Node header = new Node((pointer.data * k) % 10);
    Node headerPointer = header;
    int complement = (pointer.data * k) / 10;
    pointer = pointer.next;
    //
    while (pointer != null) {
      headerPointer.next = new Node(((pointer.data * k) + complement) % 10);
      complement = ((pointer.data * k) + complement) / 10;
      headerPointer = headerPointer.next;
      pointer = pointer.next;
    }
    //
    while (complement != 0) {
      headerPointer.next = new Node(complement % 10);
      complement = complement / 10;
      headerPointer = headerPointer.next;
    }
    // StringBuilder 를 이용해 BigInt의 값을 저장할 객체변수 선언 및 초기회
    StringBuilder stringBuilder = new StringBuilder();
    // BigInt 객체의 값들을 가리킬 포인터 객체 생성 (Node) 및 초기화
    headerPointer = header;
    while (headerPointer != null) {
      stringBuilder.insert(0, headerPointer.data);
      headerPointer = headerPointer.next;
    }
    return new BigInt(stringBuilder.toString());
  }

  @Override
  public String toString() {
    // StringBuilder 를 이용해 BigInt의 값을 저장할 객체변수 선언 및 초기회
    StringBuilder stringBuilder = new StringBuilder();
    // BigInt 객체의 값들을 가리킬 포인터 객체 생성 (Node) 및 초기화
    Node pointer = this.start;
    while (pointer != null) {
      stringBuilder.insert(0, pointer.data);
      pointer = pointer.next;
    }
    stringBuilder.insert(0, "현재 리스트의 구조 : ");
    return stringBuilder.toString();
  }

  private int digit(String s, int i) {
    String ss = s.substring(i, i + 1);
    return Integer.parseInt(ss);
  }

  /**
   * Node 클래스
   */
  private class Node {

    int data;
    Node next;

    Node(int data) {
      this.data = data;
      this.next = null;
    }
  }
}
