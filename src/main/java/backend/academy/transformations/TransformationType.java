package backend.academy.transformations;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TransformationType {
    LINEAR(new Linear()),
    SINUSOIDAL(new Sinusoidal()),
    SPHERICAL(new Spherical()),
    HORSESHOE(new Horseshoe()),
    HEARD(new Heart()),
    EXPONENTIAL(new Exponential());

    public final Transformation transformation;
}
