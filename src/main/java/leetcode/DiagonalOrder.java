import java.util.ArrayList;
import java.util.List;

/**
 * created by megupta on 14/05/20
 */
public class DiagonalOrder {

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Integer> out = readDiagonals(nums);

        return out.stream().mapToInt(Integer::intValue).toArray();
    }

    public List<Integer> readDiagonals(List<List<Integer>> nums){
        List<Integer> out = new ArrayList<Integer>();
        int rows = nums.size();
        int cols = 0;
        for(int row=0; row<rows; row++){
            cols = Math.max(cols, nums.get(row).size());
        }
        int r=0; int c=0;
        while(r<rows && c<cols){
            int dia = Math.max(r,c);
            int[][] combi = makeCombinations( dia);
            for(int i=0; i<combi.length; i++){
                int row = combi[i][0];
                int col = combi[i][1];
                if(row<rows){
                    if(cols<nums.get(row).size()){
                        out.add(nums.get(row).get(col));
                    }
                }
            }


            r++; c++;
        }

        return out;

    }

    public int[][] makeCombinations(int dia){
        int[][] combi = new int[dia+1][2];
        int r=dia;
        int c=0;
        int index = 0;
        combi[index][0]=r;
        combi[index][1]=c;
        while(dia>0){
            index++;
            r--;
            c++;
            combi[index][0]=r;
            combi[index][1]=c;
            dia--;
        }
        return combi;
    }

}
