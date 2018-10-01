package Strategies;

import org.jblas.DoubleMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Minimax implements Criteria{

    private DoubleMatrix matrix;

    public Minimax(DoubleMatrix matrix) {
        this.matrix = matrix;
    }

    /**
     * @return Double
     */
    public Double getOptimalSolution() {
        List<Double> minList = new ArrayList<>();
        for (int i = 0; i < matrix.getRows(); i++) {
            minList.add(matrix.getRow(i).min());
        }
        return Collections.max(minList);
    }
}
