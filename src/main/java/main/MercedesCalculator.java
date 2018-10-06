package main;

import org.jblas.DoubleMatrix;

import java.util.*;

public class MercedesCalculator {

    private DoubleMatrix profitMatrix;

    public DoubleMatrix getProfitMatrix() {
        if (null != profitMatrix) {
            return profitMatrix;
        }
        profitMatrix = calculateProfitMatrix();
        return profitMatrix;
    }

    public MercedesCalculatorDto getOptimalSolution() {
        Map<Integer, Double> optimal = new HashMap<>();
        List<Integer> countOrder = Arrays.asList(100, 150, 200, 250, 300);
        double optimalRow;
        int n;
        double column;
        DoubleMatrix pm = getProfitMatrix();
        for (int i = 0; i < pm.getRows(); i++) {
            n = 0;
            optimalRow = 0.0;
            for (Map.Entry<Integer, Double> entry : Main.probability.entrySet()) {
                column = pm.getRow(i).getColumn(n++).scalar();
                optimalRow = optimalRow + (column * entry.getValue());
            }
            optimal.put(countOrder.get(i), optimalRow);
        }
        Map.Entry<Integer, Double> maxEntry = null;
        for (Map.Entry<Integer, Double> entry : optimal.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        MercedesCalculatorDto mercedesCalculatorDto = new MercedesCalculatorDto();
        assert maxEntry != null;
        mercedesCalculatorDto.optimalSolution = maxEntry.getValue();
        mercedesCalculatorDto.optimalOrderSize = maxEntry.getKey();
        return mercedesCalculatorDto;
    }

    private DoubleMatrix calculateProfitMatrix() {
        double[][] profit = new double[Main.count.length][Main.count.length];
        int d;
        for (int i = 0; i < Main.count.length; i++) {
            for (int j = 0; j < Main.count.length; j++) {
                d = Main.count[i] - Main.count[j];
                if (d < 0) d = 0;
                profit[i][j] = Main.priceGood * (Main.count[i] - d) + Main.priceBad * d - Main.expenses * Main.count[i];
            }
        }
        return new DoubleMatrix(profit);
    }
}
