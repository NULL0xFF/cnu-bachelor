package homework11;

import java.util.Scanner;

public class TheaterReservation {

  public static void main(String[] args) {
    // 선언
    Scanner io_scanner = new Scanner(System.in);
    int[] reservedSeat = new int[10];

    do {
      System.out.print("좌석을 예약하시겠습니까?(1 또는 0)\t");

      if (io_scanner.nextInt() == 0) {
        break;
      }

      System.out.print("현재의 예약 상태는 다음과 같습니다.\n");
      System.out.print("-----------------------\n");
      System.out.print("1 2 3 4 5 6 7 8 9 10\n");
      System.out.print("-----------------------\n");

      for (int value : reservedSeat) {
        System.out.printf("%d ", value);
      }

      System.out.print("\n");

      do {
        System.out.print("몇번째 좌석을 예약하시겠습니까?(1~10)\t");

        int selectedSeat = io_scanner.nextInt() - 1;

        if (selectedSeat >= 0 && selectedSeat <= 9 && reservedSeat[selectedSeat] == 0) {
          reservedSeat[selectedSeat] = 1;

          System.out.print("예약 되었습니다.\n");

          break;
        }

        System.out.print("잘못된 입력입니다.\t다시 입력해 주세요.\n");
      } while (true);
    } while (true);

    io_scanner.close();
  }
}
