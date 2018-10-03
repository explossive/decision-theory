package Strategies;

import helper.MartixHelper;
import org.jblas.DoubleMatrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MercedesCalculator {

    Double priceGood = 49_000.00;

    Double priceBad = 15_000.00;

    Double expenses = 25_000.00;

    Integer[] count = {100, 150, 200, 250, 300};

    private DoubleMatrix probabilities;

    public MercedesCalculator(DoubleMatrix probabilities) {
        this.probabilities = probabilities;
    }


    public DoubleMatrix getProfitMatrix() {
        double[][] profit = new double[count.length][count.length];
        int d;
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count.length; j++) {
                d = count[i] - count[j];
                if (d < 0) d = 0;
                profit[i][j] = priceGood * (count[i] - d) + priceBad * d - expenses * count[i];
            }
        }
        return new DoubleMatrix(profit);
    }


}
