package backend.academy.models;

public record Rect(double x, double y, double width, double height) {
    public boolean contains(Point p) {
        return p.x() >= x && p.x() < x + width && p.y() >= y && p.y() < y + height;
    }

    public Point getRandomPoint() {
        return new Point(x + Math.random() * width, y + Math.random() * height);
    }
}
