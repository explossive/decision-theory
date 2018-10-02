package Strategies;

import helper.MartixHelper;
import org.jblas.DoubleMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sevidg implements Criteria {

    private DoubleMatrix matrix;

    public Sevidg(DoubleMatrix matrix) {
        this.matrix = matrix;
    }

    /**
     * @return Double
     */
    public Double getOptimalSolution() {
        double[][] risk = new double[matrix.getColumns()][matrix.getRows()];
        List<Double> maxList = new ArrayList<>();
        double max;
        for (int i = 0; i < matrix.getColumns(); i++) {
            max = matrix.getColumn(i).max();
            for (int j = 0; j < matrix.getColumn(i).getRows(); j++) {
                risk[i][j] = max - matrix.getColumn(i).getRow(j).scalar();
            }
        }
        DoubleMatrix riskMatrix = (new DoubleMatrix(risk)).transpose();
        for (int i = 0; i < riskMatrix.getRows(); i++) {
            maxList.add(riskMatrix.getRow(i).max());
        }
        return Collections.min(maxList);
    }
}
