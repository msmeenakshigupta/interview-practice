import java.util.HashSet;
import java.util.Set;

/**
 * created by megupta on 01/05/20
 */
public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'}, {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        isValid = checkRows(board);
        if (isValid) {
            isValid =checkCols(board);
        }
        if (isValid) {
            isValid = checkBox(board);
        }
        return isValid;
    }

    private static boolean checkRows(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> vals = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else if (vals.contains(board[i][j])) {
                    return false;
                } else {
                    vals.add(board[i][j]);
                }

            }
        }
        return true;
    }

    private static boolean checkCols(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> vals = new HashSet<Character>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else if (vals.contains(board[j][i])) {
                    return false;
                } else {
                    vals.add(board[j][i]);
                }

            }
        }
        return true;
    }

    private static boolean checkBox(char[][] board) {
        boolean isValid = true;
        int i=0, j=0;
        while (i<9){
            int boxSize =3;

            while(j<9){
                int x=i;
                char[][] box = new char[boxSize][boxSize];
                for(int k=0; k<boxSize; k++){

                    int y=j;
                    for(int l=0; l<boxSize; l++){
                        box[k][l] = board[x][y];
                        y++;
                    }
                    x++;

                }
                isValid = check(box);
                if(!isValid)
                    return isValid;
                j+=3;
            }
            j=0;
            i+=3;
        }
        return isValid;

    }

    private static boolean check(char[][] box) {
        Set<Character> vals = new HashSet<Character>();
        for (int m = 0; m < 3; m++) {

            for (int n = 0; n < 3; n++) {
                if (box[m][n] == '.') {
                    continue;
                } else if (vals.contains(box[m][n])) {
                    return false;
                } else {
                    vals.add(box[m][n]);
                }
            }
        }
        return true;
    }


}