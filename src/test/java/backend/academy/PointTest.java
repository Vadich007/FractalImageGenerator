package backend.academy;

import backend.academy.models.Point;
import backend.academy.models.Rect;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PointTest {
    @Test
    public void rotatePointTest() {
        Point p = new Point(3, 3);
        Rect rect = new Rect(1, 1, 10, 10);
        p.rotatePoint(rect, Math.PI / 2);
        assertThat(p.x()).isEqualTo(9);
        assertThat(p.y()).isEqualTo(3);
    }
}
