import org.jblas.DoubleMatrix;

class Helper {

    /**
     * @return void
     */
    static void printMatrix(DoubleMatrix matrix) {
        for (int i = 0; i < matrix.getRows(); i++) {
            System.out.println(matrix.getRow(i));
        }
    }
}
