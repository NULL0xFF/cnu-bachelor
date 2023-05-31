package homework01;

import java.util.Random;

public class MyArray {

  private int[] a;
  private int size;

  /**
   * 배열 실습을 위한 MyArray 클래스 생성자
   * <p>
   * 배열의 크기(size)를 매개변수(s)로 받는다.
   *
   * @param s
   */
  public MyArray(int s) {
    // 변수 초기화
    this.a = new int[s];
    this.size = s;
    // 0 부터 배열의 크기(this.size) 사이의 난수를 배열에 대입
    Random random = new Random();
    for (int index = 0; index < size; index++) {
      this.a[index] = random.nextInt(this.size);
    }
    System.out.print("생성된 배열 a는 다음과 같습니다.\n");
    this.print();
  }

  /**
   * 특정 정수의 배수를 배열에서 제거하는 메소드
   * <p>
   * 특정 정수를 매개변수(x)로 받는다.
   *
   * @param x
   */
  public void removemultiples(int x) {
    // 변수 초기화
    int[] tempArray = new int[this.a.length]; // 처리된 배열을 저장하기 위한 변수
    int count = 0;
    System.out.printf("배열 a에서 %d의 배수를 모두 제거합니다.\n", x);
    for (int index = 0; index < this.a.length; index++) {
      if (this.a[index] == 0 || this.a[index] % x != 0) {
        // 해당하지 않는 원소를 배열에 대입
        tempArray[index - count] = this.a[index];
      } else {
        // 삭제된 배열의 원소만큼 배열에 저장된 원소 개수 변수를 조정
        count++;
        this.size--;
      }
    }
    // 처리된 배열을 본 배열(this.a)에 대입
    this.a = tempArray;
    this.print();
  }

  /**
   * 배열(this.a)의 크기(this.size)를 두배로 늘리는 메소드
   */
  public void doublelength() {
    // 변수 초기화
    int[] newArray = new int[this.a.length * 2]; // 새로운 배열을 두배의 크기로 선언
    System.out.print("배열 a의 공간을 두 배 확장합니다.\n");
    this.print();
    // 새로운 배열에 기존 배열(this.a)을 arraycopy 메소드를 이용해 복사
    System.arraycopy(this.a, 0, newArray, 0, this.a.length);
    // 기존 배열을 새로운 배열으로 변경
    this.a = newArray;
    this.print();
  }

  /**
   * 배열을 출력하는 메소드
   */
  public void print() {
    // 배열을 문자열로 저장할 변수 선언
    StringBuilder arrayString = new StringBuilder();
    // 배열 원소를 for-each 문으로 문자열에 추가
    for (int index = 0; index < this.size; index++) {
      arrayString.append(this.a[index]);
      arrayString.append(" ");
    }
    // 배열 출력
    System.out.printf("배열의 원소 : %s| 배열의 크기 : %d\n", arrayString, this.a.length);
  }
}
