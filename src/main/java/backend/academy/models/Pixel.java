package backend.academy.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pixel {
    private int r;
    private int g;
    private int b;
    private int hitCount = 0;
    private double normal;
}
