package backend.academy.transformations;

import backend.academy.models.Point;

public class Spherical implements Transformation {
    @Override
    public Point apply(Point point) {
        double rSquare = point.x() * point.x() + point.y() * point.y();
        return new Point(point.x() / rSquare, point.y() / rSquare);
    }
}
