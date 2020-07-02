/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int rows = dim.get(0);
        int cols = dim.get(1);
        List<Integer> rowsWithOnes = new ArrayList();
        for(int i=0; i<rows; i++){
            if(binaryMatrix.get(i, cols-1)==1)
                rowsWithOnes.add(i);
        }
        if(rowsWithOnes.size()==0)
            return -1;
        int start = 0, end = cols-1;
        int minCol = cols-1;
        while(start<end){
            int mid = (start+end)/2;
            boolean found  = false;
            for(int i=0; i<rows; i++){
                if(binaryMatrix.get(i, mid)==1){
                    found=true;
                    end = mid;
                    break;
                }
                   
            }
            if(!found)
                start=mid+1;
        }
        return end;
    }
}
