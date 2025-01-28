package backend.academy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private double x;
    private double y;

    public void rotatePoint(Rect rect, double angle) {
        Point center = new Point(rect.x() + rect.width() / 2, rect.y() + rect.height() / 2);
        double buffX = (this.x - center.x()) * Math.cos(angle) - (this.y - center.y()) * Math.sin(angle) + center.x();
        double buffY = (this.x - center.x()) * Math.sin(angle) + (this.y - center.y()) * Math.cos(angle) + center.y();
        this.x = buffX;
        this.y = buffY;
    }
}
