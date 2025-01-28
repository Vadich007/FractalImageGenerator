package backend.academy;

import backend.academy.models.Point;
import backend.academy.models.Rect;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RectTest {
    @Test
    public void containTest() {
        Point p = new Point(3, 3);
        Rect rect = new Rect(1, 1, 10, 10);
        assertThat(rect.contains(p)).isTrue();
    }

    @Test
    public void getRandomPointTest() {
        Rect rect = new Rect(1, 1, 10, 10);
        Point p = rect.getRandomPoint();
        assertThat(rect.contains(p)).isTrue();
    }
}
