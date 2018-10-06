package main.Strategies;

import org.jblas.DoubleMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hurwitz implements Criteria {

    private DoubleMatrix matrix;
    private Double c;

    public Hurwitz(DoubleMatrix matrix, Double c) {
        this.matrix = matrix;
        this.c = c;
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
            values.add(c * min + (1 - c) * max);
        }
        return Collections.max(values);
    }

}
