package backend.academy;

import backend.academy.models.Point;
import backend.academy.transformations.Sinusoidal;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SinusoidalTest {
    @Test
    public void applyTest() {
        Sinusoidal f = new Sinusoidal();
        Point point = new Point(Math.PI, Math.PI);
        Point act = f.apply(point);
        assertThat(act.x() < 0.00001).isTrue();
        assertThat(act.y() < 0.00001).isTrue();
    }
}
