package helper;

import org.jblas.DoubleMatrix;

public class MartixHelper {

    /**
     * @return void
     */
    public static void printMatrix(DoubleMatrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            System.out.println(matrix.getRow(i));
        }
    }
}
