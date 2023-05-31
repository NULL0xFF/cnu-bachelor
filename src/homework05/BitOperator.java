package homework05;

/**
 * 비트 확인 프로그램 작성
 * <p>
 * int형 정수 15678의 오른쪽 끝에서 세번째 비트와 다섯번째 비트의 값 확인
 * <p>
 * 힌트: & 비트 연산자를 활용한다.
 */
public class BitOperator {

  public static void main(String[] args) {
    // Declaration
    int bitValue = 15678; // 00000000 00000000 00111101 00111110
    int movedValue; // 움직인 bitValue를 담을 변수
    int thirdBit; // 세번째 비트의 값을 담을 변수
    int fifthBit; // 다섯번째 비트의 값을 담을 변수
    // Calculation
    movedValue = (bitValue >> 2); // 오른쪽으로 비트를 2번 이동
    thirdBit = (movedValue & 1);
    movedValue = (bitValue >> 4); // 오른쪽으로 비트를 4번 이동
    fifthBit = (movedValue & 1);
    /**
     * 비트를 오른쪽에서 읽는 다는 가정 하에 x번 이동으로 인해 (x+1)번째 비트가 첫번째 비트가 되었고 이 값을 1과 비트 연산자 AND
     * 처리하면 둘 다 1이여야 1이라는 값을 반환하고 아닐 경우 0을 반환한다
     */
    // Output
    System.out.printf("값 %d의 세번째 비트는 %d이며, 다섯번째 비트는 %d입니다", bitValue, thirdBit, fifthBit);
  }
}