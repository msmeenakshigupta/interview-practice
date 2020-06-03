/**
 * created by megupta on 06/05/20
 */
public class UniquePaths {

    public static void main(String[] args) {
        int m=51; int n=9;
        long start = System.currentTimeMillis();
        System.out.println(uniquePaths(m,n));
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    public static int uniquePaths(int m, int n) {
        if(m==1 || n==1)
            return 1;

            int paths=uniquePaths(m-1,n) + uniquePaths(m, n-1) ;


        return paths;



    }
}
