package de.buschbaum.uli.quadratzahlen;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        double z = 145;
        double l = 0;
        double r = z;
        double x;
        double eps = 1.0E-14;

        while (r - l > eps) {
            double m = 0.5 * (l + r);
            x = m;
            
            System.out.println("l : " + l + "\t m: " + m + "\t r: " + r);

            double xsquare = x * x;
            
            if (xsquare > z) {
                r = m;
            } else {
                l = m;
            }
        }
    }
}
