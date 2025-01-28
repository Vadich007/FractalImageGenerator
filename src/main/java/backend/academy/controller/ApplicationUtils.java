package backend.academy.controller;

import backend.academy.image.FractalImage;
import backend.academy.image.ImageFormat;
import backend.academy.image.ImageUtils;
import backend.academy.models.Rect;
import backend.academy.renderers.BaseFractalRenderer;
import backend.academy.renderers.MultithreadedFractalRenderer;
import backend.academy.renderers.OneThreadFractalRenderer;
import backend.academy.transformations.Transformation;
import backend.academy.transformations.TransformationType;
import java.io.IOException;
import java.io.PrintStream;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ApplicationUtils {
    private Scanner scanner;
    private PrintStream ps;
    private FractalImage image;
    private int countOfGen;
    private List<Transformation> transformations;
    private BaseFractalRenderer renderer;
    private ImageFormat imageFormat;
    private Rect rect;

    public ApplicationUtils() {
        ps = new PrintStream(System.out);
        scanner = new Scanner(System.in);
        transformations = new ArrayList<>();
        rect = new Rect(ApplicationConstants.RECT_X, ApplicationConstants.RECT_Y, ApplicationConstants.RECT_W,
            ApplicationConstants.RECT_H);
    }

    public void start() {
        try {
            initMainInfo();
            image = renderer.render(image, rect, transformations, countOfGen);
            image = renderer.correction(image);
            ImageUtils.save(image, ApplicationConstants.SAVE_FILE + imageFormat.toString().toLowerCase(), imageFormat);
        } catch (NumberFormatException e) {
            log.error("Некорректный ввод данных, введите число удовлетворяющее условию", e);
        } catch (InvalidParameterException e) {
            log.error("Введено слишком большой число", e);
        } catch (ArrayIndexOutOfBoundsException e) {
            log.error("Неправильный формат ввода размера изображения (пример: 1920 1080) ", e);
        } catch (IOException e) {
            log.error("Во время сохранения изображения возникла ошибка", e);
        } finally {
            ps.close();
            scanner.close();
        }
    }

    private void initMainInfo() throws NumberFormatException, InvalidParameterException {
        initImageSize();
        initCountOfGeneration();
        initTransformations();
        initImageFormat();
        initRendererVersion();
    }

    private void initImageFormat() {
        for (var transformation : ImageFormat.values()) {
            ps.println(transformation.ordinal() + " " + transformation);
        }
        ps.println("Выберите формат изображения");

        imageFormat = ImageFormat.values()[Integer.parseInt(scanner.nextLine())];
    }

    private void initTransformations() {
        for (var transformation : TransformationType.values()) {
            ps.println(transformation.ordinal() + " " + transformation);
        }
        ps.println("Выберите функции трансформации(по окончании ввода напишите -1)");

        int currTransformation = Integer.parseInt(scanner.nextLine());
        while (currTransformation != -1) {
            transformations.add(TransformationType.values()[currTransformation].transformation);
            currTransformation = Integer.parseInt(scanner.nextLine());
        }
    }

    private void initCountOfGeneration() {
        ps.println("Введите количество итераций (не более " + ApplicationConstants.MAX_ITERATION + ")");

        countOfGen = Integer.parseInt(scanner.nextLine());

        if (countOfGen > ApplicationConstants.MAX_ITERATION || countOfGen <= 0) {
            throw new InvalidParameterException();
        }
    }

    private void initImageSize() {
        ps.println("Введите размер изображения \"ширина\" \"высота\" (не более" + ApplicationConstants.MAX_WIDTH + "х"
            + ApplicationConstants.MAX_HEIGHT + ")");
        var sizes = scanner.nextLine().split(" ");
        int width = Integer.parseInt(sizes[0]);
        int height = Integer.parseInt(sizes[1]);

        if (width > ApplicationConstants.MAX_WIDTH || height > ApplicationConstants.MAX_HEIGHT) {
            throw new InvalidParameterException();
        }

        image = new FractalImage(width, height);
    }

    private void initRendererVersion() {
        ps.println("1 - Однопоточная версия" + System.lineSeparator()
            + "2 - Многопоточная версия");

        int version = Integer.parseInt(scanner.nextLine());

        if (version == 1) {
            renderer = new OneThreadFractalRenderer();
        } else if (version == 2) {
            renderer = new MultithreadedFractalRenderer();
        } else {
            throw new InvalidParameterException();
        }
    }
}
