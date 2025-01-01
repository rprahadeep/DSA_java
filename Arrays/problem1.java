// set matrix zeroes
// leetcode 73

public class problem1 {
  public static void main(String[] args) {
    int[][] matrix = { { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 1 } };

    int rows = matrix.length;
    int columns = matrix[0].length;

    boolean ro = false;
    boolean co = false;

    // check if first row contains zero
    for (int c = 0; c < columns; c++) {
      if (matrix[0][c] == 0) {
        ro = true;
        break;
      }
    }

    // check if first column contains zero
    for (int r = 0; r < rows; r++) {
      if (matrix[r][0] == 0) {
        co = true;
        break;
      }
    }

    // use first row and col as markers
    for (int r = 1; r < rows; r++) {
      for (int c = 1; c < columns; c++) {
        if (matrix[r][c] == 0) {
          matrix[0][c] = 0;
          matrix[r][0] = 0;
        }
      }
    }

    // Set the marked rows to zero
    for (int r = 1; r < rows; r++) {
      if (matrix[r][0] == 0) {
        for (int c = 1; c < columns; c++) {
          matrix[r][c] = 0;
        }
      }
    }

    // Set the marked columns to zero
    for (int c = 1; c < columns; c++) {
      if (matrix[0][c] == 0) {
        for (int r = 1; r < rows; r++) {
          matrix[r][c] = 0;
        }
      }
    }

    // Set the first row to zero if needed
    if (ro) {
      for (int c = 0; c < columns; c++) {
        matrix[0][c] = 0;
      }
    }

    // Set the first column to zero if needed
    if (co) {
      for (int r = 0; r < rows; r++) {
        matrix[r][0] = 0;
      }
    }

    for (int r = 0; r < rows; r++) {
      for (int c = 0; c < columns; c++) {
        System.out.print(matrix[r][c] + " ");
      }
      System.out.println();
    }
  }
}