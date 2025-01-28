package backend.academy.transformations;

import backend.academy.models.Point;

public class Linear implements Transformation {
    @Override
    public Point apply(Point point) {
        return point;
    }
}
