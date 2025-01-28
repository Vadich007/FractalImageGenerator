package backend.academy;

import backend.academy.models.Pixel;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PixelTest {
    @Test
    public void getterTest() {
        Pixel pixel = new Pixel(1, 2, 3, 4, 5);
        assertThat(pixel.r()).isEqualTo(1);
        assertThat(pixel.g()).isEqualTo(2);
        assertThat(pixel.b()).isEqualTo(3);
        assertThat(pixel.hitCount()).isEqualTo(4);
        assertThat(pixel.normal()).isEqualTo(5);
    }

    @Test
    public void setterTest() {
        Pixel pixel = new Pixel();
        pixel.r(1);
        pixel.g(2);
        pixel.b(3);
        pixel.hitCount(4);
        pixel.normal(5);
        assertThat(pixel.r()).isEqualTo(1);
        assertThat(pixel.g()).isEqualTo(2);
        assertThat(pixel.b()).isEqualTo(3);
        assertThat(pixel.hitCount()).isEqualTo(4);
        assertThat(pixel.normal()).isEqualTo(5);
    }
}
