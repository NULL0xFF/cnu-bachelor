package homework01;

public class TestMatrix {

  public static void main(String[] args) {
    Matrix mat1 = new Matrix(3, 2);
    mat1.setMatrix(1, -2);
    mat1.setMatrix(3, 4);
    mat1.setMatrix(5, 6);
    Matrix mat2 = new Matrix(2, 3);
    mat2.setMatrix(1, 2, 3);
    mat2.setMatrix(4, 5, 6);
    System.out.println("첫번째 행렬");
    mat1.print();
    System.out.println();
    System.out.println("두번째 행렬");
    mat2.print();
    System.out.println();
    System.out.println("두 행렬의 곱셈");
    mat1.multiMatrix(mat2).print();
    System.out.println();
    System.out.println("첫번째 행렬 + 첫번째 행렬");
    mat1.addMatrix(mat1).print();

    System.out.println();
    System.out.println("두번쩨 행렬의 전치행렬");
    mat2.transposed().print();
  }
}
