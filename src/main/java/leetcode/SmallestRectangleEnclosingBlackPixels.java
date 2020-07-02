class Solution {
    public int minArea(char[][] image, int x, int y) {
        int rows = image.length;
        
        int minR = x;
        int maxR = x;
        int minY = y;
        int maxY = y;
        for(int i=0; i<image.length; i++){
            for(int j=0; j<image[0].length; j++){
                if(image[i][j]=='1'){
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minY = Math.min(minY, j);
                    maxY = Math.max(maxY, j);
                }
            }
        }
        return (maxR-minR+1)*(maxY-minY+1);
        
    }
}
