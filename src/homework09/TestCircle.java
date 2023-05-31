package homework09;


class Circle {

  private double radius; // 반지름 값(field)
  private double x; // x-좌표 값(field)
  private double y; // y-좌표 값(field)

  /**
   * 생성된 오브젝트(this)의 반지름 값(field) 게터(accesor)
   *
   * @return
   */
  double getRadius() {
    return radius;
  }

  /**
   * 생성된 오브젝트(this)의 반지름 값(field) 세터(mutator)
   *
   * @param input
   */
  void setRadius(double input) {
    radius = (input >= 0) ? input : 0;
  }

  /**
   * 생성된 오브젝트(this)의 x-좌표 값(field) 게터(accesor)
   *
   * @return
   */
  double getX() {
    return x;
  }

  /**
   * 생성된 오브젝트(this)의 x-좌표 값(field) 세터(mutator)
   *
   * @param input
   */
  void setX(double input) {
    x = input;
  }

  /**
   * 생성된 오브젝트(this)의 y-좌표 값(field) 게터(accesor)
   *
   * @return
   */
  double getY() {
    return y;
  }

  /**
   * 생성된 오브젝트(this)의 y-좌표 값(field) 세터(mutator)
   *
   * @param input
   */
  void setY(double input) {
    y = input;
  }

  /**
   * 생성된 오브젝트(this)의 넓이 메소드
   *
   * @return
   */
  double area() {
    return Math.pow(radius, 2) * Math.PI;
  }

}

public class TestCircle {

  public static void main(String[] args) {
    Circle c1 = new Circle();

    c1.setRadius(3.6);
    c1.setX(0.0);
    c1.setY(1.5);

    System.out.println("반지름: " + c1.getRadius());
    System.out.println("중심 좌표: " + "(" + c1.getX() + "," + c1.getY() + ")");
    System.out.printf("넓이: %.2f\n", c1.area());

    Circle c2 = new Circle();

    c2.setRadius(-5.0);
    c2.setX(1.0);
    c2.setY(2.2);

    System.out.println("반지름: " + c2.getRadius());
    System.out.println("중심 좌표: " + "(" + c2.getX() + "," + c2.getY() + ")");
    System.out.printf("넓이: %.2f\n", c2.area());
  }
}
