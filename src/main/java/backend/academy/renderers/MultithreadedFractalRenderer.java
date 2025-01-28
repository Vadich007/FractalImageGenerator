package backend.academy.renderers;

import backend.academy.controller.ApplicationConstants;
import backend.academy.image.FractalImage;
import backend.academy.models.Coefficients;
import backend.academy.models.Rect;
import backend.academy.transformations.Transformation;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.SneakyThrows;

public class MultithreadedFractalRenderer extends BaseFractalRenderer {
    @SneakyThrows
    @Override
    public FractalImage render(FractalImage image, Rect world, List<Transformation> variations, int countOfGen) {
        var executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Coefficients[] coefficients = new Coefficients[ApplicationConstants.AFFIN_COUNT];
        for (int i = 0; i < ApplicationConstants.AFFIN_COUNT; i++) {
            coefficients[i] = new Coefficients();
        }

        for (int i = 0; i < ApplicationConstants.SAMPLE; i++) {
            executorService.execute(() -> renderOneSample(image, world, coefficients, variations, countOfGen));
        }
        executorService.shutdown();
        executorService.awaitTermination(Integer.MAX_VALUE, TimeUnit.SECONDS);

        return image;
    }
}
