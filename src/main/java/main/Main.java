package main;

import main.criteria.Criteria;
import main.criteria.Hurwitz;
import main.criteria.Minimax;
import main.criteria.Sevidg;
import main.helper.MartixHelper;
import org.jblas.DoubleMatrix;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public class Main {

    private final static double c = 0.11;

    public static final Double priceGood = 49_000.00;

    public static final Double priceBad = 15_000.00;

    public static final Double expenses = 25_000.00;

    public static final Integer[] count = {100, 150, 200, 250, 300};

    public static final Map<Integer, Double> probability = new HashMap<Integer, Double>();

    static {
        probability.put(100, 0.05);
        probability.put(150, 0.15);
        probability.put(200, 0.35);
        probability.put(250, 0.25);
        probability.put(300, 0.2);
    }

    /**
     * @return DoubleMatrix
     */
    private static DoubleMatrix getMatrix() {
        return new DoubleMatrix(new double[][]{
                {15, 10, 0, -6, 17},
                {3, 14, 8, 9, 2},
                {1, 5, 14, 20, -3},
                {7, 19, 10, 2, 0}
        });
    }

    public static void main(String[] args) {
        DoubleMatrix matrix = getMatrix();
        Criteria minimax = new Minimax(matrix);
        System.out.println("Минимаксный критерий:");
        System.out.println(minimax.getOptimalSolution());
        System.out.println("Критерий Гурвица:");
        Criteria hurwitz = new Hurwitz(matrix, c);
        System.out.println(hurwitz.getOptimalSolution());
        System.out.println("Критерий Сэвиджа:");
        Criteria sevidg = new Sevidg(matrix);
        System.out.println(sevidg.getOptimalSolution());
        System.out.println("===========================");
        MercedesCalculator mercedesCalculator = new MercedesCalculator();
        System.out.println("Матрица прибыли");
        MartixHelper.printMatrix(mercedesCalculator.getProfitMatrix());
        MercedesCalculatorDto mercedesCalculatorDto = mercedesCalculator.getOptimalSolution();
        System.out.println("Оптимальный размер заказа");
        System.out.println(mercedesCalculatorDto.optimalOrderSize);
        System.out.println("Оптимальная ожидаемая прибыль ");
        System.out.println(mercedesCalculatorDto.optimalSolution);
    }
}
