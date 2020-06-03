import java.util.LinkedList;
import java.util.List;

/**
 * created by megupta on 01/05/20
 */
public class RotateMatrix {

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9,11},{ 2, 4, 8,10},{13, 3, 6, 7},{15,14,12,16}};
        print(matrix);
        rotate(matrix);
        System.out.println("\n");
        print(matrix);
    }

    private static void print(int[][] matrix){
        for(int i=0; i<4;i++){
            for(int j=0; j<4; j++){
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("");
        }

        List<Integer> list = new LinkedList<>();

    }

    public static void rotate(int[][] matrix) {
        int s = 0, e = matrix.length - 1;
        while(s < e){
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }
}
