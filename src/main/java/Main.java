import Strategies.Criteria;
import Strategies.Hurwitz;
import Strategies.Minimax;
import org.jblas.DoubleMatrix;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        DoubleMatrix matrix = getMatrix();

        Criteria minimax = new Minimax(matrix);
        System.out.println(minimax.getOptimalSolution());

        Criteria hurwitz = new Hurwitz(matrix, 0.11);
        System.out.println(hurwitz.getOptimalSolution());
    }

    /**
     * @return DoubleMatrix
     */
    private static DoubleMatrix getMatrix() {
        return new DoubleMatrix(new double[][]{
                {15, 10, 0, -6, 17},
                {3, 14, 8, 9, 2},
                {1, 5, 14, 20, -3},
                {7, 19, 10, 2, 0}}
        );
    }
}
