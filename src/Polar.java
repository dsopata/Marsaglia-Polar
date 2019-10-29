import java.io.FileNotFoundException;
import java.io.PrintStream;

import static java.lang.Math.log;
import static java.lang.Math.random;
import static java.lang.Math.sqrt;

public class Polar {
    private static final int POINTS_AMOUNT = (int) 1E10;

    private static Point polar() {
        Double x = (random()*2) - 1;
        Double y = (random()*2) - 1;
        Double s = x*x + y*y;
        if(s < 1) {
            Double t1 = sqrt((-2) * log(s)/s);
            return new Point(x*t1, y*t1);
        }

        return null;
    }

    public static class Point {
        Double x;
        Double y;

        public Point(Double x, Double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return  x + "," + y;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        PrintStream fileOut = new PrintStream("./out.csv");
        System.setOut(fileOut);

        for (int a = 0; a < POINTS_AMOUNT; a++) {
            Point polarPoint = polar();
            if(polarPoint != null) {
                System.out.println(polarPoint);
            }
        }


    }
}
