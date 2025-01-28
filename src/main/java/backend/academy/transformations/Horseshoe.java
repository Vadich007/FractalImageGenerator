package backend.academy.transformations;

import backend.academy.models.Point;

public class Horseshoe implements Transformation {
    @Override
    public Point apply(Point point) {
        double rSquare = point.x() * point.x() + point.y() * point.y();
        double x = (point.x() - point.y()) * (point.x() + point.y()) / rSquare;
        double y = 2 * point.x() * point.y();
        return new Point(x, y);
    }
}
