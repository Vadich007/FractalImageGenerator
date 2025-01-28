package backend.academy.image;

import backend.academy.models.Pixel;
import backend.academy.models.Point;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FractalImage {
    private Pixel[][] data;
    private int width;
    private int height;

    public FractalImage(int width, int height) {
        this.width = width;
        this.height = height;
        data = new Pixel[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                data[i][j] = new Pixel();
            }
        }
    }

    public boolean contains(Point point) {
        return point.x() >= 0 && point.y() >= 0 && point.x() < width && point.y() < height;
    }
}
