import java.util.ArrayList;
import java.util.List;

/**
 * created by megupta on 11/05/20
 */
public class MatrixFloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][] {{1,1,1},{1,1,0},{1,0,1}};
        int sr =1; int sc = 1; int color =2;
        image = floodFill(image, sr, sc, color);

    }

    public static void printImage(int[][] image){
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[i].length; j++){
                System.out.print(image[i][j]+ "  ");
            }
            System.out.print("\n");
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int original = image[sr][sc];
        printImage(image);

        int rows = image.length;
        int cols = image[0].length;

        int[][] memo = new int[rows][cols]; //mark visited points.

        fill(image, sr, sc, original, newColor, rows, cols, memo);

        System.out.println("......... changed............");
        printImage(image);
       return image;
    }

    public  static void fill(int[][] image, int sr, int sc, int original, int newColor, int rows, int cols, int[][] memo) {
        //if sr and sc within range
        if(sr>=0 && sc>=0 && sr<rows && sc<cols){
            //run only if unvisited && color is original
            if(memo[sr][sc]==0 && image[sr][sc]==original){
                image[sr][sc] = newColor;
                memo[sr][sc] = 1;

                //call its neighbours
                fill(image, sr-1, sc, original, newColor, rows, cols, memo);
                fill(image, sr+1, sc, original, newColor, rows, cols, memo);
                fill(image, sr, sc-1, original, newColor, rows, cols, memo);
                fill(image, sr, sc+1, original, newColor, rows, cols, memo);

            }
        }






    }


}
