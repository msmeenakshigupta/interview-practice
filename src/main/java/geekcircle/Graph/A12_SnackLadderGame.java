package com.geekcircle.Graph;

/*
 *   Author: Akshay Singhai
 *   Date:   2020-08-15
 *   Blame:  akshay.singhai@tathastu.ai
 *
 **/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class A12_SnackLadderGame {
    public static void main(String[] args) {
        snackLadderGame();
    }

    private static void snackLadderGame(){
        Map<Integer, Integer> snake = new HashMap<>();
        Map<Integer, Integer> ladder = new HashMap<>();

        // insert ladders into the map
        ladder.put(1, 38);
        ladder.put(4, 14);
        ladder.put(9, 31);
        ladder.put(21, 42);
        ladder.put(28, 84);
        ladder.put(51, 67);
        ladder.put(72, 91);
        ladder.put(80, 99);

        // insert snakes into the map
        snake.put(17, 7);
        snake.put(54, 34);
        snake.put(62, 19);
        snake.put(64, 60);
        snake.put(87, 36);
        snake.put(93, 73);
        snake.put(95, 75);
        snake.put(98, 79);

        int N = 10 * 10;
        boolean[] visit = new boolean[N];
        findSolution(ladder, snake, visit);
    }

    private static void findSolution(Map<Integer, Integer> ladder, Map<Integer, Integer> snake, boolean[] visit) {
        int[] possibility = {1,2,3,4,5,6};
        Queue<Event> queue = new LinkedList<>();
        int max = Integer.MIN_VALUE;
        Event e = new Event();
        e.currentPosition = 0;
        e.step = 0;
        queue.add(e);
        while (!queue.isEmpty()){
            Event event = queue.remove();
            max = Integer.max(max, event.step);
            for(int i = 0; i < possibility.length; i++){
                if( (event.currentPosition + possibility[i]) <= 99 && !visit[event.currentPosition + possibility[i]]){
                    int dest = event.currentPosition + possibility[i];

                    //Check Snack
                    if(snake.containsKey(event.currentPosition + possibility[i])){
                        visit[dest] = true;
                        dest = snake.get(event.currentPosition + possibility[i]);
                    }

                    //Check Ladder
                    if(ladder.containsKey(event.currentPosition + possibility[i])){
                        visit[dest] = true;
                        dest = ladder.get(event.currentPosition + possibility[i]);
                    }
                    if(!visit[dest]){
                        Event event1 = new Event();
                        event1.currentPosition = dest;
                        event1.step = event.step + 1;
                        queue.add(event1);
                        visit[dest] = true;
                    }
                }
            }
        }
        System.out.println(max);
    }
}

class Event {
    int currentPosition;
    int step;
}