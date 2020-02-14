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
        return helper(i, j, 0)[0];
    }

    private static int[] helper(int i, int j, int p) {
        if (j < 1 || j > i) {
            return new int[] {0, 0};
        }
        if (j == 1) {
            return new int[]{1, 0};
        } else if (j == i) {
            return new int[]{1, 1};
        }
        final int[] r = helper(i - 1, j, p);
        final int[] l = helper(i - 1, j - 1, r[1]);
        return new int[] {r[0] + l[0], l[0]};
    }
}
