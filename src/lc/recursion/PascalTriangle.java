package lc.recursion;

public class PascalTriangle {

    PascalTriangle() {

    }
    /**
     i - row
     j - column
     */
    public static int fieldValue(int i, int j) {
        if (i < 1 || j < 1) {
            throw new IndexOutOfBoundsException("index < 1");
        }
        if (j > i) {
            throw new IndexOutOfBoundsException("column > row");
        }
        return helper(i, j);
    }

    private static int helper(int i, int j) {
        if (j < 1 || j > i) {
            return 0;
        }
        if (j == 1 || j == i) {
            return 1;
        }
        return helper(i - 1, j) + helper(i - 1, j - 1);
    }
}
