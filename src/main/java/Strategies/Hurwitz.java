package Strategies;

import org.jblas.DoubleMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hurwitz implements Criteria{

    private DoubleMatrix matrix;
    private Double multiplier;

    public Hurwitz(DoubleMatrix matrix, Double multiplier) {
        this.matrix = matrix;
        this.multiplier = multiplier;
    }

    /**
     * @return Double
     */
    public Double getOptimalSolution() {
        List<Double> values = new ArrayList<>();
        double max;
        double min;
        for (int i = 0; i < matrix.getRows(); i++) {
            max = matrix.getRow(i).max();
            min = matrix.getRow(i).min();
            values.add(multiplier * min + (1 - multiplier) * max);
        }
        return Collections.max(values);
    }

}
