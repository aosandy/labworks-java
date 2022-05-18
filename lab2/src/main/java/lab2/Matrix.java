package lab2;

import lab2.exceptions.SizeOverflowException;
import lab2.exceptions.ZeroDivException;

import java.util.Formatter;

public class Matrix {
    private static final int MAX_SIZE = 1000000;
    private final double [][] matrix;
    private final int size;

    public Matrix(int n) throws SizeOverflowException {
        size = n;
        if (n > MAX_SIZE) {
            throw new SizeOverflowException("N is more than " + MAX_SIZE);
        }
        matrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = (double) (Math.random() * (2 * n + 1)) - n;
            }
        }
    }

    public void rotateLeft() {
        double [][] tempMatrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                tempMatrix[i][j] = matrix[j][size - 1 - i];
            }
        }
        for (int i = 0; i < size; i++) {
            System.arraycopy(tempMatrix[i], 0, matrix[i], 0, size);
        }
    }

    public void divideBySumOfNearby() throws ZeroDivException {
        double [][] tempMatrix = new double[size][size];
        double sum;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sum = getNeighborSum(i, j);
                if (sum == 0.0) {
                    throw new ZeroDivException("Division by zero at position ("
                            + i + ";" + j + ")");
                }
                tempMatrix[i][j] = matrix[i][j] / sum;
            }
        }
        for (int i = 0; i < size; i++) {
            System.arraycopy(tempMatrix[i], 0, matrix[i], 0, size);
        }
    }

    private double getNeighborSum(int row, int col) {
        double sum = 0;
        for (int i = -1; i < 2; i++)
        {
            for (int j = -1; j < 2; j++)
            {
                if ((i == 0) && (j == 0)) {
                    continue;
                }
                if (((i + row) < 0) || ((i + row) >= size)) {
                    continue;
                }
                if (((j + col) < 0) || ((j + col) >= size)) {
                    continue;
                }
                sum += matrix[i + row][j + col];
            }
        }
        return sum;
    }

    public String printMatrix() {
        Formatter formatter = new Formatter();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                formatter.format("%10.1f", matrix[i][j]);
            }
            formatter.format("\n");
        }
        return formatter.toString();
    }
}
