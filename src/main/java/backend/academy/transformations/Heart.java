package backend.academy.transformations;

import backend.academy.models.Point;

public class Heart implements Transformation {
    @Override
    public Point apply(Point point) {
        double x = point.x();
        double y = point.y();
        double r = Math.sqrt(x * x + y * y);
        double a = r * Math.atan(y / x);
        return new Point(r * Math.sin(a), -r * Math.cos(a));
    }
}
