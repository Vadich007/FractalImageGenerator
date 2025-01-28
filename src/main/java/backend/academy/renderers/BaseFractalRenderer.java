package backend.academy.renderers;

import backend.academy.controller.ApplicationConstants;
import backend.academy.image.FractalImage;
import backend.academy.models.Coefficients;
import backend.academy.models.Pixel;
import backend.academy.models.Point;
import backend.academy.models.Rect;
import backend.academy.transformations.Transformation;
import java.util.List;

public abstract class BaseFractalRenderer {
    public abstract FractalImage render(
        FractalImage image,
        Rect world,
        List<Transformation> variations,
        int countOfGen
    );

    @SuppressWarnings("NestedIfDepth")
    protected void renderOneSample(
        FractalImage image,
        Rect world,
        Coefficients[] coefficients,
        List<Transformation> variations,
        int countOfGen
    ) {
        Point currPoint = world.getRandomPoint();
        for (int j = -ApplicationConstants.SKIP_ITER; j < countOfGen; j++) {
            Coefficients currCoefficients = coefficients[(int) Math.floor(Math.random() * coefficients.length)];
            Transformation transform = variations.get((int) (Math.random() * variations.size()));

            double x =
                currCoefficients.a() * currPoint.x() + currCoefficients.b() * currPoint.y() + currCoefficients.c();
            double y =
                currCoefficients.d() * currPoint.x() + currCoefficients.e() * currPoint.y() + currCoefficients.f();

            currPoint = transform.apply(new Point(x, y));

            if (j > 0) {
                double theta = 0.0;
                for (int s = 0; s < ApplicationConstants.SYMMETRY; s++) {
                    theta += (2 * Math.PI) / ApplicationConstants.SYMMETRY;
                    Point point = new Point(currPoint.x(), currPoint.y());
                    point.rotatePoint(world, theta);

                    if (world.contains(currPoint)) {
                        point.x((int) ((point.x() - world.x()) / world.width() * image.width()));
                        point.y((int) ((point.y() - world.y()) / world.height() * image.height()));

                        if (image.contains(point)) {
                            Pixel pixel = image.data()[(int) point.x()][(int) point.y()];

                            synchronized (pixel) {
                                if (pixel.hitCount() == 0) {
                                    pixel.r(currCoefficients.red());
                                    pixel.g(currCoefficients.green());
                                    pixel.b(currCoefficients.blue());
                                } else {
                                    pixel.r((currCoefficients.red() + pixel.r()) / 2);
                                    pixel.g((currCoefficients.green() + pixel.g()) / 2);
                                    pixel.b((currCoefficients.blue() + pixel.b()) / 2);
                                }
                                pixel.hitCount(pixel.hitCount() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    public FractalImage correction(FractalImage image) {
        double max = 0;
        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                if (image.data()[i][j].hitCount() != 0) {
                    image.data()[i][j].normal(Math.log10(image.data()[i][j].hitCount()));
                    max = Math.max(image.data()[i][j].normal(), max);
                }
            }
        }

        for (int i = 0; i < image.width(); i++) {
            for (int j = 0; j < image.height(); j++) {
                image.data()[i][j].normal(image.data()[i][j].normal() / max);
                image.data()[i][j].r(
                    (int) (image.data()[i][j].r()
                        * Math.pow(image.data()[i][j].normal(), 1.0 / ApplicationConstants.GAMMA)));
                image.data()[i][j].g(
                    (int) (image.data()[i][j].g()
                        * Math.pow(image.data()[i][j].normal(), 1.0 / ApplicationConstants.GAMMA)));
                image.data()[i][j].b(
                    (int) (image.data()[i][j].b()
                        * Math.pow(image.data()[i][j].normal(), 1.0 / ApplicationConstants.GAMMA)));
            }
        }
        return image;
    }
}
