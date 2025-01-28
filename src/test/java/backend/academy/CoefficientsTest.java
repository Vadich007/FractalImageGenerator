package backend.academy;

import backend.academy.models.Coefficients;
import backend.academy.models.Pixel;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CoefficientsTest {
    @Test
    public void setterTest() {
        Coefficients coefficients = new Coefficients();
        coefficients.a(1);
        coefficients.b(2);
        coefficients.c(3);
        coefficients.d(4);
        coefficients.e(5);
        coefficients.f(6);
        coefficients.red(7);
        coefficients.green(8);
        coefficients.blue(9);

        assertThat(coefficients.a()).isEqualTo(1);
        assertThat(coefficients.b()).isEqualTo(2);
        assertThat(coefficients.c()).isEqualTo(3);
        assertThat(coefficients.d()).isEqualTo(4);
        assertThat(coefficients.e()).isEqualTo(5);
        assertThat(coefficients.f()).isEqualTo(6);
        assertThat(coefficients.red()).isEqualTo(7);
        assertThat(coefficients.green()).isEqualTo(8);
        assertThat(coefficients.blue()).isEqualTo(9);
    }
}
