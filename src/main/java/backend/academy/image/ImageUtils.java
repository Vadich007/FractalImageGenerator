package backend.academy.image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import lombok.experimental.UtilityClass;

@UtilityClass
public final class ImageUtils {
    public static void save(FractalImage image, String filename, ImageFormat format) throws IOException {
        BufferedImage res = new BufferedImage(image.width(), image.height(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < image.height(); i++) {
            for (int j = 0; j < image.width(); j++) {
                Color color = new Color(image.data()[j][i].r(), image.data()[j][i].g(), image.data()[j][i].b());
                res.setRGB(j, i, color.getRGB());
            }
        }
        var file = new File(filename);
        file.createNewFile();
        ImageIO.write(res, format.name().toLowerCase(), file);
    }
}
