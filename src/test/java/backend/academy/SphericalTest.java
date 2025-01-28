package backend.academy;

import backend.academy.models.Point;
import backend.academy.transformations.Linear;
import backend.academy.transformations.Spherical;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SphericalTest {
    @Test
    public void applyTest() {
        Spherical f = new Spherical();
        Point point = new Point(1, 1);
        Point act = f.apply(point);
        assertThat(act.x()).isEqualTo(0.5);
        assertThat(act.y()).isEqualTo(0.5);
    }
}
