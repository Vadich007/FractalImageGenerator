package backend.academy.renderers;

import backend.academy.controller.ApplicationConstants;
import backend.academy.image.FractalImage;
import backend.academy.models.Coefficients;
import backend.academy.models.Rect;
import backend.academy.transformations.Transformation;
import java.util.List;

public class OneThreadFractalRenderer extends BaseFractalRenderer {
    public FractalImage render(FractalImage image, Rect world, List<Transformation> variations, int countOfGen) {
        Coefficients[] coefficients = new Coefficients[ApplicationConstants.AFFIN_COUNT];
        for (int i = 0; i < ApplicationConstants.AFFIN_COUNT; i++) {
            coefficients[i] = new Coefficients();
        }

        for (int i = 0; i < ApplicationConstants.SAMPLE; i++) {
            renderOneSample(image, world, coefficients, variations, countOfGen);
        }

        return image;
    }
}
