package backend.academy.models;

import lombok.Getter;
import lombok.Setter;
import static backend.academy.controller.ApplicationConstants.MAX_COLOR;

@Getter
@Setter
public class Coefficients {
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;
    private int red;
    private int green;
    private int blue;

    public Coefficients() {
        do {
            do {
                a = Math.random() * 2 - 1;
                d = Math.random() * 2 - 1;
            } while (a * a + d * d >= 1);

            do {
                b = Math.random() * 2 - 1;
                e = Math.random() * 2 - 1;
            } while (b * b + e * e >= 1);
        } while (a * a + d * d + b * b + e * e >= 1 + Math.pow(a * e - b * d, 2));

        f = Math.random() * 2 - 1;
        c = Math.random() * 2 - 1;
        red = (int) (Math.random() * MAX_COLOR);
        green = (int) (Math.random() * MAX_COLOR);
        blue = (int) (Math.random() * MAX_COLOR);
    }
}
