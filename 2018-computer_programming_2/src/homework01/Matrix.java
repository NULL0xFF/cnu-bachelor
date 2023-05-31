package homework01;

public class Matrix {

  private final int row;
  private final int col;
  public double[][] matrix;
  private int invRow = 0;

  public Matrix(int row, int col) {
    if (row < 1 || col < 1) {
      throw new NegativeArraySizeException("Negative size of row or column");
    }
    this.row = row;
    this.col = col;
    this.matrix = new double[row][col];
  }

  public void setMatrix(double... ds) {
    if (ds.length > this.col) {
      throw new ArrayIndexOutOfBoundsException("Too many columns than the maximum of Matrix-Array");
    }
    if (invRow < row) {
      this.matrix[invRow] = ds;
      this.invRow++;
    } else {
      throw new ArrayIndexOutOfBoundsException("Exceeded maximum available rows");
    }
  }

  public Matrix addMatrix(Matrix otherMatrix) {
    if (this.row != otherMatrix.row || this.col != otherMatrix.col) {
      throw new RuntimeException("Size of two matrices are not identical");
    }
    Matrix outputMatrix = new Matrix(this.row, this.col);
    for (int rowLoop = 0; rowLoop < this.row; rowLoop++) {
      for (int colLoop = 0; colLoop < this.col; colLoop++) {
        outputMatrix.matrix[rowLoop][colLoop] =
            this.matrix[rowLoop][colLoop] + otherMatrix.matrix[rowLoop][colLoop];
      }
    }
    return outputMatrix;
  }

  public Matrix multiMatrix(Matrix otherMatrix) {
    if (this.col != otherMatrix.row) {
      throw new RuntimeException(
          "The number of first column is not equal to the number of second row");
    }
    Matrix outputMatrix = new Matrix(this.row, otherMatrix.col);
    for (int m = 0; m < this.row; m++) {
      for (int p = 0; p < otherMatrix.col; p++) {
        double result = 0;
        for (int k = 0; k < this.col; k++) {
          result = result + this.matrix[m][k] * otherMatrix.matrix[k][p];
        }
        outputMatrix.matrix[m][p] = result;
      }
    }
    return outputMatrix;
  }

  public Matrix transposed() {
    Matrix outputMatrix = new Matrix(this.col, this.row);
    for (int rowLoop = 0; rowLoop < this.col; rowLoop++) {
      for (int colLoop = 0; colLoop < this.row; colLoop++) {
        outputMatrix.matrix[rowLoop][colLoop] = this.matrix[colLoop][rowLoop];
      }
    }
    return outputMatrix;
  }

  @Override
  public String toString() {
    String returnString = "";
    returnString = returnString + "[";
    for (int loop1 = 0; loop1 < row; loop1++) {
      returnString = returnString + "[";
      for (int loop2 = 0; loop2 < col; loop2++) {
        returnString = returnString + String.format("%.1f", this.matrix[loop1][loop2]);
        if (loop2 + 1 < col) {
          returnString = returnString + ", ";
        }
      }
      returnString = returnString + "]";
      if (loop1 + 1 < row) {
        returnString = returnString + "\n ";
      }
    }
    returnString = returnString + "]";
    return returnString;
  }

  public void print() {
    System.out.println(this);
  }
}