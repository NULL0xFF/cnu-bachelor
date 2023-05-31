package homework08;

class Complex {

  // Field
  double real;
  double imag;

  // Methods

  /**
   * this.add(target) 메소드
   * <p>
   * this의 복소수에 target의 복소수 값을 더한다
   *
   * @param target
   * @return
   */
  Complex add(Complex target) {
    Complex computing = new Complex();
    computing.real = real + target.real;
    computing.imag = imag + target.imag;
    return computing;
  }

  /**
   * this.minus(target) 메소드
   * <p>
   * this의 복소수에 target의 복소수 값을 뺀다
   *
   * @param target
   * @return
   */
  Complex minus(Complex target) {
    Complex computing = new Complex();
    computing.real = real - target.real;
    computing.imag = imag - target.imag;
    return computing;
  }

  /**
   * this.multiply(target) 메소드
   * <p>
   * this의 복소수와 target의 복소수를 곱한다
   *
   * @param target
   * @return
   */
  Complex multiply(Complex target) {
    /*
     * (a+bi)*(c+di)
     *
     * = (ac-bd)+(ad+bc)i
     */
    Complex computing = new Complex();
    computing.real = real * target.real - imag * target.imag;
    computing.imag = real * target.imag + imag * target.real;
    return computing;
  }

  /**
   * this.divide(target) 메소드
   * <p>
   * this의 복소수를 target의 복소수로 나눈다
   *
   * @param target
   * @return
   */
  Complex divide(Complex target) {
    /*
     * (a+bi)/(c+di)
     *
     * = (ac-ad(i)+cb(i)+bd)/(c^2+d^2)
     *
     * = (ac+bd)/(c^2+d^2)+(bc-ad)i/(c^2+d ^2)
     */
    Complex computing = new Complex();
    computing.real =
        (real * target.real + imag * target.imag) / (Math.pow(target.real, 2) + Math.pow(
            target.imag, 2));
    computing.imag =
        (imag * target.real - real * target.imag) / (Math.pow(target.real, 2) + Math.pow(
            target.imag, 2));
    return computing;
  }

  /**
   * this.printComplex() 메소드
   * <p>
   * this의 복소수를 출력한다
   */
  void printComplex() {
    String realComplex = Double.toString(real);
    String imagComplex = imag + "i";
    if (imag >= 0) {
      System.out.printf("%s+%s\n", realComplex, imagComplex);
    } else {
      System.out.printf("%s%s\n", realComplex, imagComplex);
    }
  }
}

public class TestComplex {

  public static void main(String[] args) {
    Complex num1 = new Complex();
    num1.real = 1.0;
    num1.imag = 1.0;
    System.out.print("num1: ");
    num1.printComplex();

    Complex num2 = new Complex();
    num2.real = 2.5;
    num2.imag = -2.0;
    System.out.print("num2: ");
    num2.printComplex();

    System.out.print("num1 + num2 = ");
    Complex num3 = num1.add(num2);
    num3.printComplex();

    System.out.print("num1 - num2 = ");
    Complex num4 = num1.minus(num2);
    num4.printComplex();

    System.out.print("num1 * num2 = ");
    Complex num5 = num1.multiply(num2);
    num5.printComplex();

    System.out.print("num2 / num1 = ");
    Complex num6 = num2.divide(num1);
    num6.printComplex();
  }
}
