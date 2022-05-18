package lab2;

import lab2.exceptions.FileNotExistException;
import lab2.exceptions.SizeOverflowException;
import lab2.exceptions.ZeroDivException;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src\\input.txt";
        String outputPath = "src\\output.txt";
        int iterations = 3;

        try {
            int n = 0;
            try (Scanner myReader = new Scanner(new FileReader(inputPath))) {
                n = myReader.nextInt();
            } catch (IOException e) {
                throw new FileNotExistException("File does not exist");
            } catch (NoSuchElementException e) {
                throw e;
            }
            try (FileWriter myWriter = new FileWriter(outputPath)) {
                Matrix matrix = new Matrix(n);
                for (int i = 0; i < iterations; i++) {
                    matrix.rotateLeft();
                    matrix.divideBySumOfNearby();
                    myWriter.write(matrix.printMatrix() + "\n");
                }
            } catch (Exception e) {
                throw e;
            }
        } catch (IOException | NoSuchElementException | ZeroDivException | SizeOverflowException e) {
            e.printStackTrace();
        }
    }
}
