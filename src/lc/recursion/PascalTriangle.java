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
        return helper(i, j, new int[i+1])[0];
    }

    private static int[] helper(int i, int j, int[] p) {
        if (j < 1 || j > i) {
            p[0] = 0;
            return p;
        }
        if (j == 1) {
            p[0] = 1;
            p[i] = 0;
            return p;
        } else if (j == i) {
            p[0] = 1;
            p[i] = 1;
            return p;
        }
        final int r;
        if (p[i] > 0) {
            r = p[i]; // restore left result from previous calls
        } else {
            r = helper(i - 1, j, p)[0]; // go right
        }
        final int l = helper(i - 1, j - 1, p)[0]; //  go left
        p[0] = r + l; // total for current node
        p[i] = l; // store left result
        return p;
    }
}
