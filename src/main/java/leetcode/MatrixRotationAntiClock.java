import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MatrixRotationAntiClock {

    static class Data
    {
        public int row ;
        public int col ;

        public Data(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public void setRow(int row) {
            this.row = row;
        }

        public int getCol() {
            return col;
        }

        public void setCol(int col) {
            this.col = col;
        }
    }

    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {
        int ringsCount = Math.min(matrix.size(), matrix.get(0).size())/2;

        for (int ring = 0; ring < ringsCount; ring++)
            rotate(matrix, ring, r);

        printMatrix(matrix);
    }

    private static void rotate(List<List<Integer>> matrix, int ring, int rotations) {

        int[] rowMoves = new int[] { 0, 1, 0, -1 };
        int[] colMoves = new int[] { 1, 0, -1, 0 };
        int effectiveMove = 0;

        int rowsCount = matrix.size() - 2 * ring;
        int colsCount = matrix.get(0).size() - 2 * ring;

        int itemsCount = 2 * (rowsCount + colsCount - 2);

        Data[] map = new Data[itemsCount];
        int[] values = new int[itemsCount];

        map[0] = new Data(ring, ring);
        values[0] = matrix.get(ring).get(ring);
        for (int index = 1; index < itemsCount; index++)
        {
            int row = map[index - 1].getRow() + rowMoves[effectiveMove];
            int col = map[index - 1].getCol() + colMoves[effectiveMove];

            if (IsInvalid(row, col, rowsCount, colsCount, ring))
            {
                effectiveMove++;
                row = map[index - 1].getRow() + rowMoves[effectiveMove];
                col = map[index - 1].getCol() + colMoves[effectiveMove];
            }

            map[index] = new Data(row, col);
            values[index] = matrix.get(row).get(col);
        }

        for (int index = 0; index < itemsCount; index++)
        {
            int effective = (itemsCount - (rotations % itemsCount) + index) % itemsCount;
            Data data = map[effective];
            matrix.get(data.getRow()).add(data.getCol(), values[index]);
        }

    }

    private static boolean IsInvalid(int newRow, int newCol, int rowsCount, int colsCount, int ringOffset)
    {
        return newRow < ringOffset ||
                newCol < ringOffset ||
                newRow - ringOffset >= rowsCount ||
                newCol - ringOffset >= colsCount;
    }

    static void printMatrix(List<List<Integer>> matrix){
        int rows = matrix.size();
        int cols = matrix.get(0).size();

        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                System.out.print(matrix.get(i).get(j)+ " ");
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<List<Integer>>(n);

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<Integer>(m);

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }


        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}

