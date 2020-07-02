class SnakeGame {

    int width, height;
    ArrayDeque<int[]> snake;
    int[][] food;
    int whichFood;
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        snake = new ArrayDeque<>();
        snake.offer(new int[]{0,0});
        whichFood = 0; 
            
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] dir = new int[2];
        switch(direction){
            case "U" : dir = new int[]{-1,0};
                break;
            case "L" : dir = new int[]{0, -1};
                break;
            case "R" : dir =new int[] {0, 1};
                break;
            case "D" : dir = new int[]{1, 0};
                break;
        }
        int[] currPos = snake.getLast();
        int newR = dir[0]+currPos[0];
        int newC = dir[1]+currPos[1];
        if (newR >= height || newR < 0 || newC>= width || newC < 0) {
            return -1;
        }
        int[] newSpot = {newR, newC};
         if (whichFood >= food.length || (newSpot[0] != food[whichFood][0] || newSpot[1] != food[whichFood][1])) {
            snake.poll();
        }  else {
            whichFood++;
        }
        Iterator snakeIter = snake.iterator();
        while (snakeIter.hasNext()) {
            int[] snakePos = (int[]) snakeIter.next();
            if (snakePos[0] == newSpot[0] && snakePos[1] == newSpot[1]) {
                return -1;
            }
        }
        snake.offer(newSpot);
        return whichFood;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
