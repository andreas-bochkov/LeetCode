package ya.contest.aplusb;

import java.util.*;
import java.util.regex.Pattern;

public class ProblemA {

    // multiplication sign
    public static final Pattern MS = Pattern.compile("\\*");
    // addition sign
    public static final Pattern AS = Pattern.compile("\\+");

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);

        boolean[] validRadix = new boolean[36];
        int counter = validRadix.length - 2;

        Arrays.fill(validRadix, true);


        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            final String source = sc.nextLine();
            final String[] split = source.split("=");
            Scanner scl = new Scanner(split[0]);
            Scanner scr = new Scanner(split[1]);

            final String ms = scl.findInLine(MS);

            for (int r = 2; r < validRadix.length; r++) {
                if (validRadix[r]) {
                    if (ms != null) {
                        scl.useDelimiter(MS);
                        scl.useRadix(r);
                        long res = 1L;
                        try {
                            while (scl.hasNext()) {
                                res *= scl.nextLong();
                            }
                            if (res != scr.nextLong(r)) {
                                throw new InputMismatchException();
                            }
                        } catch (InputMismatchException e) {
                            validRadix[r] = false;
                            counter--;
                        }
                    } else {
                        scl.useDelimiter(AS);
                        scl.useRadix(r);
                        long res = 0L;
                        try {
                            while (scl.hasNext()) {
                                res += scl.nextLong();
                            }
                            if (res != scr.nextLong(r)) {
                                throw new InputMismatchException();
                            }
                        } catch (InputMismatchException e) {
                            validRadix[r] = false;
                            counter--;
                        }
                    }
                    scl = new Scanner(split[0]);
                    scr = new Scanner(split[1]);
                }
            }
        }

        if (counter == 0)
        System.out.println(0);
        else if (counter > 1)
            System.out.println(-1);
            else {
            for (int i = 2; i < validRadix.length; i++) {
                if (validRadix[i]) {
                    System.out.println(i);
                    break;
                }
            }

        }
    }
}
