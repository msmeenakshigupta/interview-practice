class Solution {
    int rows =0;
	 int cols =0;
	public  int  shortestDistance(int[][] grid) {
		 rows = grid.length;
		 if (rows == 0) {
	          return -1;
	      }
		 cols = grid[0].length;
		 int noOfBuildings =0;
		 Queue<Pair<Integer,Integer>> queue = new LinkedList<>();
		 Map<String,ShortDesVO> map = new HashMap<>();
		 Set<Pair<Integer,Integer>> visited = new HashSet<>();
		 int result = Integer.MAX_VALUE;
        //O(rows*cols * ~rows*cols)
		 for(int row =0; row < rows; row++){
			 for( int col = 0; col< cols; col++){
				if(grid[row][col] ==1){
					noOfBuildings++;
					visited.clear();
					queue.offer(new Pair<Integer,Integer>(row,col));
					int level =0;
                    //O(~rows*cols)
					performBFS(queue,visited,grid,map,level);
				}
			 }
			 
		 }
        
        Set<String> keys = map.keySet();
        if(keys != null && !keys.isEmpty()){
            for(String key : map.keySet()){
                if(map.get(key).distance != 0 && map.get(key).freq== noOfBuildings){
                    result =  Math.min(result, map.get(key).distance);
                }
            }
        }
		return  result == Integer.MAX_VALUE  ?-1 :result;
		
	}
	private  void performBFS(Queue<Pair<Integer, Integer>> queue,
							Set<Pair<Integer, Integer>> visited, 
							int[][] grid,
							Map<String, ShortDesVO> map,
							int level) {
		while(!queue.isEmpty()){
			int size = queue.size();
			for( int i=0; i < size ; i++){
				Pair<Integer,Integer> node = queue.poll();
				int tmpRow = node.getKey();
				int tmpCol = node.getValue();
				// 
				if(visited.contains(node) ) continue;
					visited.add(node);
				
               String key = tmpRow +"-"+ tmpCol;
               if(!map.containsKey(key)){
                   map.put(key, new ShortDesVO());
               }
               map.get(key).freq = map.get(key).freq+1;
               map.get(key).distance = map.get(key).distance +level; 
               
			   //UP
                if(tmpRow-1 >= 0 && tmpRow-1 < rows && tmpCol>=0 && tmpCol <cols && grid[tmpRow-1][tmpCol]== 0 )
                    queue.offer(new Pair<>(tmpRow-1,tmpCol));
				
				//DOWN
                if(tmpRow+1 < rows && tmpCol>=0 && tmpCol <cols && grid[tmpRow+1][tmpCol]== 0 )
                    queue.offer(new Pair<>(tmpRow+1,tmpCol));

                //LEFT
                if(tmpRow >= 0 && tmpRow < rows && tmpCol-1>=0 && tmpCol-1 <cols && grid[tmpRow][tmpCol-1]== 0 )
                    queue.offer(new Pair<>(tmpRow,tmpCol-1));

                //RIGHT
                if(tmpRow >= 0 && tmpRow < rows && tmpCol+1 <cols && grid[tmpRow][tmpCol+1]== 0 )
                    queue.offer(new Pair<>(tmpRow,tmpCol+1));
			}
			level++;
		}
		
	}
  
}

class ShortDesVO {
	int freq;
	int distance;
}
