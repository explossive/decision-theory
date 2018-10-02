import Strategies.Criteria;
import Strategies.Hurwitz;
import Strategies.Minimax;
import Strategies.Sevidg;
import org.jblas.DoubleMatrix;

/**
 *
 */
public class Main {

    private final static double c = 0.11;

    public static void main(String[] args) {
        DoubleMatrix matrix = getMatrix();

        Criteria minimax = new Minimax(matrix);
        System.out.println(minimax.getOptimalSolution());

        Criteria hurwitz = new Hurwitz(matrix, c);
        System.out.println(hurwitz.getOptimalSolution());

        Criteria sevidg = new Sevidg(matrix);
        System.out.println(sevidg.getOptimalSolution());
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
}
