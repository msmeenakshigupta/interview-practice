/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

class Solution {
    
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    Set<String> visited = new HashSet<>();
    Robot robot;
    
    public void cleanRoom(Robot robot) {
        this.robot = robot;  
        backtrack(0, 0, 0); // start from 0,0 and go up
    }
    
    private void backtrack(int row, int col, int direction) {
        // Clean the current box
        visited.add(row + "::" + col);
        robot.clean();
        
        // Go clockwise and visit all direction 
        // directions[0] is up, 1 is right, 2 is down, 3 is left
         for (int i = 0; i < 4; ++i) {
             // new direction will change for each iteration
             // for example if we are going right meaning current direction is 1
             // from here we will try all direction 1 + 0 (right), (1 + 1) down, (1 + 2) left ..
             int newDirection = (direction + i) % 4; // wrap around to access all direction
             
             int newRow = row + directions[newDirection][0];
             int newCol = col + directions[newDirection][1];
             
             if (!visited.contains(newRow + "::" + newCol) && robot.move()) {
                 backtrack(newRow, newCol, newDirection);
                 // come back to this cell to backtrack
                 moveBack();
             }
             
             // Rotate the robot clockwise so it can move forward to the desired direction
             // for example if it needs to go up then it need to face up
             // then when it tries to go right as per direction it needs to face right
             // same for down, right + rotateRight = robot will be facing right
             robot.turnRight();
         }
    }
    
    private void moveBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
