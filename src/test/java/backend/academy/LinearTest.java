package backend.academy;

import backend.academy.models.Point;
import backend.academy.transformations.Linear;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LinearTest {
    @Test
    public void applyTest() {
        Linear f = new Linear();
        Point point = new Point(1, 1);
        assertThat(f.apply(point).x()).isEqualTo(1);
        assertThat(f.apply(point).y()).isEqualTo(1);
    }
}
